package test.anonymousClass;

// 연산식을 추상화한 인터페이스
interface Operate {
    int operate(int a, int b);
}

// 계산을 담당하는 클래스
class Calculator{
    // 계산할 두 수를 저장하는 필드
    private final int a;
    private final int b;

    // 생성자
    public Calculator(int a, int b) {
        this.a = a;
        this.b = b;
    }

    // 인터페이스 타입을 매개변수로 받는 메소드 (다형성)
    public int caculate(Operate op) {
        return op.operate(this.a, this.b); // 매개변수 객체의 메서드 실행하여 리턴
    }
}

class Test implements Operate {

    @Override
    public int operate(int a, int b) {
        return 0;
    }
}

// 익명 클래스 연습
public class AnonymousClass {
    public static void main(String[] args) {
        // 계산할 두 수
        int num1 = 20;
        int num2 = 10;

        // Calculator 클래스 생성하며 계산 할 수를 클래스 필드에 저장
        Calculator calculator = new Calculator(num1, num2);

        // calculator.caculate() 메서드 인자로, operate() 추상 메소드를 더하기 연산이 되도록 재정의한 익명 구현 객체를 넘김
        // calculator.caculate() 매서드 내에서 재정의된 operate() 메소드가 실행되어 a + b가 리턴 됨
        int result = calculator.caculate(new Operate() {
            public int operate(int a, int b) {
                return a + b;
            }
        });

        System.out.println(result); // 30

        // calculator.caculate() 메서드 인자로, operate() 추상 메소드를 빼기 연산이 되도록 재정의한 익명 구현 객체를 넘김
        // calculator.caculate() 매서드 내에서 재정의된 operate() 메소드가 실행되어 a - b가 리턴 됨
//        int result2 = calculator.caculate(new Operate() {
//            public int operate(int a, int b) {
//                return a - b;
//            }
//        });

        int result2 = calculator.caculate((a, b) -> {
            return a - b;
        });

        System.out.println(result2); // 10
    }
}


//public class Anonymous {
//    public static void main(String[] args) {
//
//        class User {
//            String name;
//            int age;
//
//            User(String name, int age) {
//                this.name = name;
//                this.age = age;
//            }
//        }
//
//        User[] users = {
//                new User("홍길동", 32),
//                new User("김춘추", 64),
//                new User("임꺽정", 48),
//                new User("박혁거세", 14),
//        };
//
//        // Arrays.sort(배열, Comparator 익명 구현 객체);
//        Arrays.sort(users, new Comparator<User>() {
//            @Override
//            public int compare(User u1, User u2) {
//                return Integer.compare(u1.age, u2.age); // Integer 클래스에 정의된 compare 함수로 두 가격 정수 원시값을 비교
//            }
//        });
//
//        // 출력
//        for (User u : users) {
//            System.out.println(u.name + " " + u.age + "세");
//        }
//
//    }
//}
