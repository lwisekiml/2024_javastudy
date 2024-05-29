package test.nullobject;

public class Label {
    public final static Label NULL = new NullLabel();
    private final String label;

    public Label(String label) {
        this.label = label;
    }

    public boolean isNull() {
        return false;
    }

    public void display() {
        System.out.println("display : " + label);
    }

    public String toString() {
        return "\"" + label + "\"";
    }

    // 팩토리 메소드
//    public static Label newNull() {
//        return NullLabel.getInstance();
//    }

    // 널 객체
    private static class NullLabel extends Label {
        // 싱글톤
//        private static final NullLabel singleton = new NullLabel();
//
//        private static NullLabel getInstance() {
//            return singleton;
//        }

        public NullLabel() {
            super("(none)");
        }

        @Override
        public void display() { }

        @Override
        public boolean isNull() {
            return true;
        }
    }
}
