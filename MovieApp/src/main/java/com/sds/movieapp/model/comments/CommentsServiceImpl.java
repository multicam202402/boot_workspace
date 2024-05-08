package com.sds.movieapp.model.comments;

import org.springframework.stereotype.Service;

import com.sds.movieapp.domain.CommentsDoc;
import com.sds.movieapp.domain.MovieDoc;

import kr.co.shineware.nlp.komoran.core.Komoran;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentsServiceImpl implements CommentsService{

	private Komoran komoran;
	
	@Override
	public void registComments(CommentsDoc commentsDoc, MovieDoc movieDoc) {
		
		log.debug("댓글 등록 하렵니다");
		
	}


	
}
