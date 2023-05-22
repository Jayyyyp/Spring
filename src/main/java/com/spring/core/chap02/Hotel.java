package com.spring.core.chap02;

/*
*   스프링 의존성 주입이 사용되지 않아 생기는 문제
*   호텔 클래스 내부에서 현재 직접 객체를 생성해주는 코드의 경우
*   나중에 의존객체를 변경해야 할 때 직접 호텔클래스 내부를 수정해야 한다.
*   이 경우, OCP를 위배하게 된다.
*   심지어 Hotel에서 셰프를 변경한다면, 레스토랑 내부에서 변경해야 하므로,
*
* */
public class Hotel {

    // 제어의 역전 (IOC) : 객체 생성의 제어권을 Hotel이 아닌 외부로 넘긴다.
    // 의존성 주입 (DI) : Hotel 생성시 외부에서 이미 생성된 객체를 주입하는 개념

    // 호텔 내부에 입점한 레스토랑 선언
    private Restaurant restaurant;

    // 수석 셰프
    private Chef chef;

    public Hotel(Restaurant restaurant, Chef chef){
        // 생성자의 파라미터로 들어온 객체를 레스토랑, 셰프로 주입한다.
        this.restaurant = restaurant;
        this.chef = chef;
    }

    // 호텔의 정보를 알려주기
    public void  inform(){
        String chefName = chef.getClass().getSimpleName();
        String restaurantName = restaurant.getClass().getSimpleName();
        // 안내멘트
        System.out.println("우리 호텔의 레스토랑은 " + restaurantName + "이며, 수석 셰프는 " + chefName + "입니다.");

        // 요리가 순서대로 나옴
        restaurant.order();
    }
}
