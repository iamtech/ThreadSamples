package com.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class IOUtil {
	
	public static void copyData(InputStream istream, OutputStream ostream) throws IOException{
		
		int value;
		while((value = istream.read()) > -1){
			ostream.write(value);
		}
	}

}
