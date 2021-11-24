package com.luizalabs.magalu.backend.teste.wishlistservice.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.luizalabs.magalu.backend.teste.wishlistservice.domain.service.WishlistService;
import com.luizalabs.magalu.backend.teste.wishlistservice.input.WishlistController;
import com.luizalabs.magalu.backend.teste.wishlistservice.input.model.dto.WishlistDTO;
import com.luizalabs.magalu.backend.teste.wishlistservice.output.entity.Wishlist;

@ExtendWith(MockitoExtension.class)
public class WishlistControllerTest {

	@InjectMocks
	private WishlistController wishlistController;

	@Mock
	private WishlistService wishlistService;

	@Test
	void shouldReturnWishlistAndStatusOKWhenSearched() {

		Wishlist w1 = new Wishlist("lista 1", 1L);
		when(wishlistService.buscarWishlist(1L)).thenReturn(w1);

		ResponseEntity<WishlistDTO> r = wishlistController.consultarWishlist(1L);
		assertThat(r.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(r.getBody().getDescricao()).isEqualTo("lista 1");
	}

}
