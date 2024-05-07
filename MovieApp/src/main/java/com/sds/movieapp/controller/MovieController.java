package com.sds.movieapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sds.movieapp.domain.CustomUserDetails;
import com.sds.movieapp.domain.Member;
import com.sds.movieapp.domain.Movie;
import com.sds.movieapp.model.movie.MovieService;

@Controller
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	//영화 상세보기 요청
	@GetMapping("/movie/detail")
	public String getDetail(Model model ,@RequestParam(value="movie_idx", defaultValue="0") int movie_idx) {
		
		//최종적으로 우리 mysql의 정보와 + open API의 영화정보가 합쳐진 DTO 가져옴 
		Movie movie = movieService.select(movie_idx);//영화 한건 조회 
		System.out.println("영화 url은 "+movie.getUrl());
		System.out.println("영화명 "+movie.getMovieNm());
		
		model.addAttribute("movie", movie);
		
		//스프링 시큐리티가 로그인을 처리했기 때문에, 스프링 시큐리티를 통해서 유저 정보를 꺼내서. 
		// detail.html에서 사용할 수 잇도록  request 객체에 저장해놓아야 함.. 
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		String nickname = auth.getName();
		
		//auth.getPrincipal() 로그인 하지 않았을 경우 스프링 시큐리티가 auth.getPrincipal() 메서드의 반환값으로 
		//anonymousUser 를 반환함..따라서 조건문으로 처리해야 함 
		
		//아래의 if문은 로그인한 경우 동작함
		if(auth.getPrincipal() instanceof CustomUserDetails) {
			CustomUserDetails userDetails = (CustomUserDetails)auth.getPrincipal();
			Member member = userDetails.getMember();
			
			model.addAttribute("member", member);
		} 
		return "movie/detail";
	}
	
}
