package com.sds.movieapp.model.cs.notice;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

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
	public void insert(Notice notice) throws NoticeException{
		Notice dto = mongoTemplate.insert(notice);
		
		log.info("글 등록 결과는 "+dto);
		
		if(dto ==null) {
			throw new NoticeException("글등록 실패");
		}
	}

	@Override
	public void update(Notice notice) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Notice notice) {
		// TODO Auto-generated method stub
		
	}
	
}