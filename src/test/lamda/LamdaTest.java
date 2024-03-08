package test.lamda;

interface IAdd {
    int add(int x, int y);
}

class  Add implements IAdd {
    public int add(int x, int y) {
        return x + y;
    }
}

interface OperationStrategy {
    // (int x, int y) -> int
    int calculate(int x, int y);
}

// Template
class OperationTemplate {
    int calculate(int x, int y, OperationStrategy cal) {
        int result = cal.calculate(x, y);
        return result;
    }
}

// 메서드 타입, 메서드 이름, 매개변수 타입, 중괄호, return 문을 생략하고, 화살표 기호를 넣음으로써 코드를 혁명적으로 함축
public class LamdaTest {
    public static void main(String[] args) {

        int x = 1;
        int y = 2;
        OperationTemplate ot = new OperationTemplate();

        int result = ot.calculate(x, y, (a, b) -> x + y);

        System.out.println("result : " + result);



        // 생 클래스로 메소드 사용하기
        Add a = new Add();

        int result1 = a.add(1, 2);
        System.out.println(result1);


        IAdd i = new IAdd() {
            @Override
            public int add(int x, int y) {
                return x + y;
            }
        };
        int result2 = i.add(1, 2);
        System.out.println(result2);


        // 인터페이스로 선언한 익명 구현 객체만이 람다식으로 표현이 가능
        // 람다 표현이 가능한 이러한 인터페이스를 가리켜 함수형 인터페이스라 총칭한다.
        // 함수형 인터페이스 : 딱 하나의 추상 메소드가 선언된 인터페이스
        // 인터페이스의 final 상수나 default, static, private 메서드는 추상 메서드가 아니기 때문에,
        // 이들 여러개가 인터페이스에 들어있어도 오로지 추상 메서드가 한개이면 함수형 인터페이스로 취급
//        IAdd lamda = (x, y) -> {
//            return x + y;
//        };
        IAdd lamda = (m, n) -> x + y;

        int result3 = lamda.add(1, 2);
        System.out.println(result3);
    }
}
