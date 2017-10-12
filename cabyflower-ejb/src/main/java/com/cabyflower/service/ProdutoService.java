package com.cabyflower.service;

import java.util.List;

import javax.ejb.Local;

import com.cabiflower.dto.ProdutoDTO;
import com.cabyflower.entity.Produto;

@Local
public interface ProdutoService {

	/**
	 * convert listProdutoDTO in listProduto
	 * 
	 * @param listProdutoDTO
	 * @return listProduto
	 */
	List<Produto> convertListProdutoDTOInListProduto(List<ProdutoDTO> listProdutoDTO);

	/**
	 * convert produtoDTO in produto
	 * 
	 * @param produtoDTO
	 * @return produto
	 */
	Produto convertProdutoDTOInProduto(ProdutoDTO produtoDTO);

	/**
	 * convert listProduto in listProdutoDTO
	 * 
	 * @param listProduto
	 * @return listProdutoDTO
	 */
	List<ProdutoDTO> convertListProdutoInListProdutoDTO(List<Produto> listProduto);

	/**
	 * convert produto in produtoDTO
	 * 
	 * @param produto
	 * @return produtoDTO
	 */
	ProdutoDTO ConvertProdutoInProdutoDTO(Produto produto);

	/**
	 * get Produtos show in home
	 * 
	 * @return List of produtos
	 */
	List<ProdutoDTO> getProdutosForHome();

	/**
	 * save produto in db
	 * 
	 * @param produtoDTO
	 * @return produto of exibed in system
	 */
	ProdutoDTO save(ProdutoDTO produtoDTO);

	/**
	 * get produto in db
	 * 
	 * @param idProduto
	 * @return produto of exibed in system
	 */
	ProdutoDTO getProduto(Long idProduto);
}
