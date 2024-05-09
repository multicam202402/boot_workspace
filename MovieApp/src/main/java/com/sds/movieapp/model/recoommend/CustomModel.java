package com.sds.movieapp.model.recoommend;

import org.apache.mahout.cf.taste.impl.model.GenericDataModel;
import org.apache.mahout.cf.taste.model.DataModel;

import lombok.extern.slf4j.Slf4j;

//우리가 작성한 영화평 데이터를 이용한 데이터 모델 생성하기 위한 객체
@Slf4j
public class CustomModel {
	private DataModel dataModel; //이 모델이 우리가 보유한 데이터를 이해하도록 코드 작성.. 
	
	public CustomModel() {
		
		//Map<사용자id , [ {영화평점들}, {영화평점들},{영화평점들},{영화평점들},{영화평점들},]  >
		
		
		//dataModel = new GenericDataModel(null);
	}
}
