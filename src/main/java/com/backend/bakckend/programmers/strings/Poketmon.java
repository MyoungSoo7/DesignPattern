package com.backend.bakckend.programmers.strings;

import java.util.HashMap;
import java.util.Map;

public class Poketmon {
    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer,Integer> poketmonMap = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            if(poketmonMap.getOrDefault(nums[i],0) == 0) {
                poketmonMap.put(nums[i], 1);
            }
        }
        for(Integer poketmon : poketmonMap.keySet()) {
            answer++;
            if(answer == nums.length/2) {
                return answer;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Poketmon poketmon = new Poketmon();
        int poketmonCount = poketmon.solution(new int[]{3,1,2,3});
        System.out.println(poketmonCount);

    }
}
