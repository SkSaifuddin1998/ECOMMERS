package com.erp.service.user.response;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success;
	private String message;
	private int statusCode;
	private T data;

	private Integer currentPage;
	private Integer totalPages;
	private Long totalElements;
	private Integer pageSize;

	private LocalDateTime timestamp;

}