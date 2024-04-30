package com.sds.movieapp.model.movie;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MovieDAO {
	
	public int selectCount(); //총 레코드 수 
	public List selectAll(Map map);
	
}
