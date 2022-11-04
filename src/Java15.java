import java.util.List;

/**
 * text blocks
 * clearer NPEs
 */
public class Java15 {
    public static void main(String[] args) {
        textBlocks();
        clearerNPEs();
    }

    private static void clearerNPEs() {
        User u = new User(null);
        String exception = u.names.get(0).toString();
    }

    private static void textBlocks() {
        String avant = avantJava15(),
                après = aprèsJava15();
        System.out.println("Identique : " + (avant.equals(après)));
    }

    private static String aprèsJava15() {
        return """
                Bonjour,
                
                Vous avez reçu un mail de la part de notre super JUG.
                Renseignez-vous sur Le Mans JUG, c'est génial !
                
                Bien cordialement,
                Le Mans JUG
                https://lemansjug.wordpress.com/""";
    }

    private static String avantJava15() {
        return "Bonjour,\n" +
                "\n" +
                "Vous avez reçu un mail de la part de notre super JUG.\n" +
                "Renseignez-vous sur Le Mans JUG, c'est génial !\n" +
                "\n" +
                "Bien cordialement,\n" +
                "Le Mans JUG\n" +
                "https://lemansjug.wordpress.com/";
    }
}

class User {
    List<String> names;

    public User(List<String> names) {
        this.names = names;
    }
}