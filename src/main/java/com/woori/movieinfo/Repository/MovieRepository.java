package com.woori.movieinfo.Repository;

import com.woori.movieinfo.Entity.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
}
/*
    [기본 메소드]
    Save() : 삽입, 수정
        Entity 변수명 = repository.save(entity값)
    FindById() : 기본키로 조회
        Optional<Entity> 변수명 = repository.findById(기본키값)
    DeleteById() : 기본키로 삭제
        repository.deleteById(기본키값)
    DeleteAll() : 모두 삭제
        repository.deleteAll()

    [사용자가 쿼리메소드]-수정 또는 조회
    List<Entity> findBy변수명(인수 변수명) : 변수명과 인수변수는 1:1 매치
        List<Entity> findBySubject(String Subject)

    모두 만족하는 값을 조회
    List<Entity> findBy변수명1And변수명2..(인수변수명1, 인수변수명2,...)
        List<Entity> findBySubjectAndAge(String subject, Integer age)

    조건중 하나라도 만족하면 조회(검색조건)
    List<Entity> findBy변수명1Or변수명2..(인수변수명1, 인수변수명2,...)
        List<Entity> findBySubjectOrAge(String subject, Integer age)

    조회한 내용을 정렬
    List<Entity> findBy검색할변수명OrderBy정렬할변수명DESC/ASC(정렬방식)
    List<Entity> findByAgeOrderBySubjectDESC(int age)

    페이지 단위로 조회
    Page<Entity> findBy~
 */
