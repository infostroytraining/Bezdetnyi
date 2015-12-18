package ua.knure.bezditnyi.receiver;

import java.util.*;

/**
 * Created by Artem on 17.12.2015.
 */
public class Analyzer {

    // limits how many lines for each result will be printed
    public static final int FREQUENCY_LIMIT = 2;
    public static final int LENGTH_LIMIT = 3;
    public static final int DUPLICATES_LIMIT = 3;

    public void frequency(List<String> words){
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words){
            if (!frequencyMap.containsKey(word)){
                frequencyMap.put(word, 1);
            } else {
                frequencyMap.put(word, frequencyMap.get(word) + 1);
            }
        }
        frequencyMap.entrySet().stream()
                .sorted((freq1, freq2) -> freq2.getValue() - freq1.getValue())
                .limit(FREQUENCY_LIMIT)
                .forEach(System.out::println);
    }

    public void length(List<String> words){
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words){
            frequencyMap.put(word, word.length());
        }
        frequencyMap.entrySet().stream()
                .sorted((freq1, freq2) -> freq2.getValue() - freq1.getValue())
                .limit(LENGTH_LIMIT)
                .forEach(System.out::println);
    }

    public void duplicates(List<String> words){
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
        duplicateWords.stream()
                .map(String::toUpperCase)
                .sorted((word1, word2) -> word2.length() - word1.length())
                .forEach(System.out::println);
    }

}
