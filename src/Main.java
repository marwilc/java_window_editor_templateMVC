import java.awt.EventQueue;

import controller.Coordinator;

/*
 * class Main
 * marwilc
 */

public class Main {

	Coordinator myCoordinator;	// coordinator instance
	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Main myPrincipal= new Main();
					myPrincipal.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void init() {
		// TODO Auto-generated method stub
		myCoordinator = new Coordinator();
	}

}
