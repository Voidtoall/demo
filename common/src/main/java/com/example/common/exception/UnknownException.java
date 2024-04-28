package com.example.common.exception;


public class UnknownException extends RuntimeException {

	private static final long serialVersionUID = 6101392394607418146L;

	public UnknownException(String message) {
        super(message);
    }

}
