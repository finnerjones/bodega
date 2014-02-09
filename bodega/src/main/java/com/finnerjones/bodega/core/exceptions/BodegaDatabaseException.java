package com.finnerjones.bodega.core.exceptions;

public class BodegaDatabaseException extends Exception {

	private static final long serialVersionUID = 1L;

	public BodegaDatabaseException() {
		super();
	}

	public BodegaDatabaseException(String message) {
		super(message);
	}

	public BodegaDatabaseException(String message, Throwable t) {
		super(message, t);
	}

	public BodegaDatabaseException(Throwable t) {
		super(t);
	}

}
