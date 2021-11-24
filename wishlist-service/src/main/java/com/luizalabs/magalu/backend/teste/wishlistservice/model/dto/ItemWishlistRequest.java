package com.luizalabs.magalu.backend.teste.wishlistservice.model.dto;

import com.luizalabs.magalu.backend.teste.wishlistservice.model.ItemWishlist;

public class ItemWishlistRequest {

	private Long produto;
	
	private ItemWishlistRequest() {
	}

	private ItemWishlistRequest(Long produto) {
		this.produto = produto;
	}

	public Long getProduto() {
		return produto;
	}

	public ItemWishlist to() {
		return new ItemWishlist(this.getProduto());
	}
}
