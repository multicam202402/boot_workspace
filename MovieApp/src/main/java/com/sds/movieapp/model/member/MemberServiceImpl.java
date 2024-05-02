package com.sds.movieapp.model.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.movieapp.domain.Member;

@Service
public class MemberServiceImpl implements MemberService{

	@Autowired
	private MemberDAO memberDAO;

	public void regist(Member member) {
		
	}
	
}
