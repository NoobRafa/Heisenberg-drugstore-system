/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.poo.telas;

import com.poo.dao.ClienteDAO;
import com.poo.dao.CompraDAO;
import com.poo.dao.MedicamentoDAO;
import com.poo.entidades.Cliente;
import com.poo.entidades.Compra;
import com.poo.entidades.Medicamento;
import com.poo.exceptions.CampoException;
import com.poo.tela.models.ClienteTableModel;
import com.poo.tela.models.MedicamentoTableModel;
import com.poo.util.JpaUtil;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Rafael Vieira
 */
public class CadastroCompra extends javax.swing.JInternalFrame {

    /**
     * Creates new form CadastroCompra
     */
    private static CadastroCompra cadastroCompra;
    private ClienteDAO daoCliente = new ClienteDAO(JpaUtil.getEM());
    private List<Cliente> listaClientes = daoCliente.listarClientes();
    private ClienteTableModel modeloCliente = new ClienteTableModel(listaClientes);

    private MedicamentoDAO daoMedicamento = new MedicamentoDAO(JpaUtil.getEM());
    private List<Medicamento> listaMedicamentos = daoMedicamento.listarMedicamentos();
    private List<Medicamento> listaCarrinho = new ArrayList<>();
    private MedicamentoTableModel modeloMedicamento = new MedicamentoTableModel(listaMedicamentos);

    private CompraDAO daoCompra = new CompraDAO(JpaUtil.getEM());

    private NumberFormat formato = NumberFormat.getNumberInstance();

    private double valorParcial = 0;
    
    private List<Integer> qtdsMedcsCompra = new ArrayList<>();//AQUI

    private CadastroCompra() {
        initComponents();
    }

    public static synchronized CadastroCompra getInstance() {
        if (cadastroCompra == null) {
            cadastroCompra = new CadastroCompra();
        }
        return cadastroCompra;
    }

    @Override
    public void dispose() {
//        limpar(Arrays.asList(nomeCliente, nomeMedicamento, quantidade));
        cadastroCompra = null;
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

    private void continuar() {
        OUTER:
        while (true) {
            String resposta = JOptionPane.showInputDialog("Deseja continuar ? [S/N]");

            if (resposta == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada!");
                dispose();
                break;
            }

            switch (resposta) {
                case "S":
                    limpar(Arrays.asList(nomeCliente, nomeMedicamento, quantidade));
                    break OUTER;
                case "N":
                    JOptionPane.showMessageDialog(null, "Operação cancelada!");
                    dispose();
                    break OUTER;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida! - Tente usar S ou N.");

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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaMedicamento = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JTextField();
        buscarCliente = new javax.swing.JButton();
        nomeMedicamento = new javax.swing.JTextField();
        buscarMedicamento = new javax.swing.JButton();
        formato.setMaximumIntegerDigits(3);
        formato.setMinimumIntegerDigits(2);
        quantidade = new JFormattedTextField(formato);
        jLabel7 = new javax.swing.JLabel();
        caixaDeEscolha = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        comprar = new javax.swing.JButton();
        carrinho = new javax.swing.JButton();
        total = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Cadastro de Vendas");

        tabelaCliente.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        tabelaCliente.setModel(modeloCliente);
        tabelaCliente.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tabelaCliente);

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel5.setText("CLIENTES:  ");

        tabelaMedicamento.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        tabelaMedicamento.setModel(modeloMedicamento);
        tabelaMedicamento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(tabelaMedicamento);

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel6.setText("MEDICAMENTOS: ");

        buscarCliente.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        buscarCliente.setText("BUSCAR");
        buscarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarClienteActionPerformed(evt);
            }
        });

