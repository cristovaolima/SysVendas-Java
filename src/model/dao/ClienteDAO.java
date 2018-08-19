package model.dao;
import Telas.CadastrosClientes;
import connection.ConnectionFactory;
import sysvenda.bean.Cliente;
import java.util.ArrayList;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import javax.swing.JOptionPane;
import sysvenda.bean.Usuario;

public class ClienteDAO extends CadastrosClientes
{
    ArrayList<Cliente> clientes = new ArrayList<Cliente>();
    ConnectionFactory comx = new ConnectionFactory();
    Cliente cliente = new Cliente();
    
    private Connection connection;
    
    public ClienteDAO(){
        this.connection = new ConnectionFactory().getConnection();
    }
  
        public void adicionarCliente(Cliente cliente)
	{
		clientes.add(cliente);
	}
	
	public void removerCliente(Cliente cliente)
	{
		clientes.remove(cliente);
	}
	
	public int tamanhoListaCliente()
	{
		return clientes.size();
	}
	
	public void exibirCliente()
	{
		for(Cliente cliente : clientes)
		{
			System.out.printf("Nome: %s\nCPF/CNPJ: %s - Data de Nacimento: %s\nEndereço\nCEP: %s - Rua: %s - Número: %s\nComplemento: %s - Bairro: %s\nCidade: %s/%s\nTelefone: %s - Celular: %s - E-mail: %s\n\n"
                              , cliente.getNome(), cliente.getCnpjcpf(), 
                                cliente.getDatanascimento().toString(), cliente.getCep(), cliente.getRua(), cliente.getNum_end(), cliente.getComplemento(),
                                cliente.getBairro(), cliente.getCidade(), cliente.getEstado(), cliente.getTelefone(), cliente.getCelular(), cliente.getEmail());
		}
	}
	
	public void localizarCliente(Cliente cliente)
	{
		if(clientes.contains(cliente))
			System.out.printf("Nome: %s\nCPF/CNPJ: %s - Data de Nacimento: %s\nEndereço\nCEP: %s - Rua: %s - Número: %s\nComplemento: %s - Bairro: %s\nCidade: %s/%s\nTelefone: %s - Celular: %s - E-mail: %s"
                              , cliente.getNome(), cliente.getCnpjcpf(), 
                                cliente.getDatanascimento().toString(), cliente.getCep(), cliente.getRua(), cliente.getNum_end(), cliente.getComplemento(),
                                cliente.getBairro(), cliente.getCidade(), cliente.getEstado(), cliente.getTelefone(), cliente.getCelular(), cliente.getEmail());
		else
			System.out.println("Cliente não encontrado!");		
	}
        
        public List<Cliente> getLista()
        {
            try {
                List<Cliente> clientes = new ArrayList<Cliente>();
                PreparedStatement stmt = connection.prepareStatement("select * from clientes");
                ResultSet rs = stmt.executeQuery();                
                while(rs.next()){
                    Cliente cliente =  new Cliente();
                    cliente.setNome(rs.getString("cl_nome"));
                    cliente.setCnpjcpf(rs.getString("cl_cpfcnpj"));
                    cliente.setDatanascimento(rs.getString("cl_datanasc"));
                    cliente.setCep(rs.getString("cl_cep"));
                    cliente.setRua(rs.getString("cl_rua"));
                    cliente.setNum_end(rs.getString("cl_numrua"));
                    cliente.setComplemento(rs.getString("cl_compemento"));                    
                    cliente.setBairro(rs.getString("cl_bairro"));
                    cliente.setCidade(rs.getString("cl_cidade"));
                    cliente.setEstado(rs.getString("cl_estado"));
                    cliente.setTelefone(rs.getString("cl_telefone"));                    
                    cliente.setCelular(rs.getString("cl_celular"));
                    cliente.setEmail(rs.getString("cl_email")); 
                    clientes.add(cliente);
                }
                rs.close();
                stmt.close();
                return clientes;
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Não foi possível carregar os dados no BD. ERRO: " + e);
            }
            return null;
        }
        
        public void adicionarClienteBD(Cliente cliente)
        {
            String sql = "insert into clientes (cl_nome, cl_cpfcnpj, cl_datanasc, cl_cep, cl_rua, cl_numrua, cl_compemento, cl_bairro, cl_cidade, cl_estado, cl_telefone, cl_celular, cl_email) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement stmt = connection.prepareStatement(sql);
                stmt.setString(1, cliente.getNome());
                stmt.setString(2, cliente.getCnpjcpf());
                stmt.setString(3, cliente.getDatanascimento());
                stmt.setString(4, cliente.getCep());
                stmt.setString(5, cliente.getRua());
                stmt.setString(6, cliente.getNum_end());
                stmt.setString(7, cliente.getComplemento());
                stmt.setString(8, cliente.getBairro());
                stmt.setString(9, cliente.getCidade());
                stmt.setString(10, cliente.getEstado());
                stmt.setString(11, cliente.getTelefone());
                stmt.setString(12, cliente.getCelular());
                stmt.setString(13, cliente.getEmail());                
                stmt.execute();
                stmt.close(); 
                JOptionPane.showMessageDialog(null, "Cliente Salvo!");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Não foi possivél salvar o cliente! ERRO: " + e);
            }
        }
        
    public void deletarClienteBD(long id)
    {        
        try {
            PreparedStatement stmt = connection.prepareStatement("delete from clientes where cl_id=?");
            stmt.setLong(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void alteraClienteBD(Cliente cc)
    {
        comx.conexao();
        try {
            PreparedStatement pst = comx.com.prepareStatement("update clientes set cl_nome=?,cl_cpfcnpj=?,cl_datanasc=?, cl_cep=?,cl_rua=?,cl_numrua=?,cl_compemento=?,cl_bairro=?,cl_cidade=?,cl_estado=?,cl_telefone=?,cl_celular=?,cl_email=? where cl_id=?");
            pst.setString(1, cc.getNome());
            pst.setString(2, cc.getCnpjcpf());
            pst.setString(3, cc.getDatanascimento());
            pst.setString(4, cc.getCep());
            pst.setString(5, cc.getRua());
            pst.setString(6, cc.getNum_end());
            pst.setString(7, cc.getComplemento());
            pst.setString(8, cc.getBairro());
            pst.setString(9, cc.getCidade());
            pst.setString(10, cc.getEstado());
            pst.setString(11, cc.getTelefone());
            pst.setString(12, cc.getCelular());
            pst.setString(13, cc.getEmail());
            pst.setInt(14, cc.getCod_cliente());
            pst.execute();
            JOptionPane.showMessageDialog(null,"Dados alterados com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,"Não foi possivél alterar os dados!");
        }
    }
    
    public Cliente buscaClienteBD(Cliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
