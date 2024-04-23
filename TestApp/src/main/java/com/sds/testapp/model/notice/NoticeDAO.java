package com.sds.testapp.model.notice;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sds.testapp.domain.Notice;

@Mapper
public interface NoticeDAO {
	public List selectAll(); //모두 가져오기 
	public Notice select(int notice_idx); //한건 가져오기 
	public int insert(Notice notice);//한건 넣기
	public int update(Notice notice); //한건 수정 
	public int delete(Notice notice); //한건 삭제   
	
}
