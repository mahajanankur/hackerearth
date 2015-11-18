package javaConcepts.threads;

public class TestSleep implements Runnable {

	public static void main(String[] args) {
		TestSleep testSleep = new TestSleep();

		Thread thread1 = new Thread(testSleep);
		Thread thread2 = new Thread(testSleep);
		thread1.start();
		thread2.start();
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(i);
		}

	}

}
