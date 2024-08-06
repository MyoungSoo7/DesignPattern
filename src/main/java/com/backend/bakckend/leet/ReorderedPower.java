package com.backend.bakckend.leet;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ReorderedPower {

    public boolean reorderedPowerOf2(int n) {
        // 2의 거듭제곱을 미리 계산하여 문자열로 저장
        Set<String> powerOf2 = new HashSet<>();
        for (int i = 0; i < 31; i++) {
            powerOf2.add(sortedString(1 << i));
        }

        // 주어진 숫자의 자릿수를 문자열로 변환하고 정렬
        String nStrSorted = sortedString(n);

        // 미리 계산한 2의 거듭제곱 문자열들과 비교
        return powerOf2.contains(nStrSorted);
    }

    private String sortedString(int num) {
        char[] chars = String.valueOf(num).toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }


}
