import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class CodeChallenge {

    public static void main(String[] args) throws IOException {
        Map<String, Long> wordsCount = countWords("src/main/resources/Data.txt");
        System.out.println(wordsCount);

        System.out.println("==================== or we can iterate in this way===================");

        wordsCount.entrySet().forEach(System.out::println);
    }

    public static Map<String, Long> countWords(final String fileName) throws IOException {
        return Files.lines(Paths.get(fileName))
                .flatMap(line -> Arrays.stream(line.trim().split(" ")))
                .map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim())
                .filter(word -> !word.isEmpty())
                .collect(groupingBy(Function.identity(), counting()));
    }
}
