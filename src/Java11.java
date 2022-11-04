import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.ByteBuffer;
import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.Flow;
import java.util.function.Predicate;

/**
 * JMC, JFR: go open source
 * Nest based access control
 * execute directly with "java", w/o "javac"
 * New string methods
 * Not predicate
 * New HTTP client
 */
public class Java11 {
    public static void main(String[] args) {
        newStringMethods();
        notPredicate();
        httpClient();
    }

    private static void httpClient() {
        HttpClient httpClient = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .connectTimeout(Duration.ofSeconds(20))
                .followRedirects(HttpClient.Redirect.NEVER)
                .proxy(ProxySelector.getDefault())
                .build();
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .header("Authorization", "Bearer eyqsdlmkfjzmeoirjsmdkfjmlskjzmelrfj.zlkejroisjdf.ezjeroij")
                .uri(URI.create("http://localhost:8080"))
                .build();
        try {
            HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            int status = httpResponse.statusCode();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void notPredicate() {
        List<String> ample = List.of("chris", "neve", "java", "le mans");
        List<String> filtered = ample.stream()
                .filter(Predicate.not(s -> s.contains("a")))
                .toList();
        int i = 1;
    }

    private static void newStringMethods() {
        String test = " christopher \nneve ";
        boolean blank = test.isBlank();
        long lines = test.lines()
                .count();
        String stripped = test.strip();
        String strippedLeading = test.stripLeading();
        String strippedT = test.stripTrailing();
        String repeated = test.repeat(2);
    }
}
