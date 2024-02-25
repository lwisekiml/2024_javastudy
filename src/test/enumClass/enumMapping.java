import java.util.Arrays;
import java.util.List;

enum Season {
    SPRING("봄"),
    SUMMER("여름"),
    FALL("가을"),
    WINTER("겨울");

    // 문자열을 저장할 필드
    private String season;

    // 생성자 (싱글톤)
    private Season(String season) {
        this.season = season;
    }

    // Getter
    public String getSeason() {
        return season;
    }
}

enum CreditCard {

    SHINHAN("신한", Arrays.asList("Mr.Life 카드", "Deep Dream 카드", "Deep Oil 카드")),
    KB("국민", Arrays.asList("톡톡D 카드", "티타늄 카드", "다담 카드")),
    NH("농협", Arrays.asList("올바른 FLEX 카드", "테이크 5 카드", "NH 올원 파이카드"));

    private final String Enterprise;
    private final List<String> cards;

    CreditCard(String name, List<String> cards) {
        this.Enterprise = name;
        this.cards = cards;
    }

    CreditCard getCard(String cardName) throws Exception {
        return Arrays.stream(CreditCard.values())
                .filter(creditCard -> creditCard.equals(cardName))
                .findFirst()
                .orElseThrow(Exception::new);
    }
}

class enumMapping {
    public static void main(String[] args) throws Exception {
        Season s = Season.SUMMER;
        System.out.println(s.name()); // 열거 객체명 출력 : SUMMER
        System.out.println(s.getSeason()); // 매핑된 열거 데이터 출력 : 봄

        CreditCard c = CreditCard.SHINHAN;
        System.out.println(c.getCard("신한"));
        System.out.println("end");
    }
}