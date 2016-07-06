package tut1.api.threads.running;

import java.util.concurrent.TimeUnit;

/*
 * Creating an Inline Task in thread using Anonymous Inner Classes
 * This Technique is mainly used in handling events in GUI.
 * */
public class FifthWay {

	public static void main(String[] args) {
		System.out.println("Main thread starts here");
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {

				for (int i=10; i>0; i--) {
					System.out.println("TICK TICK " + i);
					
					try {
						TimeUnit.MILLISECONDS.sleep(200);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			
				
			}
		}).start();
		
		System.out.println("Main thread ends here");
	}

}
