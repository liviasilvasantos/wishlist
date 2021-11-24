package com.luizalabs.magalu.backend.teste.wishlistservice.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.luizalabs.magalu.backend.teste.wishlistservice.model.dto.ErrorDTO;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(WishlistNotFoundException.class)
	public ResponseEntity<ErrorDTO> handleExceptionOf(WishlistNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		ErrorDTO erro = new ErrorDTO(System.currentTimeMillis(), status.value(), "Wishlist não encontrada",
				e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(erro);
	}

	@ExceptionHandler(ItemDuplicatedException.class)
	public ResponseEntity<ErrorDTO> handleExceptionOf(ItemDuplicatedException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		ErrorDTO erro = new ErrorDTO(System.currentTimeMillis(), status.value(),
				"Produto " + e.getProduto() + " já existe na Wishlist", e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(erro);
	}

	@ExceptionHandler(LimiteMaximoWishlistException.class)
	public ResponseEntity<ErrorDTO> handleExceptionOf(LimiteMaximoWishlistException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

		ErrorDTO erro = new ErrorDTO(System.currentTimeMillis(), status.value(),
				"Limite máximo de produtos atingido na Wishlist", e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(erro);
	}
}
