package com.main.exceptions;

public class ResouceNotFound extends RuntimeException {
	
	public ResouceNotFound()
	{
		super("Book Not Found On Server");
	}

	public ResouceNotFound(String msg)
	{
		super(msg);
	}
	
	
}
