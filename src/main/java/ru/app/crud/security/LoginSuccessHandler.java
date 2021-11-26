package ru.app.crud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.app.crud.model.User;
import ru.app.crud.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private UserService userServiceImp;

    @Autowired
    public LoginSuccessHandler(UserService userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        User user = userServiceImp.getUserByName(authentication.getName()); // но здесь уже равно null
        httpServletResponse.sendRedirect("/user/" + user.getId());

    }
}