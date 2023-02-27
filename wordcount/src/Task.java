import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static java.util.Collections.reverseOrder;
import static java.util.function.UnaryOperator.identity;
import static java.util.stream.Collectors.*;

public class Task {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();
        List<String> words = Arrays.asList(sentence.split(" "));

        List<Long> result_int = words.stream().collect(groupingBy(identity(), counting())).entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue(reverseOrder()).thenComparing(Map.Entry.comparingByKey())).limit(10).map(Map.Entry::getValue).collect(toList());
        List<String> result_words = words.stream().map(String::toLowerCase).collect(groupingBy(identity(), counting())).entrySet().stream().sorted(Map.Entry.<String, Long> comparingByValue(reverseOrder()).thenComparing(Map.Entry.comparingByKey())).limit(10).map(Map.Entry::getKey).collect(toList());
        System.out.println("TOP 10 WORDS SORTED BY OCCURANCY AND SORTED IN ALFAVIT PORYADOK");
        for (int i = 0; i < result_int.size(); i++) {
            System.out.println(result_int.get(i)+" "+ result_words.get(i));
        }
        System.out.println("WORDS TOTAL COUNT: " + words.size());
    }
}