package ua.knure.bezditnyi.invoker;

import ua.knure.bezditnyi.command.Command;

/**
 * Created by Artem on 18.12.2015.
 */
public class Invoker {

    public Command frequency;
    public Command duplicates;
    public Command length;

    public Invoker(Command frequency, Command duplicates, Command length) {
        this.frequency = frequency;
        this.duplicates = duplicates;
        this.length = length;
    }

    public void showFrequency(){
        frequency.execute();
    }

    public void showDuplicates(){
        duplicates.execute();
    }

    public void showLength(){
        length.execute();
    }
}
