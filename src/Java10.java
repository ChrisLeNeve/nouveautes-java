public class Java10 {
    private String s = ""; //Pas pour les instance variables / non-static fields. Field
    private static String s2 = ""; //Pas pour les class variables / static fields. Field

    public static void main(String[] args) {
        var s = "toto";//local variable
    }

    void toto(String s) {//parameter. Variable, not a field

    }
}
