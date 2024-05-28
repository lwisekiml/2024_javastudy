package test.nullobject;

public class Main {
    public static void main(String[] args) throws Exception {
        Person[] people = {
                new Person(new Label("Alice"), new Label("alice@test.com")),
                new Person(new Label("Bobby"), new Label("Bobby@test.com")),
                new Person(new Label("Chris"))
        };

        for (Person p : people) {
            System.out.println(p.toString());
            p.display();
            System.out.println("");
        }
    }
}