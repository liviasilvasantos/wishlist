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
	public ResponseEntity<ErrorDTO> handleNotFound(WishlistNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;

		ErrorDTO erro = new ErrorDTO(System.currentTimeMillis(), status.value(), "Wishlist não encontrada",
				e.getMessage(), request.getRequestURI());

		return ResponseEntity.status(status).body(erro);
	}
}
