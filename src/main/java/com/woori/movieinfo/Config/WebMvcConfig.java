package com.woori.movieinfo.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//기존 webMvc기능을 변경하여 재등록(오버라이딩)
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    //WebMvcConfigurer 클래스를 상속을 받아서(Resources 관리하는 클래스)
    @Value("${uploadPath}") //application.properites에 선언된 변수의 값을 읽어와서 아래쪽 변수에 적용
    private String uploadPath;

    //addResourcehanders에 함수의 내용을 수정
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        //ResourcehandlerRegistry : 자원의 정보를 가지고 있는 변수
        //만약에 /upload/**(이후상관없음) 호출이 오면 file://c:/movie로 연결
        registry.addResourceHandler("/upload/**")
                .addResourceLocations(uploadPath);

        //Resource에 외부 폴더를 연결하는것을 추가
    }

}
/*
오버로딩 : 동일한 메소드명으로 여러개를 작성, 인수의 데이터형 또는 갯수가 달라야 함
          (해당 클래스내에서 작성)
      void main()
      void main(int a)
      void main(int a, int b)
      void main(String a)
오버라이딩 : 기존에 메소드의 내용을 변경해서 사용(클래스를 상속받아서 이용)
    void main() {
        system.out.print("연습");
    }

    @override - 기존메소드 변경한 메소드, 생략가능
    void main() {
       int a=5;
       int b=3;
       system.out.println(a+b);
    }
인터페이스 : 메소드명만 선언된 메소드의 내용을 추가(클래스를 인터페이스 상속받아서 이용)
    void main() {}

    void main() {
        system.out.print("인터페이스");
    }
 */
