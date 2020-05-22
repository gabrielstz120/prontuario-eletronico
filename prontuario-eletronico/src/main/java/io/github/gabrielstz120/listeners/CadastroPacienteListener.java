package io.github.gabrielstz120.listeners;

import io.github.gabrielstz120.config.SpringContext;
import io.github.gabrielstz120.models.Paciente;
import io.github.gabrielstz120.services.PacienteService;
import io.github.gabrielstz120.views.CadastroPacienteView;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class CadastroPacienteListener extends ViewListener {

    private final CadastroPacienteView cadastroPacienteView;

    public CadastroPacienteListener(CadastroPacienteView cadastroPacienteView) {
        this.cadastroPacienteView = cadastroPacienteView;
        addListener();
    }

    @Override
    void addListener() {
        cadastroPacienteView.getButtonsList().forEach(bt -> bt.addActionListener(this));
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Novo":
                cadastroPacienteView.clear();
                break;
            case "Salvar":
                salvar();
                break;
            case "Fechar":
                fechar(cadastroPacienteView);
                break;
        }
    }

    private void salvar() {
        try {
            Paciente paciente = SpringContext.getContext().getBean(PacienteService.class).saveOrUpdate(cadastroPacienteView.getPaciente());
            if (paciente.getMatricula() != null) {
                cadastroPacienteView.setMatricula(paciente.getMatricula().toString());
                JOptionPane.showMessageDialog(cadastroPacienteView, "Registro salvo com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(cadastroPacienteView, "Erro ao tentar salvar o paciente", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(cadastroPacienteView, "Algo está errado nos dados informados", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
        }
    }

}
