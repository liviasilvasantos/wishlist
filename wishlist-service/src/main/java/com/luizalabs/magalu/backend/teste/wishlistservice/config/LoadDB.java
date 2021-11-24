package com.luizalabs.magalu.backend.teste.wishlistservice.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.luizalabs.magalu.backend.teste.wishlistservice.model.ItemWishlist;
import com.luizalabs.magalu.backend.teste.wishlistservice.model.Wishlist;
import com.luizalabs.magalu.backend.teste.wishlistservice.repository.WishlistRepository;

@Configuration
public class LoadDB implements CommandLineRunner {

	@Autowired
	private WishlistRepository wishlistRepository;

	@Override
	public void run(String... args) throws Exception {
		wishlistRepository.deleteAll();
		System.out.println("wishlists apagadas");

		Wishlist w1 = new Wishlist("wishlist list black friday", 1L);
		w1.addItem(new ItemWishlist(1L));

		Wishlist w2 = new Wishlist("wishlist natal", 2L);
		w2.addItem(new ItemWishlist(1L));
		w2.addItem(new ItemWishlist(2L));

		wishlistRepository.saveAll(Arrays.asList(w1, w2));

		System.out.println("wishlists criadas");
	}

}
