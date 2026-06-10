package com.erp.service.user.response;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseUtil {
	

	// SINGLE OBJECT RESPONSE
	public static <T> ResponseEntity<ApiResponse<T>> success(String message, T data) {

		ApiResponse<T> response = new ApiResponse<>(true, message, HttpStatus.OK.value(), data, null, null, null, null,
				LocalDateTime.now());

		return ResponseEntity.ok(response);
	}
	// NOT FOUND DATA RESPONSE
	public static <T> ResponseEntity<ApiResponse<T>> notFound(String message) {

		ApiResponse<T> response = ApiResponse.<T>builder().success(false).message(message)
				.statusCode(HttpStatus.NOT_FOUND.value()).data(null).timestamp(LocalDateTime.now()).build();

		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}

	// LIST RESPONSE
	public static <T> ResponseEntity<ApiResponse<List<T>>> successList(String message, List<T> data) {

		ApiResponse<List<T>> response = new ApiResponse<>(true, message, HttpStatus.OK.value(), data, null, null, null,
				null, LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	// PAGINATION RESPONSE
	public static <T> ResponseEntity<ApiResponse<List<T>>> paginated(String message, Page<T> pageData) {

		ApiResponse<List<T>> response = new ApiResponse<>(true, message, HttpStatus.OK.value(), pageData.getContent(),
				pageData.getNumber(), pageData.getTotalPages(), pageData.getTotalElements(), pageData.getSize(),
				LocalDateTime.now());

		return ResponseEntity.ok(response);
	}

	// ERROR RESPONSE
	public static <T> ResponseEntity<ApiResponse<T>> error(String message, HttpStatus status) {

		ApiResponse<T> response = new ApiResponse<>(false, message, status.value(), null, null, null, null, null,
				LocalDateTime.now());

		return new ResponseEntity<>(response, status);
	}
}