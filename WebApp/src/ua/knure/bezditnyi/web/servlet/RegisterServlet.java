package ua.knure.bezditnyi.web.servlet;

import ua.knure.bezditnyi.dto.UserDto;
import ua.knure.bezditnyi.entity.User;
import ua.knure.bezditnyi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Artem on 11.12.2015.
 */
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = (UserService)request.getServletContext().getAttribute("userService");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String passwordConfirmation = request.getParameter("passwordConfirmation");
        String photo = request.getParameter("photo");

        UserDto userDto = new UserDto(firstName, lastName, email, password, photo);

        if (FormValidator.validateFormFields(new String[] {
                firstName, email, password, passwordConfirmation}) &&
                FormValidator.validatePasswords(password, passwordConfirmation)){
            userService.registerUser(new User(firstName, lastName, email, password, photo));
        } else {
            request.setAttribute("user", userDto);
        }

    }
}
