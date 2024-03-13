package com.practice.creation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class VaultGame {
	static int MAX_SEQUENCE = 9999;
	
	private static class Vault {
		private int password;
		public Vault(int password) {
			this.password = password;
			System.out.println("Password = "+password);
		}
		
		public boolean isCorrectPassword(int guess) {
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return this.password == guess;
		}
	}
	
	private static abstract class HackerTeam extends Thread {
		protected Vault vault;
		public HackerTeam(Vault vault) {
			this.vault = vault;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(MAX_PRIORITY);
		}
		
		@Override
		public synchronized void start() {
			System.out.println("Starting thread: "+ this.getName());
			super.start();
		}
	}
	
	private static class AscendingHackerTeam extends HackerTeam {

		public AscendingHackerTeam(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			for(int i=1;i<MAX_SEQUENCE;i++) {
				if(vault.isCorrectPassword(i)) {
					System.out.println(this.getName()+ " unlocked Vault");
					System.exit(0);
				}
			}
		}	
	}
	
	private static class DescendingHackerTeam extends HackerTeam {

		public DescendingHackerTeam(Vault vault) {
			super(vault);
		}
		
		@Override
		public void run() {
			for(int i=MAX_SEQUENCE; i>0;i--) {
				if(vault.isCorrectPassword(i)) {
					System.out.println(this.getName()+ " unlocked Vault");
					System.exit(0);
				}
			}
		}
	}
	
	private static class PoliceTeam extends Thread {
		
		@Override
		public void run() {
			super.run();
			for(int i=1; i<=10;i++) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
				}
				System.out.println(i);
			}
			System.out.println("GAME OVER!! Police caught everyone");
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Random random = new Random();
		Vault vault = new Vault(random.nextInt(MAX_SEQUENCE));
		List<Thread> threads = new ArrayList<>();
		threads.add(new AscendingHackerTeam(vault));
		threads.add(new DescendingHackerTeam(vault));
		threads.add(new PoliceTeam());
		
		for(Thread t: threads) {
			t.start();
		}
	}

}


