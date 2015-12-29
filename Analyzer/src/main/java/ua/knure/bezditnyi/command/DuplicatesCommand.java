package ua.knure.bezditnyi.command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Artem on 29.12.2015.
 */
public class DuplicatesCommand implements Command{

    private static final int DUPLICATES_LIMIT = 3;

    private boolean useParallelStreams;

    public DuplicatesCommand(boolean useParallelStreams){
        this.useParallelStreams = useParallelStreams;
    }

    @Override
    public void execute(List<String> words) {
        System.out.println("Duplicates command");

        long startTime = System.nanoTime();

        getStream(getDuplicateWords(words))
                .map(String::toUpperCase)
                .sorted((word1, word2) -> word2.length() - word1.length())
                .forEach(System.out::println);

        long endTime = System.nanoTime();
        System.out.println("Collapsed time: " + (endTime - startTime) + " ns\n");
    }

    private List<String> getDuplicateWords(List<String> words){
        Map<String, Integer> frequencyMap = new HashMap<>();
        List<String> duplicateWords = new ArrayList<>();
        for (String word : words){
            if (!frequencyMap.containsKey(word)){
                frequencyMap.put(word, 1);
            } else {
                duplicateWords.add(word);
                if (duplicateWords.size() == DUPLICATES_LIMIT)
                    break;
            }
        }
        return duplicateWords;
    }

    private Stream<String> getStream(List<String> duplicateWords){
        if (useParallelStreams){
            return duplicateWords.parallelStream();
        } else {
            return duplicateWords.stream();
        }
    }
}
