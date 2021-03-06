package com.cabyflower.serviceImpl;

import java.util.LinkedList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.cabiflower.dto.UfDTO;
import com.cabyflower.entity.Uf;
import com.cabyflower.service.UfService;

@Stateless
public class UfServiceImpl implements UfService {
	
	@PersistenceContext(unitName = "cabyflowerUI")
	private EntityManager em;

	/**
	 * convert UfDTO in Uf
	 * 
	 * @param ufDTO
	 * @return uf
	 */
	@Override
	public Uf convertUfDtoInUf(UfDTO ufDTO) {
		Uf uf = new Uf();
		if (ufDTO.getIdUf() != null)
			uf.setSeqUf(ufDTO.getIdUf());
		uf.setNomUf(ufDTO.getNomeUf());
		return uf;
	}

	/**
	 * convert Uf in UfDTO
	 * 
	 * @param uf
	 * @return ufDTO
	 */
	@Override
	public UfDTO convertUfInUfDTO(Uf uf) {
		UfDTO ufDto = new UfDTO();
		ufDto.setIdUf(uf.getSeqUf() != null ? uf.getSeqUf() : null);
		ufDto.setNomeUf(uf.getNomUf());
		return ufDto;
	}
	
	/**
	 * get all uf in db
	 * 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<UfDTO> getAll(){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT u FROM Uf u");
		Query query = em.createQuery(sql.toString());
		return this.convertListEntityInListDTO(query.getResultList());
	}
	
	/**
	 * convert List<Uf> in List<UfDTO>
	 * 
	 * @param listUf
	 * @return listUfDTO
	 */
	private List<UfDTO> convertListEntityInListDTO(List<Uf> listUf){
		List<UfDTO> listUfDTO = new LinkedList<>();
		listUf.forEach(uf -> {
			listUfDTO.add(this.convertUfInUfDTO(uf));
		});
		return listUfDTO;
	}
	
	/**
	 * get uf exist in db
	 * 
	 * @param idMunicipio
	 * @return uf
	 */
	@Override
	public UfDTO findOne(Long idUf){
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT u FROM Uf u where u.seqUf = :idUf");
		Query query = em.createQuery(sql.toString());
		query.setParameter("idUf",idUf);
		return this.convertUfInUfDTO((Uf) query.getSingleResult());
	}

}
