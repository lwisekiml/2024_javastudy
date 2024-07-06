package test;

import java.util.HashSet;
import java.util.Set;

class A{
    private int a;
    private String b;

    public A(int a, String b) {
        this.a = a;
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "A{" +
                "a=" + a +
                ", b='" + b + '\'' +
                '}';
    }
}

public class SetTest {
    public static void main(String[] args) {
        Set<A> set = new HashSet<A>();
        set.add(new A(1, "a"));
        set.add(new A(2, "b"));
        set.add(new A(3, "c"));

        for (A a : set) {
            System.out.println("a = " + a);
        }
        set.add(new A(1, "a"));

        System.out.println("=============================");
        for (A a : set) {
            System.out.println("a = " + a);
        }
    }
}
