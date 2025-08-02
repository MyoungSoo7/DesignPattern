package com.backend.bakckend.variable;

import java.io.Serializable;
import java.math.BigDecimal;

public class JungSuk1 implements Serializable {
    // volatile 키워드를 사용하여 멀티스레드 환경에서 flag 변수의 변경을 즉시 인지할 수 있도록 함
    // 해당 변수가 여러 스레드에서 접근될 경우 항상 메모리에서 값을 읽고, 변경된 데이터를 즉시 메모리에 기록하도록 지정
    /*변수 값이 변경되면 모든 스레드가 즉시 변경 사항을 인지.
    CPU 캐시를 무시하고 메모리에서 값을 읽음.*/

    private volatile boolean flag = true;
    private String username;
    private transient String password; // 직렬화에서 제외 민감한 데이터(예: 비밀번호)가 직렬화 대상에서 제외 가능.

    public void someMethod() {
        while (flag) {
            // flag가 변경될 경우 즉시 인지
        }
    }


    // 하드웨어는 64비트(double) 대신 내부적으로 80비트 연산을 사용
    // 이 경우, strictfp는 JVM이 64비트(Double) IEEE 754 연산을 강제하도록 만듭니다.
    public strictfp double calculateStrict() {
        double a = 0.1;
        double b = 0.2;
        return a + b; // strictfp가 적용됨
    }



    public static void main(String[] args) {
        JungSuk1 example = new JungSuk1();
        double strictResult = example.calculateStrict();

        BigDecimal a = new BigDecimal("0.1");
        BigDecimal b = new BigDecimal("0.2");
        BigDecimal sum = a.add(b);

        var result=1;


    }
}
