package io.github.gabrielstz120.listeners;

import io.github.gabrielstz120.config.SpringContext;
import io.github.gabrielstz120.models.Usuario;
import io.github.gabrielstz120.services.UsuarioService;
import io.github.gabrielstz120.views.LoginView;
import io.github.gabrielstz120.views.MainMenuView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public final class LoginListener implements ActionListener {

    private final LoginView loginView;
    private final UsuarioService usuarioService;

    public LoginListener(LoginView loginView) {
        this.loginView = loginView;
        addListener();
        usuarioService = SpringContext.getContext().getBean(UsuarioService.class);
    }

    private void addListener() {
        loginView.getConectarButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Conectar":
                login();
                break;
        }
    }

    private void login() {
        Usuario usuario = loginView.getUsuario();
        if (usuarioService.login(usuario.getEmail(), usuario.getSenha())) {
            loginView.dispose();
            new MainMenuView().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(loginView, "Usuário ou Senha Invalido", "Erro de Login", JOptionPane.ERROR_MESSAGE);
        }
    }

}
