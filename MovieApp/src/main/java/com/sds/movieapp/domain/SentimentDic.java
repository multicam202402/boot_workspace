package com.sds.movieapp.domain;

import org.springframework.data.annotation.Id;

import lombok.Data;

@Data
public class SentimentDic {
	@Id
	private String id;
	
	private String ngram;
	private double freq;
	private double COMP;
	private double NEG;
	private double NEUT;
	private double None;
	private double POS;
	private Max max;
	
	public static class Max{
		private String value;
		private int prop;
	} 
}
