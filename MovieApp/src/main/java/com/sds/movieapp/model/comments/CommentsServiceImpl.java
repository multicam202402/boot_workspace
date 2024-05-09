package com.sds.movieapp.model.comments;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.movieapp.domain.CommentsDoc;
import com.sds.movieapp.domain.MovieDoc;

import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.util.common.model.Pair;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
public class CommentsServiceImpl implements CommentsService{
	
	@Autowired
	private Komoran komoran;
	
	public void registComments(CommentsDoc commentsDoc, MovieDoc movieDoc) {
		
		//코모란 에게 영화평을 형태소 단위로 나누도록 시키자
		KomoranResult result = komoran.analyze(commentsDoc.getContent());
		
		List< Pair<String, String> > resultList = result.getList();
		for( Pair<String, String> pair : resultList) {
			log.debug(pair.getFirst()+", "+pair.getSecond());
		}
	}

}





