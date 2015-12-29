package ua.knure.bezditnyi.command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Artem on 29.12.2015.
 */
public class FrequencyCommand implements Command {

    private static final int FREQUENCY_LIMIT = 2;

    private boolean useParallelStreams;

    public FrequencyCommand(boolean useParallelStreams){
        this.useParallelStreams = useParallelStreams;
    }

    @Override
    public void execute(List<String> words) {
        System.out.println("Frequency command");
        long startTime = System.nanoTime();

        getStream(getFrequencyMap(words))
                .sorted((freq1, freq2) -> freq2.getValue() - freq1.getValue())
                .limit(FREQUENCY_LIMIT)
                .forEach(System.out::println);

        long endTime = System.nanoTime();
        System.out.println("Collapsed time: " + (endTime - startTime) + " ns\n");
    }

    private Map<String, Integer> getFrequencyMap(List<String> words){
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words){
            if (!frequencyMap.containsKey(word)){
                frequencyMap.put(word, 1);
            } else {
                frequencyMap.put(word, frequencyMap.get(word) + 1);
            }
        }
        return frequencyMap;
    }

    private Stream<Map.Entry<String, Integer>> getStream(Map<String, Integer> frequencyMap){
        if (useParallelStreams){
            return frequencyMap.entrySet().parallelStream();
        } else {
            return frequencyMap.entrySet().stream();
        }
    }
}
