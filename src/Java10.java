/**
 * Local type inference
 */
public class Java10 {
    private String s = ""; //Pas pour les instance variables / non-static fields. Field
    private static String s2 = ""; //Pas pour les class variables / static fields. Field

    public static void main(String[] args) {
        //local variable type inference. Rappel sur les fields vs variables
        var s = 1;// local variable
    }

    void toto(String s) {//parameter. Variable, not a field

    }
}
