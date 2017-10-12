package com.cabyflower.serviceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import com.cabiflower.dto.EnderecoDTO;
import com.cabyflower.entity.Endereco;
import com.cabyflower.service.EnderecoService;
import com.cabyflower.service.MunicipioService;

@Stateless
@Transactional(value = TxType.NOT_SUPPORTED)
@TransactionManagement
public class EnderecoServiceImpl implements EnderecoService {

	@EJB
	private MunicipioService municipioService;

	/**
	 * convert enderecoDTO in endereco
	 * 
	 * @param enderecoDTO
	 * @return endereco
	 */
	@Override
	public Endereco convertEnderecoDTOInEndereco(EnderecoDTO enderecoDTO) {
		Endereco endereco = new Endereco();
		endereco.setIdEndereco(enderecoDTO.getIdEndereco() != null ? enderecoDTO.getIdEndereco() : null);
		endereco.setComplemento(enderecoDTO.getComplemento() != null ? enderecoDTO.getComplemento() : null);
		endereco.setBairro(enderecoDTO.getBairro());
		endereco.setMunicipio(municipioService.convertMunicipioDTOInMunicipio(enderecoDTO.getMunicipio()));
		endereco.setNumero(enderecoDTO.getNumero());
		endereco.setRua(enderecoDTO.getRua());
		return endereco;
	}

	/**
	 * convert endereco in enderecoDTO
	 * 
	 * @param endereco
	 * @return enderecoDTO
	 */
	@Override
	public EnderecoDTO convertEnderecoInEnderecoDTO(Endereco endereco) {
		EnderecoDTO enderecoDTO = new EnderecoDTO();
		enderecoDTO.setIdEndereco(endereco.getIdEndereco() != null ? endereco.getIdEndereco() : null);
		enderecoDTO.setComplemento(endereco.getComplemento() != null ? endereco.getComplemento() : null);
		enderecoDTO.setBairro(endereco.getBairro());
		enderecoDTO.setMunicipio(municipioService.convertMunicipioInMunicipioDTO(endereco.getMunicipio()));
		enderecoDTO.setNumero(endereco.getNumero());
		enderecoDTO.setRua(endereco.getRua());
		return enderecoDTO;
	}

}
