package ua.knure.bezditnyi.jcommander;

import com.beust.jcommander.Parameter;

import java.util.List;

/**
 * Created by Artem on 17.12.2015.
 */
public class Settings {

    @Parameter(names = {"-i", "--input"}, required = true, description = "Path to the input file")
    private String input;

    // multiple tasks can be executed at the same time
    @Parameter(names = {"-t", "--task"}, required = true, description = "Task to execute",
            variableArity = true, validateWith = TaskValidator.class, converter = TaskConverter.class)
    private List<TaskEnum> tasks;

    @Parameter(names = {"-a" ,"--help"}, help = true, description = "Detailed information of how to use this app")
    private boolean help;

    public enum TaskEnum {
        Frequency, Length, Duplicates;

        public static TaskEnum fromString(String stringTask){
            for(TaskEnum task : TaskEnum.values()) {
                if(task.toString().equalsIgnoreCase(stringTask)) {
                    return task;
                }
            }
            return null;
        }
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public List<TaskEnum> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEnum> tasks) {
        this.tasks = tasks;
    }

    public boolean isHelp() {
        return help;
    }

    public void setHelp(boolean help) {
        this.help = help;
    }
}
