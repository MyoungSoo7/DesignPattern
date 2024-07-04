package com.backend.bakckend.javaversion.version8;

import java.util.Optional;

public class OptionalTest {

    public static void main(String[] args) {

        Optional<String> optional = Optional.of("Hello, World!");

        // 값이 존재하면 출력
        optional.ifPresent(System.out::println);

        Optional<String> opt = Optional.of("자바 Optional 객체");
        opt.ifPresent(System.out::println);

        String result = opt.orElse("빈 Optional 객체");
        System.out.println(result);

        try {
            String value = opt.orElseThrow(() -> new IllegalArgumentException("값이 없습니다."));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        Optional<Integer> length = opt.map(String::length);
        length.ifPresent(System.out::println);
    }
}
