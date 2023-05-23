package com.spring.core.chap04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fs")
public class FusionRestaurant implements Restaurant {
    // 셰프
    @Autowired // 컨테이너에 든 자료 중 Chef에 대입할 수 있는것을 자동으로 집어넣어라
    private Chef chef;

    // 요리 코스
    @Autowired
    private Course course;

    // 세터 주입은 세터 위에 @Autowired 어노테이션을 붙여 설정
    @Autowired // @Qualifier를 파라미터 왼쪽에 붙
    public void setChef(@Qualifier("jc")Chef chef){
        this.chef = chef;
    }

    @Autowired
    public void setCourse(@Qualifier("jco") Course course){
        this.course = course;
    }

    // FusionRestaurant 내부에서 무슨 Chef와 Course가 들어올지 결정하지 않음
    @Autowired
    // 주입받을 파라미터 왼쪽에 @Qualifier("빈이름")을 입력하면, 지정주입이 가능
    public FusionRestaurant(@Qualifier("cc") Chef chef, @Qualifier("cco") Course course){
        this.chef = chef;
        this.course = course;
    }

    @Override
    public void order(){
        System.out.println("여기는 퓨전 레스토랑입니다.");
        course.combineMenu();
        chef.cook();
    }
}


