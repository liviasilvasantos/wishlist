package com.luizalabs.magalu.backend.teste.wishlistservice.input;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizalabs.magalu.backend.teste.wishlistservice.core.service.WishlistService;
import com.luizalabs.magalu.backend.teste.wishlistservice.input.model.dto.ItemWishlistRequest;
import com.luizalabs.magalu.backend.teste.wishlistservice.input.model.dto.WishlistDTO;

@RestController
@RequestMapping("/cliente/{idCliente}/wishlist")
public class WishlistController {

	@Autowired
	private WishlistService wishlistService;

	@GetMapping
	public ResponseEntity<WishlistDTO> consultarWishlist(@PathVariable Long idCliente) {
		return ResponseEntity.ok(WishlistDTO.from(wishlistService.buscarWishlist(idCliente)));
	}

	@GetMapping("/produto/{idProduto}")
	public ResponseEntity<WishlistDTO> consultarProdutoWishlist(@PathVariable Long idCliente,
			@PathVariable Long idProduto) {
		return ResponseEntity.ok(WishlistDTO.from(wishlistService.buscarProdutoWishlist(idCliente, idProduto)));
	}

	@PostMapping("/produto")
	public WishlistDTO adicionarItemWishlist(@PathVariable Long idCliente, @RequestBody ItemWishlistRequest item) {
		return WishlistDTO.from(wishlistService.addItemWishlist(idCliente, item.to()));
	}

	@DeleteMapping("/produto/{idProduto}")
	public ResponseEntity removerItemWishlist(@PathVariable Long idCliente, @PathVariable Long idProduto) {
		wishlistService.removeItemWishlist(idCliente, idProduto);
		return ResponseEntity.noContent().build();
	}

}
