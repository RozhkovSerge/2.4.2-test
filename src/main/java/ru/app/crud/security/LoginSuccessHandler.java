package ru.app.crud.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import ru.app.crud.dao.UserDao;
import ru.app.crud.model.User;
import ru.app.crud.service.UserService;
import ru.app.crud.service.UserServiceImp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.Principal;
import java.util.Set;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private  UserService userServiceImp;

    @Autowired
    public LoginSuccessHandler(UserService userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    public LoginSuccessHandler() {

    }

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException, ServletException {

        User user = userServiceImp.getUserByName(authentication.getName()); // но здесь уже равно null
        httpServletResponse.sendRedirect("/user/" + user.getId());

    }
}