package io.github.gabrielstz120.listeners;

import io.github.gabrielstz120.config.SpringContext;
import io.github.gabrielstz120.models.Usuario;
import io.github.gabrielstz120.services.UsuarioService;
import io.github.gabrielstz120.views.CadastroUsuarioView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CadastroUsuarioListener extends ViewListener {
    private final CadastroUsuarioView cadastroUsuarioView;

    public CadastroUsuarioListener(CadastroUsuarioView cadastroUsuarioView) {
        this.cadastroUsuarioView = cadastroUsuarioView;
        addListener();
    }


    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Novo":
                cadastroUsuarioView.clear();
                break;
            case "Salvar":
                salvar();
                break;
            case "Fechar":
                fechar(cadastroUsuarioView);
                break;
        }
    }

    @Override
    void addListener() {
        cadastroUsuarioView.getButtonsList().forEach(bt -> bt.addActionListener(this));
    }

    private void salvar() {
        Usuario usuario = cadastroUsuarioView.getUsuario();
        if (usuario != null) {
            if (SpringContext.getContext().getBean(UsuarioService.class).salvar(usuario)) {
                JOptionPane.showMessageDialog(cadastroUsuarioView, "Usuário salvo com Sucesso", "Usuário Salvo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(cadastroUsuarioView, "Erro ao Cadastrar o Usúario", "Erro de Cadastro de Usuário", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(cadastroUsuarioView, "Senhas não são iguais", "Erro de Cadastro de Usuário", JOptionPane.ERROR_MESSAGE);
        }
    }
}
