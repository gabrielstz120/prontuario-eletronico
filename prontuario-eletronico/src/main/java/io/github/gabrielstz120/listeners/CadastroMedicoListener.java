package io.github.gabrielstz120.listeners;

import io.github.gabrielstz120.config.SpringContext;
import io.github.gabrielstz120.services.MedicoService;
import io.github.gabrielstz120.views.CadastroMedicoView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CadastroMedicoListener extends ViewListener {

    private final CadastroMedicoView cadastroMedicoView;

    public CadastroMedicoListener(CadastroMedicoView cadastroMedicoView) {
        this.cadastroMedicoView = cadastroMedicoView;
        addListener();
    }

    @Override
    void addListener() {
        cadastroMedicoView.getButtonsList().forEach(bt -> bt.addActionListener(this));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Novo":
                cadastroMedicoView.clear();
                break;
            case "Salvar":
                salvar();
                break;
            case "Fechar":
                fechar(cadastroMedicoView);
                break;
        }
    }

    private void salvar() {
        try {
            if (SpringContext.getContext().getBean(MedicoService.class).saveOrUpdate(cadastroMedicoView.getMedico()).getId() != null) {
                JOptionPane.showMessageDialog(cadastroMedicoView, "Registro salvo com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(cadastroMedicoView, "Erro ao tentar salvar o médico", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(cadastroMedicoView, "Algo está errado nos dados informados", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
        }
    }

}
