/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.telas;

import com.poo.tela.models.MedicamentoTableModel;
import com.poo.dao.MedicamentoDAO;
import com.poo.entidades.Medicamento;
import com.poo.util.JpaUtil;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Rafael Vieira
 */
public class EditarMedicamento extends javax.swing.JInternalFrame {

    private static EditarMedicamento editarMedicamento;

    private MedicamentoDAO dao = new MedicamentoDAO(JpaUtil.getEM());
    private List<Medicamento> medicamentos = dao.listarMedicamentos();
    
    private MedicamentoTableModel modelo = new MedicamentoTableModel(medicamentos);

    private NumberFormat formato = NumberFormat.getNumberInstance();

    /**
     * Creates new form EditarMedicamento
     */
    private EditarMedicamento() {
        initComponents();
    }

    public static synchronized EditarMedicamento getInstance() {
        if (editarMedicamento == null) {
            editarMedicamento = new EditarMedicamento();
        }
        return editarMedicamento;
    }

    @Override
    public void dispose() {
        limpar(Arrays.asList(descricao, fabricante, preco, quantidade));
        editarMedicamento = null;
        super.dispose(); //To change body of generated methods, choose Tools | Templates.
    }

    private void limpar(List<JComponent> unit) {
        for (JComponent jComponent : unit) {
            if (jComponent instanceof JTextField) {
                ((JTextField) jComponent).setText(null);
            }

            if (jComponent instanceof JFormattedTextField) {
                ((JFormattedTextField) jComponent).setValue(null);
                ((JFormattedTextField) jComponent).setText(null);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel5 = new javax.swing.JLabel();
        descricao = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        formato.setMaximumFractionDigits(3);
        formato.setMinimumFractionDigits(2);
        preco = new JFormattedTextField(formato);

        jLabel6 = new javax.swing.JLabel();
        fabricante = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        formato.setMaximumIntegerDigits(3);
        formato.setMinimumIntegerDigits(2);
        quantidade = new JFormattedTextField(formato);
        alterar = new javax.swing.JButton();
        excluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();

        setClosable(true);
        setTitle("Editar Medicamento");

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("DESCRIÇÃO:");

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setText("PREÇO:");

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("FABRICANTE:");

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel8.setText("QTD:");

        quantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        alterar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        alterar.setText("ALTERAR MEDICAMENTO");
        alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alterarActionPerformed(evt);
            }
        });

        excluir.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        excluir.setText("EXCLUIR MEDICAMENTO");
        excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excluirActionPerformed(evt);
            }
        });

        tabela.setModel(modelo);
        tabela.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabela);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(alterar)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(excluir)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(29, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(54, 54, 54))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(preco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(fabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(excluir)
                    .addComponent(alterar))
                .addGap(37, 37, 37))
        );

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alterarActionPerformed
        // TODO add your handling code here:

        if (tabela.getSelectedRow() != -1 && !medicamentos.isEmpty()) {
            boolean verificar = false;
            Medicamento modificado;
            modificado = medicamentos.get(tabela.getSelectedRow());

            if (descricao.getText().length() >= 5) {
                modificado.setDescricao(descricao.getText());
                modelo.setValueAt(descricao.getText(), tabela.getSelectedRow(), 1);
                verificar = true;

            }

            if (fabricante.getText().length() >= 5) {
                modificado.setFabricante(fabricante.getText());
                modelo.setValueAt(fabricante.getText(), tabela.getSelectedRow(), 2);
                verificar = true;

            }

            if (preco.getValue() != null && ((Number) preco.getValue()).doubleValue() > 0) {
                modificado.setPreco(((Number) preco.getValue()).doubleValue());
                modelo.setValueAt(((Number) preco.getValue()).doubleValue(), tabela.getSelectedRow(), 3);
                verificar = true;

            }

            if (quantidade.getValue() != null && ((Number) quantidade.getValue()).intValue() > 0) {
                modificado.getEstoque().setQuantidade(modificado.getEstoque().getQuantidade()
                        + ((Number) quantidade.getValue()).intValue());
                modelo.setValueAt(modificado.getEstoque().getQuantidade(), tabela.getSelectedRow(), 4);
                verificar = true;

            }

            if (verificar) {
                dao.atualizarMedicamento(modificado);
                limpar(Arrays.asList(descricao, fabricante, preco, quantidade));
                JOptionPane.showMessageDialog(null, "Alteração(ões) realizada(s) com sucesso !");
            } else {
                limpar(Arrays.asList(descricao, fabricante, preco, quantidade));
                JOptionPane.showMessageDialog(null, "Verifique os campos antes de tentar alterar!");
            }

        } else {
            JOptionPane.showMessageDialog(null, "Verifique se existe ou foi selecionado algum medicamento!");
        }
    }//GEN-LAST:event_alterarActionPerformed

    private void excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excluirActionPerformed
        // TODO add your handling code here:
        if (tabela.getSelectedRow() != -1 && !medicamentos.isEmpty()) {

            dao.removerMedicamento(modelo.removeRow(tabela.getSelectedRow()));
            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum medicamento cadastrado!");
        }
    }//GEN-LAST:event_excluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton alterar;
    private javax.swing.JTextField descricao;
    private javax.swing.JButton excluir;
    private javax.swing.JTextField fabricante;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField preco;
    private javax.swing.JFormattedTextField quantidade;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
