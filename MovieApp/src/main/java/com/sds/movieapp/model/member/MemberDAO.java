package com.sds.movieapp.model.member;

import org.apache.ibatis.annotations.Mapper;

import com.sds.movieapp.domain.Member;

@Mapper
public interface MemberDAO {
	public int insert(Member member); //회원등록
	
}
