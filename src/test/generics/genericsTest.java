package test.generics;

import java.util.ArrayList;


interface ISample<T> {
    public void addElement(T t, int index);
    public T getElement(int index);
}

class Sample<T> implements ISample<T> {
    private T[] array;

    public Sample() {
        array = (T[]) new Object[10];
    }

    @Override
    public void addElement(T element, int index) {
        array[index] = element;
    }

    @Override
    public T getElement(int index) {
        return array[index];
    }
}
//////////////////////////////////////////////////
interface IAdd<T> {
    public T add(T x, T y);
}
//////////////////////////////////////////////////
class FruitBox<T, U> {
    // 독립적으로운영되는 제네릭 메서드
    public <T, U> void printBox(T x, U y) {
        // 해당 매개변수의 타입 출력
        System.out.println(x.getClass().getSimpleName());
        System.out.println(y.getClass().getSimpleName());
    }
}

// 제네릭(Generics)은 클래스 내부에서 사용할 데이터 타입을 외부에서 지정하는 기법을 의미
public class genericsTest {
    public static void main(String[] args) {

        Sample<String> sample = new Sample<>();
        sample.addElement("This is string", 5);
        sample.getElement(5);

        System.out.println("/////////////////////////////////////////////////////");
        // 제네릭을 통해 람다 함수의 타입을 결정
        IAdd<Integer> o = (x, y) -> x + y; // 매개변수 x와 y 그리고 반환형 타입이 int형으로 설정된다.

        int result = o.add(10, 20);
        System.out.println(result); // 30

        System.out.println("/////////////////////////////////////////////////////");
        FruitBox<Integer, Long> box1 = new FruitBox<>();

        // 인스턴스화에 지정된 타입 파라미터 <Integer, Long>
        box1.printBox(1, 1);

        // 하지만 제네릭 메서드에 다른 타입 파라미터를 지정하면 독립적으로 운용 된다.
        box1.<String, Double>printBox("hello", 5.55);
        box1.printBox("hello", 5.55); // 생략 가능



    }
}
