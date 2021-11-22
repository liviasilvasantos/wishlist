package com.luizalabs.magalu.backend.teste.wishlistservice.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

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
		
		Wishlist w1 = new Wishlist();
		w1.setCriacao(new Date());
		w1.setDescricao("wishlist list black friday");
		w1.setId(1l);
		w1.setIdCliente(2l);

		Wishlist w2 = new Wishlist();
		w2.setCriacao(new Date());
		w2.setDescricao("wishlist natal");
		w2.setId(2l);
		w2.setIdCliente(3l);

		wishlistRepository.saveAll(Arrays.asList(w1, w2));
		System.out.println("wishlists criadas");
	}

}
