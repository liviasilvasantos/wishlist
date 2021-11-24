package com.luizalabs.magalu.backend.teste.wishlistservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizalabs.magalu.backend.teste.wishlistservice.error.WishlistNotFoundException;
import com.luizalabs.magalu.backend.teste.wishlistservice.model.Wishlist;
import com.luizalabs.magalu.backend.teste.wishlistservice.service.WishlistService;

@RestController
@RequestMapping("/cliente/{idCliente}/wishlist")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	@GetMapping
	public Wishlist consultarWishlist(@PathVariable Long idCliente) throws WishlistNotFoundException {
		return wishlistService.buscarWishlist(idCliente);
	}

	@PostMapping
	public Wishlist criarWishlist(@PathVariable Long idCliente, @RequestBody Wishlist wishlist) {
		return wishlistService.criarWishlist(wishlist);
	}

	@PostMapping("/items")
	public void adicionarItemWishlist() {
	}

	@DeleteMapping("/items/{itemId}")
	public void removerItemWishlist(@PathVariable Integer itemId) {

	}

}
