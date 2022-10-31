import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * Java 9:
 * - jshell
 * - modules
 * - méthodes privées dans les interfaces
 * - fabriques pour les collections immuables
 * - compact strings
 */
public class Java9 {
    public static void main(String[] args) {
        fabriqueCollectionsImmuables();
        compactStrings();
    }

    static void fabriqueCollectionsImmuables() {
        List<String> motsClé = List.of("Le Mans", "JUG");
        Set<String> adjectifs = Set.of("Fantastique", "Éducation");
        adjectifs.add("sdf");// crash - retourne un objet immuable
        //pas de fabrique pour les Queues !
        // Jusqu'à 10
        Map<String, String> organisateurs = Map.of("Chris", "Neve", "Nicolas", "Dugué", "Pourquoi pas", "toi ?");
        //au delà
        Map<String, String> invités = Map.ofEntries(
                Map.entry("Université", "Tous les étudiants"),
                Map.entry("Professionnels", "Développeurs Java")
        );
    }

    public static void compactStrings() {
        long startTime = System.currentTimeMillis();

        List<String> strings = IntStream.rangeClosed(1, 10_000_000)
                .mapToObj(Integer::toString)
                .collect(toList());

        long totalTime = System.currentTimeMillis() - startTime;
        System.out.println(
                "Generated " + strings.size() + " strings in " + totalTime + " ms.");

        startTime = System.currentTimeMillis();

        String appended = strings.stream()
                .limit(100_000)
                .reduce("", (l, r) -> l + r);

        totalTime = System.currentTimeMillis() - startTime;
        System.out.println("Created string of length " + appended.length()
                + " in " + totalTime + " ms.");
    }
}


interface Timeline {
    int MAXIMUM_DAYS = 10;

    void getTimeline();

    default String getLabel() {
        return "Il y a du nouveau depuis le " + earliestTimelineDate();
    }

    static int maximumTimelineAge() {
        return MAXIMUM_DAYS;
    }

    private LocalDateTime earliestTimelineDate() {
        return LocalDateTime.now().minusDays(maximumTimelineAge());
    }
}

class CustomTimeline implements Timeline {

    @Override
    public void getTimeline() {
        //business code
    }
}