package sysvenda.bean;

public class Produto 
{
	private String nome;
	private float largura;
	private float comprimento;
	private float peso;
        private float qt_estoque;
	private int cod_produto;

        public float getQt_estoque() {
            return qt_estoque;
        }

        public void setQt_estoque(float qt_estoque) {
            this.qt_estoque = qt_estoque;
        }
        
	
	public int getCod_produto() {
		return cod_produto;
	}
	public void setCod_produto(int cod_produto) {
		this.cod_produto = cod_produto;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public float getLargura() 
	{
		return largura;
	}
	public void setLargura(float largura) 
	{
		this.largura = largura;
	}
	public float getComprimento() 
	{
		return comprimento;
	}
	public void setComprimento(float comprimento) 
	{
		this.comprimento = comprimento;
	}
	public float getPeso() 
	{
		return peso;
	}
	public void setPeso(float peso) 
	{
		this.peso = peso;
	}
}
