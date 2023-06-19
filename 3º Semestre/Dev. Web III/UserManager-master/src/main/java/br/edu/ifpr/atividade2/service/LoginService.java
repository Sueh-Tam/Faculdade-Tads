package br.edu.ifpr.atividade2.service;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class LoginService {

    public void validateLogin(String user, String password, HttpServletRequest request) throws Exception {

        if(user == null || user.isEmpty()){
            throw new Exception("Usuário inválido");
        }

        if(user == null || user.isEmpty()){
            throw new Exception("Senha inválida");
        }

        if (user.equals("admin") && password.equals("admin")){

            HttpSession session = request.getSession();
            session.setAttribute("is_logged_in", true);
            session.setAttribute("user", user);

        } else {
            throw new Exception("usuário ou senha incorreto");
        }


    }

}
