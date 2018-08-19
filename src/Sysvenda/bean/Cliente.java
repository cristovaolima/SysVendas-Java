package sysvenda.bean;

public class Cliente extends Pessoa
{
	private String telefone;
	private String celular;
	private String email;
	private int cod_cliente;
        private String pesquisa;

        public String getPesquisa() {
            return pesquisa;
        }

        public void setPesquisa(String pesquisa) {
            this.pesquisa = pesquisa;
        }        
        
	public String getTelefone() 
	{
		return telefone;
	}
	public void setTelefone(String telefone) 
	{
		this.telefone = telefone;
	}
	public String getCelular() 
	{
		return celular;
	}
	public void setCelular(String celular) 
	{
		this.celular = celular;
	}
	public String getEmail() 
	{
		return email;
	}
	public void setEmail(String email) 
	{
		this.email = email;
	}
	public int getCod_cliente() 
	{
		return cod_cliente;
	}
	public void setCod_cliente(int cod_cliente) 
	{
		this.cod_cliente = cod_cliente;
	}
}