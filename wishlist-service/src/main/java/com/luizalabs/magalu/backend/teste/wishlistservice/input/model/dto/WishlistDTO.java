package com.luizalabs.magalu.backend.teste.wishlistservice.input.model.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.luizalabs.magalu.backend.teste.wishlistservice.output.entity.Wishlist;

public class WishlistDTO {

	private String descricao;

	private String cliente;

	private List<String> produtos;

	private WishlistDTO(String descricao, String cliente, List<String> produtos) {
		this.descricao = descricao;
		this.cliente = cliente;
		this.produtos = produtos;
	}

	public static WishlistDTO from(Wishlist wishlist) {
		List<String> produtos = new ArrayList<String>();
		if (wishlist.getItems() != null) {
			produtos = wishlist.getItems().stream().map(i -> String.valueOf(i.getIdProduto()))
					.collect(Collectors.toList());
		}
		return new WishlistDTO(wishlist.getDescricao(), String.valueOf(wishlist.getIdCliente()), produtos);
	}

	public String getCliente() {
		return cliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public List<String> getProdutos() {
		return produtos;
	}
}
