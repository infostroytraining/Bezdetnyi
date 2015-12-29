package ua.knure.bezditnyi.jcommander;

import com.beust.jcommander.Parameter;

import java.util.List;

/**
 * Created by Artem on 17.12.2015.
 */
public class Settings {

    @Parameter(names = {"-i", "--input"}, required = true, description = "Path to the input file")
    private String input;

    @Parameter(names = {"-t", "--task"}, required = true, description = "Task to execute",
            variableArity = true, validateWith = TaskValidator.class)
    private List<String> tasks;

    @Parameter(names = {"-a" ,"--help"}, help = true, description = "Detailed information of how to use this app")
    private boolean help;

    @Parameter(names = {"-p", "--parallel"}, description = "Using parallel streams")
    private boolean useParallelStreams;

    public String getInput() {
        return input;
    }

    public List<String> getTasks() {
        return tasks;
    }

    public boolean isHelp() {
        return help;
    }

    public boolean isUseParallelStreams() {
        return useParallelStreams;
    }

}
