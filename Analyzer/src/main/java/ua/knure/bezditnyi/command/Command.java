package ua.knure.bezditnyi.command;

import java.util.List;

/**
 * Created by Artem on 18.12.2015.
 */
@FunctionalInterface
public interface Command {

    public abstract void execute(List<String> words);
}
