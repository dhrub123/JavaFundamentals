package com.dhruba.inputoutput;

import java.io.IOException;

public class CustomAutoCloseable implements AutoCloseable{
	
	public void printMessage() throws IOException{
		throw new IOException("Exception from printMessage()");
	}
	
	@Override
	public void close() throws IOException {
		throw new IOException("Exception from close()");
		
	}

}
