package com.luizalabs.magalu.backend.teste.wishlistservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.luizalabs.magalu.backend.teste.wishlistservice.model.Wishlist;

public interface WishlistRepository extends MongoRepository<Wishlist, String> {

	Wishlist getByIdCliente(Long idCliente);
}
