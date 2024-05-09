package com.sds.movieapp.model.recoommend;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.mahout.cf.taste.model.PreferenceArray;
import org.springframework.stereotype.Service;

import com.sds.movieapp.domain.CommentsDoc;
import com.sds.movieapp.domain.MovieDoc;
import com.sds.movieapp.model.comments.CommentsDocDAO;

@Service
public class RecommendServiceImpl implements RecommendService{

	private CommentsDocDAO commentsDocDAO;
	
	public List getList(int member_idx) {
		
		/*-----------------------------------------
		 1) 1차적으로 유저가 등록한 모든 영화평을 수집하자
		 2) 영화에 대한 메타정보도 수집하자 
		-----------------------------------------*/
		List<CommentsDoc> commentsList = commentsDocDAO.selectAllByMemember(member_idx);
		Map<Long, MovieDoc> metadataMap = new HashMap();//해당 영화평에 대한 영화들을 모아놓을 맵
		

		//위에서 수집한 순수한 List를  머아웃이 지원하는 전용  List로 전환
		//단 PreferenceArray는 머아웃 라이브러리가 지워하는 데이터 모델로 부터 얻어올 수 있다
		//그리고 이 모델은 우리가 정의하는 것이다..(사용자가 등록한 영화평 정보를 이용하여 모델을 만들어내야 함)
		PreferenceArray preferenceArray = null;
		
		
		
		
		return null;
	}
	
}
