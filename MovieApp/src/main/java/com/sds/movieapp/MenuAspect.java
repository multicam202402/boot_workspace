package com.sds.movieapp;

import org.springframework.stereotype.Component;

//스프링 mvc에서는 xml 파일에서 빈을 설정할 수 있었지만, 스프링부트에서는 
//@Configuration 클래스에서 담당한다, 따라서 아래의 클래스를 Aspect로 등록하여 aop를 구현해보자

@Aspect
@Component
public class MenuAspect {

}
