package com.woori.movieinfo.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//사용자 변수 및 메소드를 빈에 등록
//기존에 스프링부트에서 제공하는 않는 새로운 메소드를 등록
@Configuration
public class AppConfig {
    //modelmapper 자동 생성하게 하는 메소드
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
