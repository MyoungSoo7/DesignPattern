package com.backend.bakckend.javaversion.version9;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

//https://jang8584.tistory.com/321
public class Main {


    public static void main(String[] args) {

        // 컬렉션 쉽게 추가(of 사용)
        List<String> lsit = List.of("a", "b", "c","c");
        Set<String> set = Set.of("a", "b", "c","d");
        Map<String,String> map = Map.of("a","b","c","d");

        // Stream ( takeWhile, dropWhile , iterate 추가)
        Stream<String> stream = Stream.iterate("", s -> s + "s")
                .takeWhile(s -> s.length() < 10);

        //System.out.println(stream.forEach(System.out::println));

        // Optional (ifPresentOrElse 크게 누락)



    }
}
