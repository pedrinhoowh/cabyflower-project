package com.cabyflower.serviceImpl;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.cabiflower.dto.EnderecoDTO;
import com.cabyflower.entity.Endereco;
import com.cabyflower.service.EnderecoService;
import com.cabyflower.service.MunicipioService;

@Stateless
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
		endereco.setSeqEndereco(enderecoDTO.getIdEndereco() != null ? enderecoDTO.getIdEndereco() : null);
		endereco.setDesComplemento(enderecoDTO.getComplemento() != null ? enderecoDTO.getComplemento() : null);
		endereco.setDesBairro(enderecoDTO.getBairro());
		endereco.setMunicipio(municipioService.convertMunicipioDTOInMunicipio(enderecoDTO.getMunicipio()));
		endereco.setNumEndereco(enderecoDTO.getNumero());
		endereco.setDesRua(enderecoDTO.getRua());
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
		enderecoDTO.setIdEndereco(endereco.getSeqEndereco() != null ? endereco.getSeqEndereco() : null);
		enderecoDTO.setComplemento(endereco.getDesComplemento() != null ? endereco.getDesComplemento() : null);
		enderecoDTO.setBairro(endereco.getDesBairro());
		enderecoDTO.setMunicipio(municipioService.convertMunicipioInMunicipioDTO(endereco.getMunicipio()));
		enderecoDTO.setNumero(endereco.getNumEndereco());
		enderecoDTO.setRua(endereco.getDesRua());
		return enderecoDTO;
	}

}
