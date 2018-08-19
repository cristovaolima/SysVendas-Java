package model.dao;

import sysvenda.bean.Produto;
import java.util.ArrayList;

public class ProdutoDAO {
    ArrayList<Produto> produtos = new ArrayList<Produto>();
  
        public void adicionarProduto(Produto produto)
	{
		produtos.add(produto);
	}
	
	public void removerProduto(Produto produto)
	{
		produtos.remove(produto);
	}
	
	public int tamanhoListaProduto()
	{
		return produtos.size();
	}
	
	public void exibirProduto()
	{
		for(Produto produto : produtos)
		{
			System.out.printf("Nome: %s - Quantidade em Estoque: %f\nLargura: %f - Comprimento: %f - Peso: %f \n\n", produto.getNome(), produto.getQt_estoque(), 
                        produto.getLargura(), produto.getComprimento(), produto.getPeso());
		}
	}
	
	public void localizarProduto(Produto produto)
	{
		if(produtos.contains(produto))
			System.out.printf("Nome: %s - Quantidade em Estoque: %f\nLargura: %f - Comprimento: %f - Peso: %f \n\n", produto.getNome(), produto.getQt_estoque(), 
                        produto.getLargura(), produto.getComprimento(), produto.getPeso());
		else
			System.out.println("Produto não encontrado!");		
	}
}
