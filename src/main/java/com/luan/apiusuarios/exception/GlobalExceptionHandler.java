package com.luan.apiusuarios.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	//Erros de validação(@Valid)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ApiError> handleValidation(MethodArgumentNotValidException ex) {
		List<String> errors = ex.getBindingResult()
				.getFieldErrors()
				.stream()
				.map(err -> err.getField() + ": " + err.getDefaultMessage())
				.toList();
		
		ApiError apiError = new ApiError(
				HttpStatus.BAD_REQUEST.value(),
				"Erro validação",
				errors
				);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	//Regras de negócio
	@ExceptionHandler(BusinessException.class)
	public ResponseEntity<ApiError> handleBusiness(BusinessException ex) {
		ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST.value(),
				ex.getMessage(),
				List.of()
				);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiError);
	}
	
	//Recurso não encontrado
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiError> handleNotFound(ResourceNotFoundException ex) {
		
		ApiError apiError = new ApiError(
				HttpStatus.NOT_FOUND.value(),
				ex.getMessage(),
				List.of()
				);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
	}
	
	//Erro genérico
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> handleGeneric(Exception ex) {
		
		ApiError apiError = new ApiError(
				HttpStatus.INTERNAL_SERVER_ERROR.value(),
				"Erro interno no servidor!",
				List.of()
				);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
	}
}
