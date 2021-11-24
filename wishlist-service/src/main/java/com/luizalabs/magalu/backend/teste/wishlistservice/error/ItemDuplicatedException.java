package com.luizalabs.magalu.backend.teste.wishlistservice.error;

@SuppressWarnings("serial")
public class ItemDuplicatedException extends RuntimeException {

	private Long produto;

	public ItemDuplicatedException() {
	}

	public ItemDuplicatedException(Long produto) {
		this.produto = produto;
	}

	public Long getProduto() {
		return produto;
	}
}
