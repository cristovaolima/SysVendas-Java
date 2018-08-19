package model.dao;

import connection.ConnectionFactory;
import sysvenda.bean.Usuario;
import Telas.CadastrosUsuario;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sysvenda.bean.Cliente;

public class UsuarioDAO extends CadastrosUsuario{
    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    ConnectionFactory comx = new ConnectionFactory();
    Usuario usuario = new Usuario();
    
    private Connection connection;
        public UsuarioDAO()
        {
            this.connection = new ConnectionFactory().getConnection();
        }
        
        public void adicionarUsuario(Usuario usuario)
	{
		usuarios.add(usuario);
	}

	public void exibirUsuario()
	{
		for(Usuario usuario : usuarios)
		{
			System.out.printf("Nome: %s - Senha: %s\n", usuario.getNome(), usuario.getSenha());
		}
	}

        public List<Usuario> getList()
        {
            try {
                List<Usuario> usuarios = new ArrayList<Usuario>();
                PreparedStatement stmt = connection.prepareStatement("select * from usuarios");
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    Usuario usuario = new Usuario();
                    usuario.setId_usuario((int)rs.getLong("usu_id"));
                    usuario.setNome(rs.getString("usu_nome"));
                    usuario.setSenha(rs.getString("usu_senha"));
                    usuarios.add(usuario);
                }
                rs.close();
                stmt.close();
                return usuarios;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível carregar os dados no BD. ERRO: " + e);
            }
            return null;
        }
        
        public void adicionarUsuarioBD(Usuario usuario)
        {
            String sql = "insert into usuarios (usu_nome, usu_senha) values(?,?)";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, usuario.getNome());
                stmt.setString(2, usuario.getSenha());
                stmt.execute();
                stmt.close();
                JOptionPane.showMessageDialog(null, "Usuario Salvo!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Não foi possivél salvar o usuário! ERRO: " + e);
            }
        }
    
    public void alteraUsuarioBD(Usuario usuario)
    {
        comx.conexao();
        try {
            PreparedStatement pst = comx.com.prepareStatement("update usuarios set usu_nome=?,usu_senha=? where usu_id=?");
            pst.setString(1, usuario.getNome());
            pst.setString(2, usuario.getSenha());
            pst.setInt(3, usuario.getId_usuario());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados alterados com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Não foi possivél alterar os dados!");
        }
    }
    
    public void deletarUsuarioBD(long id)
    {        
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from usuarios where usu_id=?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
      public Usuario buscaUsuarioBD(Usuario usaurio)
      {
          comx.conexao();
          comx.executaSql("select * from usuarios where usu_nome like'%"+usuario.getPesquisa()+"%'");
        try {
            comx.rs.first();
            usuario.setId_usuario(comx.rs.getInt("usu_id"));
            usuario.setNome(comx.rs.getString("usu_nome"));
            usuario.setSenha(comx.rs.getString("usu_senha"));
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivél econtrar o usuário! ERRO: " + ex);
        }    
        comx.desconecta();
        return usaurio;
      }
}
