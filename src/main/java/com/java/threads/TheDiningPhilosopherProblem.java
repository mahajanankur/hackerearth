/**
 * 
 */
package com.java.threads;

/**
 * @author ankur.mahajan
 * @written 19-Sep-2018
 */
public class TheDiningPhilosopherProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numberOfPhilosophers = 5;
		Philosopher[] philosophers = new Philosopher[numberOfPhilosophers];
		Object[] forks = new Object[numberOfPhilosophers];
		for (int i = 0; i < forks.length; i++) {
			forks[i] = new Object();
		}

		for (int i = 0; i < philosophers.length; i++) {
			Object leftFork = forks[i];
			Object rightFork = forks[(i + 1) % forks.length];
			// if (i + 1 == philosophers.length)
			// philosophers[i] = new Philosopher(rightFork, leftFork);
			// else
			// If we do this for all a deadlock can occur so pass right fork
			// to last philosopher.
			philosophers[i] = new Philosopher(leftFork, rightFork);

			Thread thread = new Thread(philosophers[i], "Philosopher " + (i + 1));
			thread.start();
		}
	}

}

/**
 * @author ankur.mahajan
 * @written 20-Sep-2018
 */
enum Forks {
	LEFT, RIGHT;
}

/**
 * @author ankur.mahajan
 * @written 20-Sep-2018
 */
class Philosopher implements Runnable {

	private Object leftFork;

	private Object rightFork;

	public Philosopher(Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
	}

	private void think() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " : Thinking.");
		Thread.sleep((long) (Math.random() * 100));
	}

	private void eat() throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " : Eating.");
		Thread.sleep((long) (Math.random() * 100));
	}

	private void pickForks(Forks forks) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " : Picked " + forks + " Fork.");
		Thread.sleep((long) (Math.random() * 100));
	}

	private void putDownForks(Forks forks) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " : Putting down " + forks + " Fork. Now again thinking.");
		Thread.sleep((long) (Math.random() * 100));
	}

	@Override
	public void run() {
		try {
			long testCase = 42;
			while (testCase > 0) {
				think();
				synchronized (leftFork) {
					// pick_left_fork
					pickForks(Forks.LEFT);
					synchronized (rightFork) {
						// pick_right_fork
						pickForks(Forks.RIGHT);
						eat();
						putDownForks(Forks.RIGHT);
					}
					putDownForks(Forks.LEFT);
				}
				testCase--;
			}
		}
		catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			e.printStackTrace();
		}

	}

}
