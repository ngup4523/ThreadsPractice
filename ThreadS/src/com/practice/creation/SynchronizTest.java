package com.practice.creation;

public class SynchronizTest {

	public static void main(String[] args) throws InterruptedException {
		Base b1 = new Base();
		Thread t1 = new Thread(() -> {	
			for(int i=0;i<10;i++)
			  b1.update();
		});
		
		Thread t2 = new Thread(() -> {
			for(int i=0;i<10;i++)
			  b1.downgrade();
		});

		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println(b1.a);
	}

}

class Base {
	int a;
	Object b = new Object();
	
	Base() {
		a=4;b=5;
	}
	
	 void update() {
		 System.out.println("Before from "+Thread.currentThread().getName());
		 synchronized (this){
			a++;
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("After from "+Thread.currentThread().getName());
	}
	
	 void downgrade() {
		 System.out.println("Before from "+Thread.currentThread().getName());
		 synchronized (this){
			a--;
			System.out.println(Thread.currentThread().getName());
		}
		System.out.println("After from "+Thread.currentThread().getName());
	}
}