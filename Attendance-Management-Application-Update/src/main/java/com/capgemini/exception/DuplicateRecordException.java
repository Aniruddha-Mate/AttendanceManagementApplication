package com.capgemini.exception;


public class DuplicateRecordException  extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DuplicateRecordException(String msg) {
		super(msg);
	}
}
