package ua.knure.bezditnyi.web.servlet;

import ua.knure.bezditnyi.dto.UserDto;
import ua.knure.bezditnyi.entity.User;
import ua.knure.bezditnyi.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Artem on 11.12.2015.
 */
public class RegisterServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = (UserService)request.getServletContext().getAttribute("userService");

        String firstName = new String(request
                .getParameter("firstName")
                .getBytes("ISO-8859-1"), "UTF-8");
        String lastName = new String(request
                .getParameter("lastName")
                .getBytes("ISO-8859-1"), "UTF-8");
        String email = new String(request
                .getParameter("email")
                .getBytes("ISO-8859-1"), "UTF-8");
        String password = new String(request
                .getParameter("password")
                .getBytes("ISO-8859-1"), "UTF-8");
        String passwordConfirmation = new String(request
                .getParameter("passwordConfirmation")
                .getBytes("ISO-8859-1"), "UTF-8");
        String photo = request
                .getParameter("photo");

        UserDto userDto = new UserDto(firstName, lastName, email, password, photo);

        List<String> errors = new ArrayList<>();
        if(!FormValidator.validateFormFields(new String[]{
                firstName, email, password, passwordConfirmation}))
            errors.add("Все поля помечненные '*' должны быть заполнены.");
        if(!FormValidator.validatePasswords(password ,passwordConfirmation))
            errors.add("Пароли не совпадают.>");

        if (errors.size() == 0)
        {
            userService.registerUser(new User(firstName, lastName, email, password, photo));
            request.setAttribute("users", userService.getAll());
            request.getRequestDispatcher("users.jsp").forward(request, response);
        } else {
            request.setAttribute("user", userDto);
            request.setAttribute("errors", errors);
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
