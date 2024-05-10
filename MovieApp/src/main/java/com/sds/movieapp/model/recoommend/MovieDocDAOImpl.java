package com.sds.movieapp.model.recoommend;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sds.movieapp.domain.MovieDoc;

@Repository
public class MovieDocDAOImpl implements MovieDocDAO{
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public int selectCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List selectAll(Map map) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieDoc select(int movie_idx) {
		Query query = new Query();
		query.addCriteria(Criteria.where("movie_idx").is(movie_idx));
		MovieDoc movieDoc = mongoTemplate.findOne(query, MovieDoc.class);
		
		return movieDoc;
	}

	@Override
	public void insert(MovieDoc movieDoc) {
		// TODO Auto-generated method stub
		
	}

}
