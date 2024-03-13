package demo1;

class Runner extends Thread {
	@Override
	public void run() {
		for( int i=0;i<10;i++) {
			System.out.println("Hello "+ i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class RunnerWithInterface implements Runnable {

	@Override
	public void run() {
		for( int i=0;i<10;i++) {
			System.out.println("Hello "+ i);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
	
}
public class App {
public static void main(String[] args) {
//	Runner runner1 = new Runner();
//	Runner runner2 = new Runner();
	
//	Thread t1= new Thread(new RunnerWithInterface());
//	Thread t2= new Thread(new RunnerWithInterface());
	
//	runner1.start();
//	runner2.start();
	
//	t1.start();
//	t2.start();
	
	Thread t3 = new Thread(new Runnable() {
		
		@Override
		public void run() {
			for( int i=0;i<10;i++) {
				System.out.println("Hello "+ i);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	});
	
	t3.start();
}
}
