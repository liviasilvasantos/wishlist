package com.luizalabs.magalu.backend.teste.wishlistservice.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizalabs.magalu.backend.teste.wishlistservice.core.exception.WishlistNotFoundException;
import com.luizalabs.magalu.backend.teste.wishlistservice.output.entity.ItemWishlist;
import com.luizalabs.magalu.backend.teste.wishlistservice.output.entity.Wishlist;
import com.luizalabs.magalu.backend.teste.wishlistservice.output.repository.WishlistRepository;

@Service
public class WishlistService {

	@Autowired
	private WishlistRepository wishlistRepository;

	public Wishlist criarWishlist(Wishlist wishlist) {
		return wishlistRepository.save(wishlist);
	}

	public Wishlist buscarWishlist(Long idCliente) {
		Wishlist wishlist = wishlistRepository.getByIdCliente(idCliente);
		if (wishlist == null) {
			throw new WishlistNotFoundException();
		}
		return wishlist;
	}

	public Wishlist buscarProdutoWishlist(Long idCliente, Long idProduto) {
		Wishlist wishlist = wishlistRepository.getProdutoWishlist(idCliente, idProduto);
		if (wishlist == null) {
			throw new WishlistNotFoundException();
		}
		return wishlist;
	}

	public List<Wishlist> buscarWishlists() {
		return wishlistRepository.findAll();
	}

	public Wishlist addItemWishlist(Long idCliente, ItemWishlist item) {
		Wishlist wishlist = buscarWishlist(idCliente);

		wishlist.addItem(item);
		wishlistRepository.save(wishlist);

		return wishlist;
	}

	public void removeItemWishlist(Long idCliente, Long idProduto) {
		Wishlist wishlist = buscarProdutoWishlist(idCliente, idProduto);
		wishlist.removeItem(idProduto);
		wishlistRepository.save(wishlist);
	}
}
