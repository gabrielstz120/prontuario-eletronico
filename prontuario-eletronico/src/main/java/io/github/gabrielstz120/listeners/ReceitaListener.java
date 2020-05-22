package io.github.gabrielstz120.listeners;

import io.github.gabrielstz120.config.SpringContext;
import io.github.gabrielstz120.models.Paciente;
import io.github.gabrielstz120.services.ReceitaService;
import io.github.gabrielstz120.views.ReceitaView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ReceitaListener extends ViewListener {
    private final ReceitaView receitaView;

    public ReceitaListener(ReceitaView receitaView) {
        this.receitaView = receitaView;
        addListener();
    }

    @Override
    void addListener() {
        receitaView.getButtonList().forEach(bt -> bt.addActionListener(this));
        receitaView.getTxtCpf().addFocusListener(findPacienteByCpf());
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        switch (event.getActionCommand()) {
            case "Adicionar linha":
                receitaView.addMedicamento();
                break;
            case "Remover linha":
                receitaView.removeMedicamento();
                break;
            case "Novo":
                receitaView.clear();
                break;
            case "Salvar":
                salvar();
                break;
            case "Fechar":
                fechar(receitaView);
                break;
        }
    }

    private FocusAdapter findPacienteByCpf() {
        return new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent event) {
                Long cpfPaciente = receitaView.getCpfPaciente();
                if (cpfPaciente != null) {
                    Paciente paciente = SpringContext.getContext().getBean(ReceitaService.class).findByCpf(cpfPaciente);
                    if (paciente != null) {
                        receitaView.setNomePaciente(paciente.getNome());
                    } else {
                        JOptionPane.showMessageDialog(receitaView, "Esse paciente não foi encontrado na base de dados", "Registro não encontrado", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(receitaView, "Digite um número de CPF válido", "CPF inválido", JOptionPane.ERROR_MESSAGE);
                }
            }
        };
    }

    private void salvar() {
        try {
            if (SpringContext.getContext().getBean(ReceitaService.class).saveOrUpdate(receitaView.getReceita()).getId() != null) {
                JOptionPane.showMessageDialog(receitaView, "Registro salvo com sucesso", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(receitaView, "Erro ao tentar salvar a receita", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(receitaView, "Algo está errado nos dados informados", "Erro ao salvar", JOptionPane.ERROR_MESSAGE);
        }
    }

}
