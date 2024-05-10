package com.sds.movieapp.model.recoommend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.apache.mahout.cf.taste.impl.model.GenericPreference;
import org.apache.mahout.cf.taste.model.Preference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sds.movieapp.domain.CommentsDoc;
import com.sds.movieapp.domain.MovieDoc;
import com.sds.movieapp.model.comments.CommentsDocDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RecommendServiceImpl implements RecommendService{

	@Autowired
	private CommentsDocDAO commentsDocDAO;
	
	@Autowired
	private MovieDocDAO movieDocDAO;
	
	public List getList(int member_idx) {
		
		/*-----------------------------------------
		 1) 영화평 리스트를 Mahout  전용  List로 전환
		      -  List  는 Preference로 이루어진 List 로 전환 
		      -  CommentsDoc  는  Preference 로 전환  
		      
		 2) 영화에 대한 메타정보도 수집하자 
		-----------------------------------------*/
		List<CommentsDoc> commentsList = commentsDocDAO.selectAllByMemember(member_idx);
		Map<Long, MovieDoc> metadataMap = new HashMap();//해당 영화평에 대한 영화들을 모아놓을 맵
		
		List<Preference> preferences = new ArrayList();
		
		for(int i=0; i<commentsList.size();i++) {
			CommentsDoc doc = commentsList.get(i);
			GenericPreference preference = new GenericPreference((long)doc.getMember_idx(), doc.getMovie_idx(), doc.getScore()); 
			preferences.add(preference);
			
			MovieDoc movieDoc = movieDocDAO.select( doc.getMovie_idx() );
			metadataMap.put((long)movieDoc.getMovie_idx(), movieDoc);
			
		}
		
		/*-----------------------------------------
		 영화평 리스트에서, 긍정 평가한 리스트 추려내기
		-----------------------------------------*/
		preferences.stream().forEach(m -> log.debug("긍정평가 전 영화명 "+metadataMap.get(m.getItemID())));
		
		List<MovieDoc> likedMovies =preferences.stream()
			.filter(p -> p.getValue() >=2.0 )  //추려내는게 목적인 메서드 따라서 filter  수행 후 리스트는 줄어들 수 있다.
			.map(p -> metadataMap.get(p.getItemID()))
			.collect(Collectors.toList()); //최종 메서드
		
		//긍정 평가 리스트 출력 테스트
		likedMovies.stream().forEach(m -> log.debug("긍정 평가한 영화명은 "+m.getMovieNm()));
		
	
		

		return null;
	}
	
}







