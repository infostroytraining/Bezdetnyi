package ua.knure.bezditnyi.web.servlet;

/**
 * Created by Artem on 11.12.2015.
 */
public class FormValidator {
    /**
     * Checks whether password or its confirmation are equal.
     * @param password1 password
     * @param password2 password confirmation
     * @return True if password and its confirmation are equal, false if they are not.
     */
    public static boolean validatePasswords(String password1, String password2) {
        return password1 != null && password1.equals(password2);
    }

    /**
     * Checks whether all field values are filled.
     * @param fieldValues array of field values
     * @return  True if all fields are filled, false if they are not
     */
    public static boolean validateFormFields(String[] fieldValues){
        for (String fieldValue : fieldValues)
            if (fieldValue == null || fieldValue.isEmpty()){
                return false;
            }
        return true;
    }
}
