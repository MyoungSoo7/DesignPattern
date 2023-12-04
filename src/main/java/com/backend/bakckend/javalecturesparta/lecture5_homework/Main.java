package com.backend.bakckend.javalecturesparta.lecture5_homework;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Book> bookList = Arrays.asList(
                new Book(1L, "모두의 딥러닝", "조태호", "IT", 21600),
                new Book(2L, "이득우의 게임 수학", "이득우", "IT", 40500),
                new Book(3L, "자바 웹 개발 워크북", "구멍가게 코딩단", "IT", 31500),
                new Book(4L, "실전 시계열 분석", "에일린 닐슨", "IT", 34200),
                new Book(5L, "데이터 분석가의 숫자유감", "권정민", "IT", 14400),
                new Book(6L, "스프링 부트 실전 활용 마스터", "그렉 턴키스트", "IT", 25200),
                new Book(7L, "오늘부터 IT를 시작합니다", "고코더", "IT", 16200),
                new Book(8L, "그림으로 이해하는 인지과학", "기타하라 요시노리", "IT", 16200),
                new Book(9L, "괜찮아, 그 길 끝에 행복이 기다릴 거야", "손미나", "여행", 17100),
                new Book(10L, "여행의 이유", "김영하", "여행", 12150),
                new Book(11L, "여행의 시간", "김진애", "여행", 16200),
                new Book(12L, "로봇 시대 살아남기", "염규현", "역사", 14850),
                new Book(13L, "경제 전쟁의 흑역사", "이완배", "역사", 15750),
                new Book(14L, "100가지 동물로 읽는 세계사", "사이먼 반즈", "역사", 29700),
                new Book(15L, "k 배터리 레볼루션", "박순혁", "경제", 17100),
                new Book(16L, "정하준의 경제학 레시피", "장하준", "경제", 16200),
                new Book(17L, "레버리지", "롭 무어", "경제", 16200)
        );

        // filter, map, forEach, max, sum, toList, contains, setPrice

        //filter 와 forEach
        bookList.stream()
                .filter(x -> x.getCategory().equals("여행"))
                .forEach(x -> System.out.println(x.getBookName()));
        //filter 와 forEach
        bookList.stream()
                .filter(x -> x.getPrice() <= 16200)
                .forEach(x -> System.out.println(x.getBookName()));
        //filter 와 forEach
        bookList.stream()
                .filter(x -> x.getBookName().contains("경제"))
                .forEach(x -> System.out.println(x.getBookName()));

        // map 의 활용 mapToDouble max().getAsDouble()
        double maxPrice = bookList.stream().mapToDouble(Book::getPrice).max().getAsDouble();
        System.out.println("가장 비싼 책 금액"+maxPrice);

        // map 의 활용 mapToDouble sum()
        double sum = bookList.stream()
                .filter(x -> x.getCategory().equals("IT")).mapToDouble(Book::getPrice).sum();
        System.out.println("IT 카테고리 책 가격 합계"+sum);

        // map 의 활용 익명함수 return
        List<Book> discountedItBook = bookList.stream().filter(x -> x.getCategory().equals("IT"))
                .map(x->{
                    x.setPrice(x.getPrice()*0.6);
                    return x;
                }).toList();

        for(Book book : discountedItBook){
            System.out.println( "책과 가격 => "+book.getBookName() + " : " + book.getPrice() ) ;
        }


    }
}

class Book {
    // 분류번호
    private Long id;
    // 책 이름
    private String bookName;
    // 작가 이름
    private String author;
    // 카테고리
    private String category;
    // 가격
    private double price;

    public Book(Long id, String bookName, String author, String category, double price) {
        this.id = id;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.price = price;
    }

    public String getBookName() {
        return bookName;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}