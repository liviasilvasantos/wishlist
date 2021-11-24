package com.luizalabs.magalu.backend.teste.wishlistservice.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

import com.luizalabs.magalu.backend.teste.wishlistservice.core.exception.ItemDuplicatedException;
import com.luizalabs.magalu.backend.teste.wishlistservice.core.exception.LimiteMaximoWishlistException;
import com.luizalabs.magalu.backend.teste.wishlistservice.output.entity.ItemWishlist;
import com.luizalabs.magalu.backend.teste.wishlistservice.output.entity.Wishlist;

public class WishlistTest {

	@Test
	void shouldThrowError_whenWishlistIsFull() {

		Wishlist w = new Wishlist();

		for (int i = 0; i < 20; i++) {
			w.addItem(new ItemWishlist(Long.valueOf(i)));
		}

		assertThatThrownBy(() -> w.addItem(new ItemWishlist())).isInstanceOf(LimiteMaximoWishlistException.class);
	}

	@Test
	void shouldThrowError_whenProductDuplicatedOnWishlist() {

		Wishlist w = new Wishlist();
		w.addItem(new ItemWishlist(1L));

		assertThatThrownBy(() -> w.addItem(new ItemWishlist(1L))).isInstanceOf(ItemDuplicatedException.class);
	}

	@Test
	void shouldAddProductOnWishlist() {
		Wishlist w = new Wishlist();
		w.addItem(new ItemWishlist(1L));

		assertThat(w.getItems().size()).isEqualTo(1);
	}

	@Test
	void shouldRemoveProductFromWishlist() {
		Wishlist w = new Wishlist();
		w.addItem(new ItemWishlist(1L));

		w.removeItem(1L);

		assertThat(w.getItems()).isEmpty();
	}
}
