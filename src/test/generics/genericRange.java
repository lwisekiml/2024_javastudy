package test.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;// 숫자만 받아 계산하는 계산기 클래스 모듈
class Calculator<T /* extends Number */> {
    void add(T a, T b) {}
    void min(T a, T b) {}
    void mul(T a, T b) {}
    void div(T a, T b) {}
}
////////////////////////////////////////////////////////
interface Readable {
}

// 인터페이스를 구현하는 클래스
class Student implements Readable {
}

// 인터페이스를 Readable를 구현한 클래스만 제네릭 가능
class School <T extends Readable> {
}
////////////////////////////////////////////////////////

public class genericRange {
    public static void main(String[] args) {
        // 제네릭에 아무 타입이나 모두 할당이 가능
        Calculator<Number> cal1 = new Calculator<>();
        Calculator<Object> cal2 = new Calculator<>();
        Calculator<String> cal3 = new Calculator<>();
        Calculator<genericRange> cal4 = new Calculator<>();

        System.out.println("////////////////////////////////////////////////////////");
        // 타입 파라미터에 인터페이스(Readable)를 구현한 클래스만이 올수 있게 됨
        School<Student> a = new School<Student>();

        System.out.println("////////////////////////////////////////////////////////");
        List<Integer> lists = new ArrayList<>(Arrays.asList(1, 2, 3));
        print(lists); // OK
    }

    public static void print(List<? extends Number> list) {
        for (Object e : list) {
            System.out.println(e);
        }
    }
}
