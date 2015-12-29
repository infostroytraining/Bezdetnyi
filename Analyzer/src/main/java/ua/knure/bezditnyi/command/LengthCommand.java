package ua.knure.bezditnyi.command;

import java.net.Inet4Address;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by Artem on 29.12.2015.
 */
public class LengthCommand implements Command {

    private static final int LENGTH_LIMIT = 3;

    private boolean useParallelStreams;

    public LengthCommand(boolean useParallelStreams){
        this.useParallelStreams = useParallelStreams;
    }

    @Override
    public void execute(List<String> words) {
        long startTime = System.nanoTime();

        System.out.println("Length command");

        getStream(getFrequencyMap(words))
                .sorted((freq1, freq2) -> freq2.getValue() - freq1.getValue())
                .limit(LENGTH_LIMIT)
                .forEach(System.out::println);

        long endTime = System.nanoTime();
        System.out.println("Collapsed time: " + (endTime - startTime) + " ns\n");
    }

    private Map<String, Integer> getFrequencyMap(List<String> words){
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words){
            frequencyMap.put(word, word.length());
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
