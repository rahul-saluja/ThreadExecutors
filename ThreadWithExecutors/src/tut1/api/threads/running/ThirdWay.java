package tut1.api.threads.running;

import java.util.concurrent.TimeUnit;

/*
 * This way of creating Threads and task is useful where we want to fire and forget type of threads
 * 
 * */
public class ThirdWay {
	
	public static void main(String[] args) {
		System.out.println("Main thread starts here...");
		
		//3 We can no longer Capture a reference of Thread reference as we have
		//started to created Thread Object within the constructor of Task itself
		new ThirdTask();
		new ThirdTask();
		
		System.out.println("Main thread ends here...");
	}
}

/*
 * 1 Task Definition is done by implementing Runnable interface
 * ThirdTask becomes a task instead of Thread
 * */
class ThirdTask implements Runnable {
	
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
	public ThirdTask() {
		this.id = ++count;
		new Thread(this).start();
	}
}