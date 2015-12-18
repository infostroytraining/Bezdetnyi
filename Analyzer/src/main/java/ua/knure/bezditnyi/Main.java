package ua.knure.bezditnyi;

import ua.knure.bezditnyi.invoker.Invoker;
import ua.knure.bezditnyi.jcommander.Settings;
import ua.knure.bezditnyi.receiver.Analyzer;

import com.beust.jcommander.JCommander;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Artem on 18.12.2015.
 */
public class Main {

    private static Logger log = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args){
        Settings settings = new Settings();
        JCommander jCommander = new JCommander(settings);
        jCommander.parse(args);

        if (settings.isHelp()) {
            jCommander.usage();
            return;
        }

        String fileName = settings.getInput();
        List<String> words = readWordsFromFile(fileName);
        Invoker invoker = getInvoker(words);
        executeTasks(invoker, settings);
    }

    private static Invoker getInvoker(List<String> words){
        Analyzer analyzer = new Analyzer();
        return new Invoker(
                () -> analyzer.frequency(words),
                () -> analyzer.duplicates(words),
                () -> analyzer.length(words));
    }

    private static void executeTasks(Invoker invoker, Settings settings){
        List<Settings.TaskEnum> tasks = settings.getTasks();
        if (tasks.contains(Settings.TaskEnum.Frequency))
            invoker.showFrequency();
        if (tasks.contains(Settings.TaskEnum.Duplicates))
            invoker.showDuplicates();
        if (tasks.contains(Settings.TaskEnum.Length))
            invoker.showLength();
    }

    private static List<String> readWordsFromFile(String fileName){
        List<String> words = null;
        try {
            words = Files
                    .lines(Paths.get(fileName))
                    .flatMap(line -> Arrays.stream(line.split(" ")))
                    .map(line -> line.replaceAll("[,.]", " "))
                    .collect(Collectors.toList());

        } catch (IOException e){
            log.error("File cannot be read", e);
        }
        return words;
    }
}
