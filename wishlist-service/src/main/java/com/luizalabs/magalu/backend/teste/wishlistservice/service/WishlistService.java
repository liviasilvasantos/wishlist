package com.luizalabs.magalu.backend.teste.wishlistservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizalabs.magalu.backend.teste.wishlistservice.error.WishlistNotFoundException;
import com.luizalabs.magalu.backend.teste.wishlistservice.model.Wishlist;
import com.luizalabs.magalu.backend.teste.wishlistservice.repository.WishlistRepository;

@Service
public class WishlistService {

	@Autowired
	private WishlistRepository wishlistRepository;

	public Wishlist criarWishlist(Wishlist wishlist) {
		return wishlistRepository.save(wishlist);
	}

	public Wishlist buscarWishlist(Long idCliente) throws WishlistNotFoundException {
		Wishlist wishlist = wishlistRepository.getByIdCliente(idCliente);
		if (wishlist == null) {
			throw new WishlistNotFoundException();
		}
		return wishlist;
	}

	public List<Wishlist> buscarWishlists() {
		return wishlistRepository.findAll();
	}
}
