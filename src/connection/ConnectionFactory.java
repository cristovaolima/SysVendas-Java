package connection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class ConnectionFactory{
    public Statement stm;
    public ResultSet rs;
    private String driver = "com.mysql.jdbc.Driver";
    private String caminho = "jdbc:mysql://localhost:3306/sysvenda";
    private String usuario = "root";
    private String senha = "";
    public Connection com;    
    
    public Connection getConnection(){
        try{
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/sysvenda", "root", "");
        }catch(SQLException e) {
            throw new RuntimeException(e);
        }
    } 
    
    public void conexao()
    {
        try {
            System.setProperty("jdbc.Drivers", driver);
            com = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "ERRO de conexão com o Banco de Dados! \nErro:" + ex);
        }
    }
    
    public void desconecta()
    {
        try {
            com.close();
            //JOptionPane.showMessageDialog(null, "BD desconectado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão com o BD");
        }
    }
    
    public void executaSql(String sql)
    {
        try {
            stm = com.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao executar BD! ERRO: "+ ex);
        }
    }
} 
