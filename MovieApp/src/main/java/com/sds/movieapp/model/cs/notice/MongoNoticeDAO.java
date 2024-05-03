package com.sds.movieapp.model.cs.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.client.result.DeleteResult;
import com.sds.movieapp.domain.Notice;
import com.sds.movieapp.exception.NoticeException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
public class MongoNoticeDAO implements NoticeDAO{
	
	@Autowired
	private MongoTemplate mongoTemplate; //xml 이 아닌 @Configuration 에 의해 등록됨

	public int selectCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List selectAll(Map map) {
		return mongoTemplate.findAll(Notice.class);
	}

	@Override
	public Notice select(Notice notice) {
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(notice.getId()));
		Notice dto = mongoTemplate.findOne(query, Notice.class);
		
		return dto;
	}
	
	
	public void insert(Notice notice) throws NoticeException{
		Notice dto = mongoTemplate.insert(notice);
		
		log.info("글 등록 결과는 "+dto);
		
		if(dto ==null) {
			throw new NoticeException("글등록 실패");
		}
	}

	@Override
	public void update(Notice notice) throws NoticeException{
		Notice dto = mongoTemplate.save(notice);
		
		if(dto ==null) {
			throw new NoticeException("글 수정 실패");
		}
	}

	@Override
	public void delete(Notice notice) throws NoticeException{
		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(notice.getId()));
		
		DeleteResult result = mongoTemplate.remove(query, Notice.class);
		
		if(result.getDeletedCount() < 1) {
			throw new NoticeException("글 삭제 실패");
		}
	}
	
}
