package tut1.api.threads.running;

import java.util.concurrent.TimeUnit;

/*
 * This way of creating Threads and task is useful where we want to fire and forget type of threads
 * 
 * */
public class FourthWay {
	
	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
		
		//Create the Instance of Thread Class
		// and pass the reference of a task object
		// to work upon .
		
		Thread t1 = new Thread(new FourthTask());
		Thread t2 = new Thread(new FourthTask());
		
		t1.start();
		t2.start();
		
		System.out.println("Main thread ends here...");
	}
}

/*
 * 1 Task Definition is done by implementing Runnable interface
 * ThirdTask becomes a task instead of Thread
 * 
 * This way enable us to handle or manipulate thread 
 * behavior in a better way.
 * Task Definition is entirely isolated to thread related code.
 * 
 * Also Task can be used by executors as against only by threads, hence
 * making the task reusable
 * 
 * */
class FourthTask implements Runnable {
	
	private static int count = 0;
	private int id;
	
	@Override
	public void run() {
		for (int i=10; i>0; i--) {
			System.out.println("<" + id + ">TICK TICK " + i);
			
			try {
				TimeUnit.MILLISECONDS.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/*2 creating a thread object in constructor of Task and passing it 
	 * a reference of itself*/
	public FourthTask() {
		this.id = ++count;
		
	}
}