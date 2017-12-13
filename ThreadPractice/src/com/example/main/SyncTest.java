package com.example.main;

class IncValue{
	 int x;
	 
	 
	public IncValue(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	 
	 public void incVal(){            // public synchronized void incVal(){ 
		 int y = getX();
		 y++;
		 // to pause a thread to that other thread can run
		 try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 setX(y);
		
	 }
}

class MyThread extends Thread{
	IncValue inv;
	
	public MyThread(IncValue inv) {
		this.inv = inv;
	}

	@Override
	public void run() {
		inv.incVal();
	}
}

public class SyncTest {

	public static void main(String[] args) {
		IncValue inv = new IncValue(10);
		MyThread t1 = new MyThread(inv);
		MyThread t2 = new MyThread(inv);
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 System.out.println("value of x is:"+inv.getX()); // should be 12 but will come 11.
	}

}
