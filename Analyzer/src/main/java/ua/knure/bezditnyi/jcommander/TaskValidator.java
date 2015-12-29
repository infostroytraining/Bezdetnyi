package ua.knure.bezditnyi.jcommander;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Artem on 17.12.2015.
 */
public class TaskValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!"frequency".equals(value) && !"length".equals(value) &&
                !"duplicates".equals(value)){
            throw new ParameterException("Parameter " + name + " must be 'frequency', 'length' or 'duplicates'");
        }
    }
}
