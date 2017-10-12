package com.cabyflower.serviceImpl;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.cabiflower.dto.ProdutoDTO;
import com.cabiflower.dto.TipoProdutoDTO;
import com.cabyflower.entity.Produto;
import com.cabyflower.entity.TipoProduto;
import com.cabyflower.service.EmpresaService;
import com.cabyflower.service.ProdutoService;

/**
 * @author pedrocotta
 *
 */
@Stateless
@Transactional(value = TxType.NOT_SUPPORTED)
@TransactionManagement
public class ProdutoServiceImpl implements ProdutoService {
	
	@PersistenceContext(unitName = "nameDB")
	private EntityManager em;

	@EJB
	private EmpresaService empresaService;

	/**
	 * convert listProdutoDTO in listProduto
	 * 
	 * @param listProdutoDTO
	 * @return listProduto
	 */
	@Override
	public List<Produto> convertListProdutoDTOInListProduto(List<ProdutoDTO> listProdutoDTO) {
		List<Produto> listRetorno = new LinkedList<>();
		listProdutoDTO.forEach(produtoDTO -> {
			listRetorno.add(this.convertProdutoDTOInProduto(produtoDTO));
		});
		return listRetorno;
	}

	/**
	 * convert produtoDTO in produto
	 * 
	 * @param produtoDTO
	 * @return produto
	 */
	@Override
	public Produto convertProdutoDTOInProduto(ProdutoDTO produtoDTO) {
		Produto produto = new Produto();
		produto.setIdProduto(produtoDTO.getIdProduto() != null ? produtoDTO.getIdProduto() : null);
		produto.setDescricaoProduto(produtoDTO.getDescricaoProduto());
		produto.setEmpresa(empresaService.convertEmpresaDTOInEmpresa(produtoDTO.getEmpresa()));
		produto.setNomeProduto(produtoDTO.getNomeProduto());
		produto.setQuantidade(produtoDTO.getQuantidade());
		produto.setValorProduto(produtoDTO.getValorProduto());
		produto.setTipoProduto(new TipoProduto(produtoDTO.getTipoProduto().getIdTipoProduto()));
		produto.setDataCriacao(produtoDTO.getDataCriacao());;
		return produto;
	}

	/**
	 * convert listProduto in listProdutoDTO
	 * 
	 * @param listProduto
	 * @return listProdutoDTO
	 */
	@Override
	public List<ProdutoDTO> convertListProdutoInListProdutoDTO(List<Produto> listProduto) {
		List<ProdutoDTO> listRetorno = new LinkedList<>();
		listProduto.forEach(produtoDTO -> {
			listRetorno.add(this.ConvertProdutoInProdutoDTO(produtoDTO));
		});
		return listRetorno;
	}

	/**
	 * convert produto in produtoDTO
	 * 
	 * @param produto
	 * @return produtoDTO
	 */
	@Override
	public ProdutoDTO ConvertProdutoInProdutoDTO(Produto produto) {
		ProdutoDTO produtoDTO = new ProdutoDTO();
		produtoDTO.setIdProduto(produto.getIdProduto() != null ? produto.getIdProduto() : null);
		produtoDTO.setDescricaoProduto(produto.getDescricaoProduto());
		produtoDTO.setEmpresa(empresaService.convertEmpresaInEmpresaDTO(produto.getEmpresa()));
		produtoDTO.setNomeProduto(produto.getNomeProduto());
		produtoDTO.setQuantidade(produto.getQuantidade());
		produtoDTO.setValorProduto(produto.getValorProduto());
		produtoDTO.setTipoProduto(new TipoProdutoDTO(produto.getTipoProduto().getIdTipoProduto()));
		produtoDTO.setDataCriacao(produto.getDataCriacao());
		return produtoDTO;
	}
	
	/**
	 * get Produtos show in home
	 * 
	 * @return List of produtos
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<ProdutoDTO> getProdutosForHome(){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT TOP 10 p FROM Produto p  order by p.dataCriacao ASC");
		Query query = em.createQuery(sql.toString());
		return this.convertListProdutoInListProdutoDTO(query.getResultList());
	}
	
	/**
	 * save produto in db
	 * 
	 * @param produtoDTO
	 * @return produto of exibed in system
	 */
	@Override
	public ProdutoDTO save(ProdutoDTO produtoDTO) {
		Produto produto = this.convertProdutoDTOInProduto(produtoDTO);
		if(produto.getIdProduto() != null)
			em.merge(produto);
		else
			em.persist(produto);
		return this.ConvertProdutoInProdutoDTO(produto);
	}
	
	/**
	 * get produto in db
	 * 
	 * @param idProduto
	 * @return produto of exibed in system
	 */
	@Override
	public ProdutoDTO getProduto(Long idProduto) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT p FROM Produto p ");
		sql.append(" WHERE p.idProduto = :idProduto ");
		
		Query query = em.createQuery(sql.toString());
		query.setParameter("idProduto", idProduto);
		return this.ConvertProdutoInProdutoDTO((Produto)query.getSingleResult());
	}

}
