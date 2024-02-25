package test.enumClass;

import java.util.function.DoubleBinaryOperator;

//enum Operation {
//    PLUS("+") {
//        public double apply(double x, double y) {
//            return x + y;
//        }
//    },
//    MINUS("-") {
//        public double apply(double x, double y) {
//            return x - y;
//        }
//    },
//    MULTI("*") {
//        public double apply(double x, double y) {
//            return x * y;
//        }
//    },
//    DIVIDE("/") {
//        public double apply(double x, double y) {
//            return x / y;
//        }
//    };
//
//    // 클래스 생성자와 멤버
//    private final String symbol;
//
//    Operation(String symbol) {
//        this.symbol = symbol;
//    }
//
//    // toString을 재정의하여 열거 객체의 매핑된 문자열을 반환하도록
//    @Override
//    public String toString() {
//        return symbol;
//    }
//
//    // 열거 객체의 메소드에 사용될 추상 메소드 정의
//    public abstract double apply(double x, double y);
//}

enum Operation {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    MULTI("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    // 클래스 생성자와 멤버
    private final String symbol;

    private final DoubleBinaryOperator op; // 람다식을 저장할 필드

    Operation(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() {
        return symbol;
    }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}

public class EnumOper {
    public static void main(String[] args) {

        double x = 2.5;
        double y = 5.0;

        // Operation 상수집합의 PLUS 상수를 정의
        Operation plus = Operation.PLUS;

        // enum 매핑값 출력
        String name = plus.toString();
        System.out.println(name); // +

        // enum 확장 메소드 실행
        double result = plus.apply(x, y); // 덧셈을 수행하는 메소드 (Operation.PLUS.apply(x, y) 로 해도됨)
        System.out.println(result); // 7.5

        // ------------------------------------------------------------------- //

        // Operation 상수집합의 PLUS 상수를 정의
        Operation multi = Operation.MULTI;

        String name2 = multi.toString();
        System.out.println(name2); // *

        // enum 확장 메소드 실행
        double result2 = multi.apply(x, y); // 곱셈을 수행하는 메소드
        System.out.println(result2); // 12.5

    }
}
