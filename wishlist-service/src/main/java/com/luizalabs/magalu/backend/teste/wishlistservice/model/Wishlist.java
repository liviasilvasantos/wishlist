package com.luizalabs.magalu.backend.teste.wishlistservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.luizalabs.magalu.backend.teste.wishlistservice.error.ItemDuplicatedException;
import com.luizalabs.magalu.backend.teste.wishlistservice.error.LimiteMaximoWishlistException;

@Document(collection = "wishlist")
public class Wishlist {

	@Id
	private String id;

	private String descricao;

	private Long idCliente;

	private List<ItemWishlist> items;

	private Date criacao;

	public Wishlist() {
	}

	public Wishlist(String descricao, Long idCliente) {
		this.descricao = descricao;
		this.idCliente = idCliente;
		this.criacao = new Date();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public void addItem(ItemWishlist item) {
		if (items == null) {
			items = new ArrayList<>();
		}

		if (items.size() == 20) {
			throw new LimiteMaximoWishlistException();
		}

		if (items.stream().anyMatch(i -> i.getIdProduto() == item.getIdProduto())) {
			throw new ItemDuplicatedException(item.getIdProduto());
		}

		items.add(item);
	}

	public void removeItem(Long idProduto) {
		if (items != null) {
			items.removeIf(i -> i.getIdProduto() == idProduto);
		}
	}
}
