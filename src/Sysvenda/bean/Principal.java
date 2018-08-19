package sysvenda.bean;

import model.dao.UsuarioDAO;
import Telas.CadastroPrimeiroUsuario;
import Telas.TelaLogin;
import connection.ConnectionFactory;
import java.awt.Component;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.OK_CANCEL_OPTION;

public class Principal 
{
    public static void main(String[] args) 
    {    
        UsuarioDAO usuario = new UsuarioDAO();
        ConnectionFactory com = new ConnectionFactory();
        com.conexao();
        
        try {
            com.executaSql("select COUNT(*) from usuarios");
            com.rs.first();
            if(com.rs.getString("COUNT(*)").equals("0"))
            {
               System.out.println("Lista sem usuarios!");
               CadastroPrimeiroUsuario cusurio = new CadastroPrimeiroUsuario();
               cusurio.setVisible(true);
               cusurio.setExtendedState(CadastroPrimeiroUsuario.MAXIMIZED_BOTH);
               Component rootPane = null;
               int resp = JOptionPane.showConfirmDialog(rootPane, "Sistema sem usuários. Criar o primeiro?", " Sistema sem usuários!", OK_CANCEL_OPTION, INFORMATION_MESSAGE);
               if(resp == 2)
                   System.exit(0);
            }else{
               TelaLogin tela = new TelaLogin();
               tela.setVisible(true);
               tela.setExtendedState(TelaLogin.MAXIMIZED_BOTH);
        }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }    
}
