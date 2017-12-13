package com.example.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.example.util.IOUtil;


 class WriteData implements Runnable {
	String iFile;
	String oFile;
	
	
	public WriteData(String iFile, String oFile) {
		this.iFile = iFile;
		this.oFile = oFile;
	}


	@Override
	public void run() {
		try {
			FileInputStream istream = new FileInputStream(iFile);
			FileOutputStream ostream =  new FileOutputStream(oFile);
			System.out.println("Copying File :"+iFile);
			IOUtil.copyData(istream, ostream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class Application {
	
	
	public static void main(String[] args) throws IOException {
		
		String iFile = "a.txt";
		String oFile = "b.txt";
		String iFilex = "x.txt";
		String oFiley = "y.txt";
		
	/*	Thread t1 = new Thread(new WriteData(iFile, oFile));
		t1.start();
		Thread t2 = new Thread(new WriteData(iFilex, oFiley));
		t2.start();*/
		
		// Use executor to define thread count
		
		ExecutorService executor = Executors.newFixedThreadPool(3);  // Thread Pool Size
		executor.execute(new WriteData(iFile, oFile));
		executor.execute(new WriteData(iFilex, oFiley));
		System.out.println("DONE");
		
		
	}

}