        buscarMedicamento.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        buscarMedicamento.setText("BUSCAR");
        buscarMedicamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarMedicamentoActionPerformed(evt);
            }
        });

        quantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(java.text.NumberFormat.getIntegerInstance())));

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel7.setText("TOTAL:");

        caixaDeEscolha.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        caixaDeEscolha.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "À VISTA", "A PRAZO" }));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel8.setText("QUANTIDADE DE PRODUTOS: ");

        jLabel9.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        jLabel9.setText("FORMA DE PAGAMENTO");

        comprar.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        comprar.setText("EFETUAR COMPRA");
        comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarActionPerformed(evt);
            }
        });

        carrinho.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        carrinho.setText("ADICIONAR AO CARRINHO");
        carrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carrinhoActionPerformed(evt);
            }
        });

        total.setEditable(false);
        total.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(total, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addComponent(comprar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buscarCliente))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nomeMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(buscarMedicamento))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel9)
                                    .addGap(13, 13, 13)
                                    .addComponent(caixaDeEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(48, 48, 48)
                            .addComponent(carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(buscarCliente)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nomeMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buscarMedicamento))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(caixaDeEscolha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(carrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comprar, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(total)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscarClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarClienteActionPerformed
        // TODO add your handling code here:
        if (!nomeCliente.getText().isEmpty()) {
            List<Cliente> aux = daoCliente.listarCliente(nomeCliente.getText());

            if (!aux.isEmpty()) {
                modeloCliente = new ClienteTableModel(aux);
                tabelaCliente.setModel(modeloCliente);
            } else {
                JOptionPane.showMessageDialog(null, "Cliente " + nomeCliente.getText() + " não foi encontrado!");
                nomeCliente.setText(null);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Verifique o campo ou o carrinho antes de tentar realizar uma busca!");
        }


    }//GEN-LAST:event_buscarClienteActionPerformed

    private void carrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carrinhoActionPerformed
        // TODO add your handling code here:

        try {
            if (quantidade.getValue() == null) {
                throw new CampoException("Verifique os Campos!");
            } else {
                int qtd = ((Number) quantidade.getValue()).intValue();

                if (tabelaCliente.getSelectedRow() != -1 && tabelaMedicamento.getSelectedRow() != -1 && qtd > 0) {

                    Medicamento medicamento = modeloMedicamento.getRow(tabelaMedicamento.getSelectedRow());

                    if (qtd <= medicamento.getEstoque().getQuantidade() && medicamento.getEstoque().getQuantidade() > 0) {

                        OUTER:
                        while (true) {
                            try {
                                String resposta = JOptionPane.showInputDialog("Deseja realmente adicionar o produto "
                                        + medicamento.getDescricao() + " x " + qtd + "? [S/N]");
                                switch (resposta) {
                                    case "S":
                                        listaCarrinho.add(medicamento);
                                        qtdsMedcsCompra.add(qtd);//AQUI
                                        medicamento.getEstoque().setQuantidade(medicamento.getEstoque().getQuantidade() - qtd);
                                        modeloMedicamento.setValueAt(medicamento.getEstoque().getQuantidade(), tabelaMedicamento.getSelectedRow(), 4);
                                        valorParcial += medicamento.getPreco() * Integer.parseInt(quantidade.getText());
                                        valorParcial = Math.rint(valorParcial);
                                        total.setText(Double.toString(valorParcial));
                                        JOptionPane.showMessageDialog(null, "Produto Adicionado com sucesso!");
                                        break OUTER;
                                    case "N":
                                        JOptionPane.showMessageDialog(null, "Operação Cancelada!");
                                        limpar(Arrays.asList(quantidade, nomeCliente, nomeMedicamento));
                                        break OUTER;
                                    default:
                                        JOptionPane.showMessageDialog(null, "Opção Inválida, tente usar S ou N!");
                                }
                            } catch (NullPointerException e) {
                                JOptionPane.showMessageDialog(null, "Operação Cancelada");
                                break;
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Quantidade incompatível ou produto fora de estoque!");
                        limpar(Arrays.asList(quantidade));
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Selecione os campos antes de adicionar ao carrinho!");
                }
            }

        } catch (CampoException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_carrinhoActionPerformed

    private void buscarMedicamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscarMedicamentoActionPerformed
        // TODO add your handling code here:
        if (!nomeMedicamento.getText().isEmpty()) {
            List<Medicamento> aux = daoMedicamento.listarMedicamento(nomeMedicamento.getText());
            if (!aux.isEmpty()) {
                modeloMedicamento = new MedicamentoTableModel(aux);
                tabelaMedicamento.setModel(modeloMedicamento);
            } else {
                JOptionPane.showMessageDialog(null, "Medicamento " + nomeMedicamento.getText() + " não foi encontrado!");
                nomeMedicamento.setText(null);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Verifique o campo antes de tentar realizar uma busca!");
        }

    }//GEN-LAST:event_buscarMedicamentoActionPerformed

    private void comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprarActionPerformed
        // TODO add your handling code here:
        if (!listaCarrinho.isEmpty() && tabelaCliente.getSelectedRow() != -1) {
            Cliente cliente = modeloCliente.getRow(tabelaCliente.getSelectedRow());

            Compra compra = new Compra();

            compra.setHorario(Calendar.getInstance());
            compra.setCliente(cliente);
            compra.setMedicamentos(listaCarrinho);
            compra.setTotal(valorParcial);
            compra.setQtdsMedcsCompra(qtdsMedcsCompra);//AQUI

            String str = (String) caixaDeEscolha.getSelectedItem();

            if (str.equals("À VISTA")) {
                compra.setPagamento(true);
            } else {
                compra.setPagamento(false);
            }

            daoCompra.inserirCompra(compra);

            List<Compra> auxCompra = new ArrayList<>();
            auxCompra.add(compra);

            if (cliente.getCompras() == null) {
                cliente.setCompras(auxCompra);
            } else {
                cliente.getCompras().add(compra);
            }

            daoCliente.atualizarCliente(cliente);

            for (Medicamento listaMedcs : listaCarrinho) {
                if (listaMedcs.getCompras() == null) {
                    listaMedcs.setCompras(auxCompra);
                } else {
                    listaMedcs.getCompras().add(compra);
                }

                daoMedicamento.atualizarMedicamento(listaMedcs);
            }
            JOptionPane.showMessageDialog(null, "Compra do cliente " + cliente.getNome() + " realizada com sucesso!");
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Verifique os campos antes de tentar confirmar uma compra!");
        }
    }//GEN-LAST:event_comprarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buscarCliente;
    private javax.swing.JButton buscarMedicamento;
    private javax.swing.JComboBox<String> caixaDeEscolha;
    private javax.swing.JButton carrinho;
    private javax.swing.JButton comprar;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField nomeCliente;
    private javax.swing.JTextField nomeMedicamento;
    private javax.swing.JFormattedTextField quantidade;
    private javax.swing.JTable tabelaCliente;
    private javax.swing.JTable tabelaMedicamento;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
