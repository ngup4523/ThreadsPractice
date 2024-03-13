package demo2;

import java.util.Scanner;

class Processor extends Thread {
	private volatile boolean running = true;
	
	public void run() {
		while(running) {
			System.out.println("Running " + Thread.currentThread().getName()
					);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void shutdown() {
		running = !running;
	}
}

public class App {
	
	public static void main(String[] args) {
	
	Processor proc1 = new Processor();
	Processor proc2 = new Processor();
	proc1.start();
	proc2.start();
	
	Scanner scanner = new Scanner(System.in);
	scanner.nextLine();
	
	proc1.shutdown();
	}

}
