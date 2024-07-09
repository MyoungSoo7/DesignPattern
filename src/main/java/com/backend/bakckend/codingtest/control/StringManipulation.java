package com.backend.bakckend.codingtest.control;

import java.util.Arrays;

public class StringManipulation {


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

        boolean isAnagram1 = isAnagram(str1, str2);
        System.out.println("아나그램 여부: " + isAnagram1);
        String str4 = "listen";
        String str5 = "silent";
        boolean isAnagram2= isAnagram(str4, str5);
        System.out.println("아나그램 여부: " + isAnagram2);

        String str6 = "aaabbcccc";
        String compressed = compressString(str6);
        System.out.println("압축된 문자열: " + compressed);

        String[] strs = {"flower", "flow", "flight"};
        String longestCommonPrefix = longestCommonPrefix(strs);
        System.out.println("가장 긴 공통 접두사: " + longestCommonPrefix);


    }

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
    public static boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }

    public static String longestCommonPrefix(String[] str){
        if(str == null || str.length == 0) return "";
        String prefix = str[0];
        for(int i =1 ; i< str.length ; i++){
            while(str[i].indexOf(prefix) != 0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
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


}
