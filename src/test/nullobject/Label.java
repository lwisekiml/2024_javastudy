package test.nullobject;

public class Label {
    private final String label;

    public Label(String label) {
        this.label = label;
    }

    public static Label newNull() {
        return new NullLabel();
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
}
