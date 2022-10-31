import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Java version: " + System.getProperty("java.version"));
        String sdf = "sdf";
        testNpe(null);

    }
    static void testNpe(Test t) {
        String n = t.name;
    }
}

class Test {
    String name;
}