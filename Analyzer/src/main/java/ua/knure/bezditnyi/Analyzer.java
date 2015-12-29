package ua.knure.bezditnyi;

import ua.knure.bezditnyi.command.Command;
import ua.knure.bezditnyi.command.DuplicatesCommand;
import ua.knure.bezditnyi.command.FrequencyCommand;
import ua.knure.bezditnyi.command.LengthCommand;
import ua.knure.bezditnyi.jcommander.Settings;

import com.beust.jcommander.JCommander;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Artem on 18.12.2015.
 */
public class Analyzer {

    private static Logger log = LogManager.getLogger(Analyzer.class.getName());

    private static Map<String, Command> commands = new HashMap<>();

    public static void main(String[] args){
        Settings settings = new Settings();
        JCommander jCommander = new JCommander(settings);
        jCommander.parse(args);

        if (settings.isHelp()) {
            jCommander.usage();
            return;
        }

        initializeCommandsMap(settings);
        System.out.println("Using parallel streams: " + settings.isUseParallelStreams());

        String fileName = settings.getInput();
        List<String> words = readWordsFromFile(fileName);
        executeTasks(commands, settings, words);
    }

    private static void initializeCommandsMap(Settings settings) {
        commands.put("frequency", new FrequencyCommand(settings.isUseParallelStreams()));
        commands.put("duplicates", new DuplicatesCommand(settings.isUseParallelStreams()));
        commands.put("length", new LengthCommand(settings.isUseParallelStreams()));
    }


    private static void executeTasks(Map<String, Command> commands, Settings settings, List<String> words){
        List<String> tasks = settings.getTasks();
        for (String task : tasks){
            commands.get(task).execute(words);
        }
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
