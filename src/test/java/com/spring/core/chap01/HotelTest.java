package com.spring.core.chap01;

import org.junit.jupiter.api.Test;

public class HotelTest {

    @Test
    public void hotelTest(){
        // 현재 호텔에는 한식당이 입점해 있음
        Hotel hotel = new Hotel();
        hotel.inform();
    }
}
