package com.luizalabs.magalu.backend.teste.wishlistservice.model;

import java.util.Date;

public class ItemWishlist {

	private Long idProduto;

	private Date criacao;

	public ItemWishlist() {
	}

	public ItemWishlist(Long idProduto) {
		this.idProduto = idProduto;
		this.criacao = new Date();
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
