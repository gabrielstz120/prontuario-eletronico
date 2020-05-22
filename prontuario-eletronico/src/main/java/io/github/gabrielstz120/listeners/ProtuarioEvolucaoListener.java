package io.github.gabrielstz120.listeners;

import io.github.gabrielstz120.config.SpringContext;
import io.github.gabrielstz120.models.Paciente;
import io.github.gabrielstz120.services.ProntuarioService;
import io.github.gabrielstz120.services.ReceitaService;
import io.github.gabrielstz120.views.ProntuarioEvolucaoView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ProtuarioEvolucaoListener extends ViewListener {

    private final ProntuarioEvolucaoView prontuarioEvolucaoView;

    public ProtuarioEvolucaoListener(ProntuarioEvolucaoView prontuarioEvolucaoView) {
        this.prontuarioEvolucaoView = prontuarioEvolucaoView;
        addListener();
        initListaMedicos();
    }

    private void initListaMedicos() {
        prontuarioEvolucaoView.addListaMedicos(SpringContext.getContext().getBean(ReceitaService.class).getListaMedicos());
    }

    @Override
    void addListener() {
        prontuarioEvolucaoView.getButtonsList().forEach(bt -> bt.addActionListener(this));
        prontuarioEvolucaoView.getTxtCpf().addFocusListener(findPacienteByCpf());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Novo":
                prontuarioEvolucaoView.clear();
                break;
            case "Salvar":
                salvar();
                break;
            case "Fechar":
                fechar(prontuarioEvolucaoView);
                break;
        }
    }

    private FocusAdapter findPacienteByCpf() {
        return new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent event) {
                Long cpfPaciente = prontuarioEvolucaoView.getCpfPaciente();
                if (cpfPaciente != null) {
                    Paciente paciente = SpringContext.getContext().getBean(ProntuarioService.class).findByCpf(cpfPaciente);
                    if (paciente != null) {
                        prontuarioEvolucaoView.setNomePaciente(paciente.getNome());
                    } else {
                        JOptionPane.showMessageDialog(prontuarioEvolucaoView, "Esse paciente não foi encontrado na base de dados", "Registro não encontrado", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(prontuarioEvolucaoView, "Digite um número de CPF válido", "CPF inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }

    private void salvar() {
        try {
            if (SpringContext.getContext().getBean(ProntuarioService.class).saveOrUpdate(prontuarioEvolucaoView.getProntuario()).getId() != null) {
                JOptionPane.showMessageDialog(prontuarioEvolucaoView, "Atendimento salvo com sucesso", "Atendimento Salvo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(prontuarioEvolucaoView, "Erro ao tentar salvar a atendimento", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(prontuarioEvolucaoView, "Erro ao tentar salvar a atendimento", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
        }
    }

}
