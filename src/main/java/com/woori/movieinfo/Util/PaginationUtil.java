package com.woori.movieinfo.Util;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//페이지 처리에 필요한 메소드를 담은 클래스
@Component
public class PaginationUtil {
    public static Map<String, Integer> pagination(Page<?> page) {
        Map<String, Integer> map = new HashMap<>(); //결과를 저장할 변수

        //전체 레코드수
        long ltotalRecords = page.getTotalElements();
        //삼항식 : 변수 = 조건?맞으면:틀리면
        //레코드번호가 처리할 수가 정수의 수를 넘으면 정수의 최대값으로, 그렇지 않으면 전체레코드수로 저장
        int totalRecords = (ltotalRecords>Integer.MAX_VALUE)?Integer.MAX_VALUE:(int)ltotalRecords;

        int currentPage = page.getNumber()+1; //현재페이지 번호
        int blockLimit = 10; //화면에 출력할 페이지번호의 수(1,2,3,4,5,6,7,8,9,10)
        int totalPages = page.getTotalPages(); //전체페이지 수

        //Math.max(값,값,값,....) : 값들 중 최대값을 추출
        //계산된 페이지번호가 1보다 작으면 1을 적용, 크면 해당페이지번호를 시작페이지번호
        int startPage = Math.max(1, currentPage-blockLimit/2);  //화면에 시작번호
        //계산된 끝페이지번호가 전체페이지번호보다 크면 전체페이지
        int endPage = Math.min(totalPages, currentPage+blockLimit-1); //화면에 끝나는 번호

        //이전/다음 페이지 번호
        int prevPage = Math.max(1, currentPage-1); //계산된 페이지가 1보다 작으면 1페이지를 적용
        int nextPage = Math.min(totalPages, currentPage+1);

        int lastPage = totalPages; //마지막 페이지 번호

        //처음(1) 이전(prevPage) 1(startPage) 2 3(currentPage) 4 5(endPage) 다음(nextPage) 마지막(lastPage)
        map.put("prevPage", prevPage);
        map.put("startPage", startPage);
        map.put("currentPage", currentPage);
        map.put("endPage", endPage);
        map.put("nextPage", nextPage);
        map.put("lastPage", lastPage);
        map.put("totalPages", totalPages);

        return map;
    }
}
