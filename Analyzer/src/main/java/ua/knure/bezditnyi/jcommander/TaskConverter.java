package ua.knure.bezditnyi.jcommander;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;

/**
 * Created by Artem on 18.12.2015.
 */
public class TaskConverter implements IStringConverter<Settings.TaskEnum> {
    @Override
    public Settings.TaskEnum convert(String task) {
        Settings.TaskEnum convertedTask = Settings.TaskEnum.fromString(task);

        if (convertedTask == null){
            throw new ParameterException("Value " + task + "can not be converted to TaskEnum. " +
                    "Available tasks are: frequency, duplicates, length.");
        }
        return convertedTask;
    }
}
