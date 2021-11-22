package com.luizalabs.magalu.backend.teste.wishlistservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizalabs.magalu.backend.teste.wishlistservice.model.Wishlist;
import com.luizalabs.magalu.backend.teste.wishlistservice.service.WishlistService;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	@GetMapping
	public List<Wishlist> consultarWishlist() {
		return wishlistService.buscarWishlists();
	}

	@PostMapping
	public Wishlist criarWishlist(@RequestBody Wishlist wishlist) {
		return wishlistService.criarWishlist(wishlist);
	}

	@PostMapping("/items")
	public void adicionarItemWishlist() {
	}

	@DeleteMapping("/items/{itemId}")
	public void removerItemWishlist(@PathVariable Integer itemId) {

	}

}
