package io.github.gabrielstz120.tables;

import io.github.gabrielstz120.models.Medicamento;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class MedicamentoTableModel extends AbstractTableModel {

    private List<Medicamento> medicamentoList;
    private String[] columnNames = {"Via", "Medicamento", "Quantidade", "Periodicidade", "Tempo de uso"};

    public MedicamentoTableModel() {
        this.medicamentoList = new ArrayList();
    }

    @Override
    public int getRowCount() {
        return medicamentoList.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Medicamento medicamento = medicamentoList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return medicamento.getVia();
            case 1:
                return medicamento.getMedicamento();
            case 2:
                return medicamento.getQuantidade();
            case 3:
                return medicamento.getPeriodicidade();
            case 4:
                return medicamento.getTempoUso();
            default:
                return null;
        }
    }


    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Medicamento medicamento = medicamentoList.get(rowIndex);
        switch (columnIndex) {
            case 0:
                medicamento.setVia(aValue.toString());
                break;
            case 1:
                medicamento.setMedicamento(aValue.toString());
                break;
            case 2:
                medicamento.setQuantidade(aValue.toString());
                break;
            case 3:
                medicamento.setPeriodicidade(aValue.toString());
                break;
            case 4:
                medicamento.setTempoUso(aValue.toString());
                break;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public List<Medicamento> getMedicamentoList() {
        return medicamentoList;
    }

    public void addMedicamento() {
        medicamentoList.add(new Medicamento());
        fireTableDataChanged();
    }

    public void removeMedicamento(int row) {
        medicamentoList.remove(row);
        fireTableDataChanged();
    }

    public void clear() {
        medicamentoList.clear();
        fireTableDataChanged();
    }

}
