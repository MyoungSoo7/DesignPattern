package com.backend.bakckend.javaversion.version8;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
//https://jang8584.tistory.com/321


// 자바 8 2030년 12월 까지 지원
// 자바 11 2032년 1월 까지 지원
// 자바 17 2029년 9월까지 지원
// 자바 21 2031년 9월까지 지원

// 2014년에 발표
public class Main {

    public static void main(String[] args) {
        // 기존
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("test");
            }
        }).start();

        // 람다식 사용 일회 스레드
        new Thread(()-> System.out.println("일회용 스레드 생성")).start();

        // 람다식
        Runnable runnable = () -> {
            System.out.println("test");
        };

        // 삼항식에 람다식 적용
        //(x,y) -> x < y ? x : y;

        // 컬렉션
        List<String> list = Arrays.asList("a", "b", "c");;
        // 스트림
        list.stream()
                .filter(s -> s.equals("a"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(System.out::println);


        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> stream1 =Arrays.stream(arr);
        stream1.forEach(e -> System.out.println(e));
        // 배열의 특정부분만을 이용한 스트림 생성
        Stream<String> stream2 = Arrays.stream(arr, 1, 3);
        stream2.forEach(e -> System.out.println(e));


        // java.time 패키지 ( Joda-Time을 이용한 새로운 날자와 시간 API)
        LocalDate today = LocalDate.now();
        System.out.println("today : " + today);
        System.out.println("year : " + today.getYear());
        System.out.println("month : " + today.getMonth());
        System.out.println("day : " + today.getDayOfMonth());
        LocalDate otherDay = today.withYear(1985);
        System.out.println("otherDay : " + otherDay);



        // 나즈혼 ( Nashorn) :  자바스크립트의 새로운 엔진( Java와 Javascript 상호 운용성 , Javascript 코드에서 Java 사용 가능)



    }

}
