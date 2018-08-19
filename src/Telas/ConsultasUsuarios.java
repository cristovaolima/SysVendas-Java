package Telas;

import connection.ConnectionFactory;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import model.dao.UsuarioDAO;
import sysvenda.bean.Usuario;

public class ConsultasUsuarios extends javax.swing.JInternalFrame {
    public int atualizar = 0;
    Usuario usuario = new Usuario();
    ConnectionFactory com =  new ConnectionFactory();
    UsuarioDAO dao = new UsuarioDAO();

    public ConsultasUsuarios() {
        initComponents();
        preencheTabela("select * from usuarios order by usu_nome");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaUsuarios = new javax.swing.JTable();
        bjEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtpesquisa = new javax.swing.JTextField();
        btBuscar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btListar = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);

        jScrollPane1.setViewportView(tabelaUsuarios);

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

        jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel1.setText("Nome:");

        txtpesquisa.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        btBuscar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btBuscar.setText("Buscar");
        btBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBuscarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("Consultas/Usuário");

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
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 623, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 291, Short.MAX_VALUE)
                        .addComponent(btListar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bjEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bjEditar)
                        .addComponent(btExcluir)
                        .addComponent(btListar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(txtpesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btBuscar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBuscarActionPerformed
        usuario.setPesquisa(txtpesquisa.getText());
        Usuario usuariomodel = dao.buscaUsuarioBD(usuario);
        txtpesquisa.setText(usuariomodel.getNome());
    }//GEN-LAST:event_btBuscarActionPerformed

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        preencheTabela("select * from usuarios order by usu_nome");
    }//GEN-LAST:event_btListarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int selecionada = tabelaUsuarios.getSelectedRow();
        if(selecionada == -1)
        {
            JOptionPane.showMessageDialog(null, "Selecione uma usuario na tabela para excluir!");
        }else{
            int id = (int) tabelaUsuarios.getValueAt(selecionada, 0);
            dao.deletarUsuarioBD(id);
            preencheTabela("select * from usuarios order by usu_nome");
        }        
    }//GEN-LAST:event_btExcluirActionPerformed

    private void bjEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bjEditarActionPerformed
        int selecionada = tabelaUsuarios.getSelectedRow();
        if(selecionada == -1)
        {
            JOptionPane.showMessageDialog(null, "Selecione uma usuario na tabela para editar!");
        }else{
            int id = (int) tabelaUsuarios.getValueAt(selecionada, 0);
            String nome = (String) tabelaUsuarios.getValueAt(selecionada, 1);
            String senha = (String) tabelaUsuarios.getValueAt(selecionada, 2);
            EditarUsuario editarusuario = new EditarUsuario();
            editarusuario.setVisible(true);
            editarusuario.receber(nome, senha, id);           
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
    private javax.swing.JTable tabelaUsuarios;
    private javax.swing.JTextField txtpesquisa;
    // End of variables declaration//GEN-END:variables
    
    public void preencheTabela(String sql){
       ArrayList dados = new ArrayList();
       String [] colunas = new String []{"ID", "Nome", "Senha"};
       com.conexao();
       com.executaSql(sql);
       try {
           com.rs.first();
           do{
               dados.add(new Object[]{com.rs.getInt("usu_id"),com.rs.getString("usu_nome"),com.rs.getString("usu_senha")});               
           }while(com.rs.next());
           
       } catch (SQLException e) {
      
       }
       UsuarioTableModel modelo = new UsuarioTableModel(dados, colunas);
       tabelaUsuarios.setModel(modelo);
       tabelaUsuarios.getColumnModel().getColumn(0).setPreferredWidth(100);
       tabelaUsuarios.getColumnModel().getColumn(0).setResizable(false);
       
       tabelaUsuarios.getColumnModel().getColumn(1).setPreferredWidth(979);
       tabelaUsuarios.getColumnModel().getColumn(1).setResizable(false);
       
       tabelaUsuarios.getColumnModel().getColumn(2).setPreferredWidth(250);
       tabelaUsuarios.getColumnModel().getColumn(2).setResizable(false);
       
       tabelaUsuarios.getTableHeader().setReorderingAllowed(false);       
       tabelaUsuarios.setAutoResizeMode(tabelaUsuarios.AUTO_RESIZE_OFF);       
       tabelaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);       
       com.desconecta();
   }
}
