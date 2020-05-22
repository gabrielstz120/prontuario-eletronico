package io.github.gabrielstz120.listeners;

import io.github.gabrielstz120.config.SpringContext;
import io.github.gabrielstz120.services.ExameService;
import io.github.gabrielstz120.views.ExamesView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ExameListener extends ViewListener {

    private final ExamesView examesView;

    public ExameListener(ExamesView examesView) {
        this.examesView = examesView;
        addListener();
    }

    @Override
    void addListener() {
        examesView.getButtonsList().forEach(bt -> bt.addActionListener(this));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Novo":
                examesView.clear();
                break;
            case "Salvar":
                salvar();
                break;
            case "Fechar":
                fechar(examesView);
                break;
        }
    }

    private void salvar() {
        try {
            if (SpringContext.getContext().getBean(ExameService.class).saveOrUpdate(examesView.getExame()).getId() != null) {
                JOptionPane.showMessageDialog(examesView, "Exame salvo com sucesso", "Exame Salvo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(examesView, "Erro ao tentar salvar a exame", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(examesView, "Erro ao tentar salvar a exame", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
        }
    }

}
