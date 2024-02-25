package test.enumClass;

import java.util.Arrays;

enum Day {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
}

enum Month {
    JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY,
    AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
}

enum Week {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}

class Test {
    public static void main(String[] args) {

        Week w1 = Week.FRIDAY;
        Week w2 = Week.MONDAY;

        String weekName = w1.name();
        int weekNum = w1.ordinal();
        System.out.println(weekName);
        System.out.println(weekNum);
        System.out.println(w1.compareTo(w2));
        System.out.println(w2.compareTo(w1));

        try {
            Week w3 = Week.valueOf("SUNDAYl");
            System.out.println(w3);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못됨");
        }

        Week[] w4 = Week.values();
        System.out.println(Arrays.toString(w4));

        for (Week type : Week.values()) {
            System.out.println(type);
        }
    }
}

