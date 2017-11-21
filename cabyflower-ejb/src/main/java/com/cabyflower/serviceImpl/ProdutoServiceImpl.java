package com.cabyflower.serviceImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
public class ProdutoServiceImpl implements ProdutoService {
	
	@PersistenceContext(unitName = "cabyflowerUI")
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
		produto.setSeqProduto(produtoDTO.getIdProduto() != null ? produtoDTO.getIdProduto() : null);
		produto.setDesProduto(produtoDTO.getDescricaoProduto());
		produto.setEmpresa(empresaService.convertEmpresaDTOInEmpresa(produtoDTO.getEmpresa()));
		produto.setNomProduto(produtoDTO.getNomeProduto());
		produto.setQuaProduto(produtoDTO.getQuantidade());
		produto.setValProduto(produtoDTO.getValorProduto());
		produto.setTipoProduto(new TipoProduto(produtoDTO.getTipoProduto().getIdTipoProduto()));
		produto.setDatCriacao(produtoDTO.getDataCriacao());
		produto.setImagemProduto(produtoDTO.getImagemProduto() != null ? produtoDTO.getImagemProduto() : null);
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
		List<ProdutoDTO> listRetorno = new ArrayList<ProdutoDTO>();
		listProduto.forEach(produto -> {
			listRetorno.add(this.ConvertProdutoInProdutoDTO(produto));
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
		produtoDTO.setIdProduto(produto.getSeqProduto() != null ? produto.getSeqProduto() : null);
		produtoDTO.setDescricaoProduto(produto.getDesProduto());
		produtoDTO.setEmpresa(empresaService.convertEmpresaInEmpresaDTO(produto.getEmpresa()));
		produtoDTO.setNomeProduto(produto.getNomProduto());
		produtoDTO.setQuantidade(produto.getQuaProduto());
		produtoDTO.setValorProduto(produto.getValProduto());
		produtoDTO.setTipoProduto(new TipoProdutoDTO(produto.getTipoProduto().getSeqTipoProduto()));
		produtoDTO.setDataCriacao(produto.getDatCriacao());
		produtoDTO.setImagemProduto(produto.getImagemProduto() != null ? produto.getImagemProduto() : null);
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
		sql.append(" SELECT p FROM Produto p  order by p.datCriacao ASC");
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
		if(produto.getSeqProduto() != null)
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
		sql.append(" WHERE p.seqProduto = :idProduto ");
		
		Query query = em.createQuery(sql.toString());
		query.setParameter("idProduto", idProduto);
		return this.ConvertProdutoInProdutoDTO((Produto)query.getSingleResult());
	}

}
