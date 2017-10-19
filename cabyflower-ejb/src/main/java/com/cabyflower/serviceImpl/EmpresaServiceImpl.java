package com.cabyflower.serviceImpl;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cabiflower.dto.EmpresaDTO;
import com.cabiflower.dto.EmpresaFIlterDTO;
import com.cabyflower.entity.Empresa;
import com.cabyflower.service.EmpresaService;
import com.cabyflower.service.EnderecoService;
import com.cabyflower.service.ProdutoService;
import com.cabyflower.service.UsuarioService;

@Stateless
public class EmpresaServiceImpl implements EmpresaService {

	@PersistenceContext(unitName = "cabyflowerUI")
	private EntityManager em;

	@EJB
	private UsuarioService usuarioService;

	@EJB
	private ProdutoService produtoService;

	@EJB
	private EnderecoService enderecoService;

	/**
	 * save Empresa
	 * 
	 * @Param empresaDTO
	 * @return empresaDTO persist in database
	 */
	@Override
	public EmpresaDTO save(EmpresaDTO empresaDTO) {
		Empresa empresa = this.convertEmpresaDTOInEmpresa(empresaDTO);
		if (empresa.getIdEmpresa() != null)
			em.merge(empresa);
		else
			em.persist(empresa);
		return this.convertEmpresaInEmpresaDTO(empresa);
	}

	/**
	 * convert EMpresaDTO in Empresa
	 * 
	 * @Param empresaDTO
	 * @return Empresa
	 */
	@Override
	public Empresa convertEmpresaDTOInEmpresa(EmpresaDTO empresaDTO) {
		Empresa empresa = new Empresa();
		empresa.setIdEmpresa(empresaDTO.getIdEmpresa() != null ? empresaDTO.getIdEmpresa() : null);
		empresa.setCnpj(empresaDTO.getCnpj());
		empresa.setEndereco(enderecoService.convertEnderecoDTOInEndereco(empresaDTO.getEndereco()));
		empresa.setNomeFantasia(empresaDTO.getNomeFantasia());
		empresa.setProdutos(produtoService.convertListProdutoDTOInListProduto(empresaDTO.getProdutos()));
		empresa.setRazaoSocial(empresaDTO.getRazaoSocial());
		empresa.setUsuario(usuarioService.convertUsuarioDTOInUsuario(empresaDTO.getUsuario()));
		empresa.setDataCriacao(empresaDTO.getDataCriacao());
		return empresa;
	}

	/**
	 * convert empresa in empresaDTO
	 * 
	 * @Param empresa
	 * @return empresaDTO
	 */
	public EmpresaDTO convertEmpresaInEmpresaDTO(Empresa empresa) {
		EmpresaDTO empresaDTO = new EmpresaDTO();
		empresaDTO.setIdEmpresa(empresa.getIdEmpresa() != null ? empresa.getIdEmpresa() : null);
		empresaDTO.setCnpj(empresa.getCnpj());
		empresaDTO.setEndereco(enderecoService.convertEnderecoInEnderecoDTO(empresa.getEndereco()));
		empresaDTO.setNomeFantasia(empresa.getNomeFantasia());
		empresaDTO.setProdutos(produtoService.convertListProdutoInListProdutoDTO(empresa.getProdutos()));
		empresaDTO.setRazaoSocial(empresa.getRazaoSocial());
		empresaDTO.setUsuario(usuarioService.convertUsuarioInUsuarioDTO(empresa.getUsuario()));
		empresaDTO.setDataCriacao(empresa.getDataCriacao());
		return empresaDTO;
	}
	
	/**
	 * get Empresa contains idEmpresa
	 * 
	 * @Param idEmpresa
	 * @return empresaDTO
	 */
	@Override
	public EmpresaDTO findOne(Long idEmpresa) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT e FROM Empresa e WHERE e.idEmpresa = :idEmpresa ");

		Query query = em.createQuery(sql.toString());
		query.setParameter("idEmpresa", idEmpresa);

		return this.convertEmpresaInEmpresaDTO((Empresa) query.getSingleResult());
	}
	
	/**
	 * get Empresas for filter
	 * 
	 * @Param empresaFilter
	 * @return empresaDTOList
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<EmpresaDTO> getEmpresaForFilter(EmpresaFIlterDTO empresaFilter){
		StringBuffer sql = new StringBuffer();
		sql.append("SELECT e FROM Empresa e WHERE ");
		sql.append(" e.endereco.municipio.nomeMunicipio = :nomeMunicipio ");
		if(empresaFilter.getNomeFantasia() != null) {
			sql.append(" AND e.nomeFantasia = :nomeFantasia ");
		}
		if(empresaFilter.getRazaoSocial() != null) {
			sql.append(" AND e.razaoSocial = :razaoSocial ");
		}
		
		Query query = em.createQuery(sql.toString());
		query.setParameter("nomeMunicipio", empresaFilter.getNomeMunicipio());
		query.setParameter("npmeFantasia", empresaFilter.getNomeFantasia());
		query.setParameter("razaoSocial", empresaFilter.getRazaoSocial());
		
		return this.convertListEmpresaInListEmpresaDTO(query.getResultList());
	}
	
	/**
	 * convert listEmpresa in listEmpresaDTO
	 * 
	 * @Param empresaList
	 * @return empresaDTOList
	 */
	private List<EmpresaDTO> convertListEmpresaInListEmpresaDTO(List<Empresa> empresaList){
		List<EmpresaDTO> listRetorno = new LinkedList<>();
		empresaList.forEach(empresa -> {
			listRetorno.add(this.convertEmpresaInEmpresaDTO(empresa));
		});
		return listRetorno;
	}
	
	/**
	 * get Empresa for usuario
	 * 
	 * @Param idUsuario
	 * @return EmpresaDTO
	 */
	@Override
	public EmpresaDTO getEmpresaForUsuario(Long idUsuario) {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT e FROM Empresa e where e.usuario.idUser = :idUsuario ");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idUsuario", idUsuario);
		return this.convertEmpresaInEmpresaDTO((Empresa)query.getSingleResult());
	}

}
