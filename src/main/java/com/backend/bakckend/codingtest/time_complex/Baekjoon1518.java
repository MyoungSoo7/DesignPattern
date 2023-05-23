package com.backend.bakckend.codingtest.time_complex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon1518 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        // 넓이
        int W = Integer.parseInt(st.nextToken());
        // 높이
        int H = Integer.parseInt(st.nextToken());
        // W * H 의 격자 공간

        st = new StringTokenizer(br.readLine()," ");

        // 현재 위치
        int P = Integer.parseInt(st.nextToken());
        // 현재 위치
        int Q = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        // 계산할 시간
        int T = Integer.parseInt(st.nextToken());


        // 실시간 x좌표는 P에서 시간(T)을 넓이 2배 즉 좌에서 우와 우에서 좌를 반복하는 양의 나머지에 위치
        int currentX = (P+T) % (2 * W);
        // 실시간 y좌표는 Q에서 시간(T)을 늪이 2배 즉 위에서 아래와 아래에서 위를 반복하는 양의 나머지에 위치
        int currentY = (Q+T) % (2 * H);
        if(currentX > W) currentX = 2*W - currentX;
        if(currentY > H) currentY = 2*H - currentY;

        System.out.println(currentX+" "+currentY);

    }
}
