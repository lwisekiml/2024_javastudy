package test.lamda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleBinaryOperator;
import java.util.stream.IntStream;

enum Oper {
    PLUS("+", (x, y) -> x + y),
    MINUS("-", (x, y) -> x - y),
    TIMES("*", (x, y) -> x * y),
    DIVIDE("/", (x, y) -> x / y);

    private final String symbol;
    private final DoubleBinaryOperator op;

    Oper(String symbol, DoubleBinaryOperator op) {
        this.symbol = symbol;
        this.op = op;
    }

    @Override
    public String toString() { return symbol; }

    public double apply(double x, double y) {
        return op.applyAsDouble(x, y);
    }
}

public class Operation {


    public static void main(String[] args) {
        // 사용은 아래와 같이
        System.out.println(Oper.PLUS.apply(2, 3));


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.forEach(i -> {
            IntStream.range(0, i).forEach(j -> {
                System.out.println(i/j); // j가 0일 경우 어디서 문제가 발생했는지 확인 하기 어렵다.
            });
        });
    }
}
