package Telas;

import connection.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import model.dao.ClienteDAO;
import sysvenda.bean.Cliente;

public class ConsultasClientes extends javax.swing.JInternalFrame {
    Cliente cliente = new Cliente();
    ConnectionFactory com =  new ConnectionFactory();
    ClienteDAO dao = new ClienteDAO();
    
    public ConsultasClientes() {
        initComponents();
        preencheTabela("select * from clientes order by cl_nome");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtpesquisa = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        bjEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaClientes = new javax.swing.JTable();
        btListar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        txtpesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        bjEditar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        bjEditar.setText("Editar");
        bjEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bjEditarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Consultas/Clientes");

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        tabelaClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaClientes);

        btListar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btListar.setText("Listar todos");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 287, Short.MAX_VALUE)
                        .addComponent(btListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bjEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btBuscar)
                    .addComponent(bjEditar)
                    .addComponent(btExcluir)
                    .addComponent(btListar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        cliente.setPesquisa(txtpesquisa.getText());
        Cliente clientemodel = dao.buscaClienteBD(cliente);
        txtpesquisa.setText(clientemodel.getNome());
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        preencheTabela("select * from clientes order by cl_nome");
    }//GEN-LAST:event_btListarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int selecionada = tabelaClientes.getSelectedRow();
        if(selecionada == -1)
        {
            JOptionPane.showMessageDialog(null, "Selecione uma cliente na tabela para excluir!");
        }else{
            int id = (int) tabelaClientes.getValueAt(selecionada, 0);
            System.out.println(id);
            dao.deletarClienteBD(id);
            preencheTabela("select * from clientes order by cl_nome");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void bjEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bjEditarActionPerformed
        int selecionada = tabelaClientes.getSelectedRow();
        if(selecionada == -1)
        {
            JOptionPane.showMessageDialog(null, "Selecione um cliente na tabela para editar!");
        }else{
            int id = (int) tabelaClientes.getValueAt(selecionada, 0);
            String nome = (String) tabelaClientes.getValueAt(selecionada, 1);
            String cpf = (String) tabelaClientes.getValueAt(selecionada, 2);
            String datanasc = (String) tabelaClientes.getValueAt(selecionada, 3);
            String cep = (String) tabelaClientes.getValueAt(selecionada, 4);
            String rua= (String) tabelaClientes.getValueAt(selecionada, 5);
            String num = (String) tabelaClientes.getValueAt(selecionada, 6);
            String complemento = (String) tabelaClientes.getValueAt(selecionada, 7);
            String bairro = (String) tabelaClientes.getValueAt(selecionada, 8);
            String cidade = (String) tabelaClientes.getValueAt(selecionada, 9);
            String estado = (String) tabelaClientes.getValueAt(selecionada, 10);
            String telefone = (String) tabelaClientes.getValueAt(selecionada, 11);
            String celular = (String) tabelaClientes.getValueAt(selecionada, 12);
            String email = (String) tabelaClientes.getValueAt(selecionada, 13);
    
            EditarCliente editarcliente = new EditarCliente();
            editarcliente.setVisible(true);
            editarcliente.receber(nome, cpf, datanasc, cep, rua, num, complemento, bairro, cidade, estado, telefone, celular, email, id);           
            preencheTabela("select * from usuarios order by usu_nome");
        }
    }//GEN-LAST:event_bjEditarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bjEditar;
    private javax.swing.JButton btBuscar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btListar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaClientes;
    private javax.swing.JTextField txtpesquisa;
    // End of variables declaration//GEN-END:variables
    
    public void preencheTabela(String sql){
       ArrayList dados = new ArrayList();
       String [] colunas = new String []{"ID", "Nome", "CPF/CNPJ", "Data de Nasc.", "CEP", "Rua", "Número", "Complemento", "Bairro", "Cidade", "Estado", "Telefone", "Celular", "E-mail"};;
       com.conexao();
       com.executaSql(sql);
       try {
           com.rs.first();
           do{
               dados.add(new Object[]{com.rs.getInt("cl_id"),com.rs.getString("cl_nome"),com.rs.getString("cl_cpfcnpj"),com.rs.getString("cl_datanasc")
                       ,com.rs.getString("cl_cep"),com.rs.getString("cl_rua"),com.rs.getString("cl_numrua"),com.rs.getString("cl_compemento")
                       ,com.rs.getString("cl_bairro"),com.rs.getString("cl_cidade"),com.rs.getString("cl_estado"),com.rs.getString("cl_telefone")
                       ,com.rs.getString("cl_celular"),com.rs.getString("cl_email")});
               
           }while(com.rs.next());
           
       } catch (SQLException e) {
      
       }
       ClienteTableModel modelo = new ClienteTableModel(dados, colunas);
       tabelaClientes.setModel(modelo);
       //id
       tabelaClientes.getColumnModel().getColumn(0).setPreferredWidth(50);
       tabelaClientes.getColumnModel().getColumn(0).setResizable(false);
       //nome
       tabelaClientes.getColumnModel().getColumn(1).setPreferredWidth(250);
       tabelaClientes.getColumnModel().getColumn(1).setResizable(false);
       //cpf
       tabelaClientes.getColumnModel().getColumn(2).setPreferredWidth(100);
       tabelaClientes.getColumnModel().getColumn(2).setResizable(false);
       //data nasc.
       tabelaClientes.getColumnModel().getColumn(3).setPreferredWidth(80);
       tabelaClientes.getColumnModel().getColumn(3).setResizable(false);
       //cep
       tabelaClientes.getColumnModel().getColumn(4).setPreferredWidth(100);
       tabelaClientes.getColumnModel().getColumn(4).setResizable(false);
       //rua
       tabelaClientes.getColumnModel().getColumn(5).setPreferredWidth(150);
       tabelaClientes.getColumnModel().getColumn(5).setResizable(false);
       //número
       tabelaClientes.getColumnModel().getColumn(6).setPreferredWidth(70);
       tabelaClientes.getColumnModel().getColumn(6).setResizable(false);
       //complemento
       tabelaClientes.getColumnModel().getColumn(7).setPreferredWidth(400);
       tabelaClientes.getColumnModel().getColumn(7).setResizable(false);
       //bairro
       tabelaClientes.getColumnModel().getColumn(8).setPreferredWidth(150);
       tabelaClientes.getColumnModel().getColumn(8).setResizable(false);
       //cidade
       tabelaClientes.getColumnModel().getColumn(9).setPreferredWidth(120);
       tabelaClientes.getColumnModel().getColumn(9).setResizable(false);
       //estado
       tabelaClientes.getColumnModel().getColumn(10).setPreferredWidth(50);
       tabelaClientes.getColumnModel().getColumn(10).setResizable(false);
       //telefone
       tabelaClientes.getColumnModel().getColumn(11).setPreferredWidth(100);
       tabelaClientes.getColumnModel().getColumn(11).setResizable(false);
       //celular
       tabelaClientes.getColumnModel().getColumn(12).setPreferredWidth(100);
       tabelaClientes.getColumnModel().getColumn(12).setResizable(false);
       //email
       tabelaClientes.getColumnModel().getColumn(13).setPreferredWidth(250);
       tabelaClientes.getColumnModel().getColumn(13).setResizable(false); 
       
       tabelaClientes.getTableHeader().setReorderingAllowed(false);       
       tabelaClientes.setAutoResizeMode(tabelaClientes.AUTO_RESIZE_OFF);       
       tabelaClientes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);       
       com.desconecta();
   }    
}
