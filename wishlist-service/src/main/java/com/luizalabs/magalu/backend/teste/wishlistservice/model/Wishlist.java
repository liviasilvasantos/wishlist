package com.luizalabs.magalu.backend.teste.wishlistservice.model;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Wishlist {

	@Id
	private Long id;

	private String descricao;

	private Long idCliente;

	@DBRef(lazy = true)
	private List<ItemWishlist> items;

	private Date criacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public List<ItemWishlist> getItems() {
		return items;
	}

	public void setItems(List<ItemWishlist> items) {
		this.items = items;
	}
}
