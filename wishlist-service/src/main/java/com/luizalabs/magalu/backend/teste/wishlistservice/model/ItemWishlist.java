package com.luizalabs.magalu.backend.teste.wishlistservice.model;

import java.util.Date;

public class ItemWishlist {

	private Long id;

	private Long idProduto;

	private Date criacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(Long idProduto) {
		this.idProduto = idProduto;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

}
