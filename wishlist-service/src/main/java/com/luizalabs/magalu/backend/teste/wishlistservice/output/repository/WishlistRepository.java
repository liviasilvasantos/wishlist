package com.luizalabs.magalu.backend.teste.wishlistservice.output.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.luizalabs.magalu.backend.teste.wishlistservice.output.entity.Wishlist;

public interface WishlistRepository extends MongoRepository<Wishlist, String> {

	Wishlist getByIdCliente(Long idCliente);
	
	@Query(value ="{'idCliente': ?0,'items.idProduto': ?1}") 
	Wishlist getProdutoWishlist(Long idCliente, Long idProduto);
}
