package com.backend.bakckend.codingtest.control;

public class StringManipulation {

    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;
        while(left < right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static String compressString(String str){
        StringBuilder sb = new StringBuilder();
        int count =1;
        for(int i = 0; i < str.length(); i++){
            if(i == str.length()-1 || str.charAt(i) != str.charAt(i+1)){
                sb.append(str.charAt(i));
                sb.append(count);
                count = 1;
            }else{
                count++;
            }
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        String str1 = "Hello, ";
        String str2 = "World!";

        int length = str1.length();

        System.out.println("문자열 길이: " + length);
        System.out.println("문자열 추출: " + str1.substring(3, 5));

        String str3 = str1 + str2;

        String reverse = new StringBuilder(str3).reverse().toString();
        System.out.println("문자열 역순: " + reverse);

        System.out.println("회문여부 : " + isPalindrome("level"));

        String str = "aaabbcccc";
        String compressed = compressString(str);
        System.out.println("압축된 문자열: " + compressed);



    }
}
