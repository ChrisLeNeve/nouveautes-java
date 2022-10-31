/**
 * - Enhanced switch blocks
 * - yield
 */
public class Java14 {
    public static void main(String[] args) {
        //le compilateur Java génère généralement du bytecode plus efficace à partir des switch
        //switch: byte, short, int, char, wrapper classes, String or enum
        jourDeSemaineAvantJava14("toto");
        jourDeSemaineAprèsJava14("toto");
    }

    private static int jourDeSemaineAvantJava14(String greeting) {
        int value;
        switch (greeting) {
            case "lundi":// utilise "equals"
                value = 1;
                break;
            case "mardi":
                value = 2;
                break;
            case "mercredi":
            case "jeudi":
            case "vendredi":
                value = 0;
                break;
            default:
                value = -1;
                break;
        }
        return value;
    }
    private static int jourDeSemaineAprèsJava14(String greeting) {
        return switch (greeting) {
            case "lundi" -> 1;
            case "mardi" -> {
                yield 2;
            }
            case "mercredi", "jeudi", "vendredi" -> 0; //enhanced switch blocks
            default -> {
                yield -1;
            }
        };
    }
}
