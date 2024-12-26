package com.woori.movieinfo.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Builder
public class MovieDTO {
    @Schema(description="영화정보 일련번호", example="1")
    private Integer code; //일련번호
    @Schema(description="영화제목", example="범죄도시")
    private String name;
    @Schema(description="영화감독", example="이상용")
    private String director;
    @Schema(description="제작국가", example="한국")
    private String nation;
    @Schema(description="장르", example="액션")
    private String genre;
    @Schema(description="주연", example="마동석")
    private String actor;
    @Schema(description="개봉일", example="2024-05-01")
    private String opendate;
    @Schema(description="영화소개", example="재밌다.")
    private String synopsis;
    @Schema(description="영화포스터파일", example="sample.jpg")
    private String poster;
}
