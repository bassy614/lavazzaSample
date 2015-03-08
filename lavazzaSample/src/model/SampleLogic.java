package model;

/*
 * システム始動と終了を管轄するクラス
 */
public class SampleLogic {
	private boolean done;
	private SampleThread thread;
	
	public SampleLogic(){
		done = false;
		thread = new SampleThread();
	}
	
	public boolean doIt(boolean isRunning) {
		
		if (isRunning == true) {
			// isRunningがtrueならポーリングをマルチスレッドで開始
			System.out.println("ポーリングしているつもり");
			thread.setIsRunning(true);
			thread.start();
			done = true;
		} else {
			// isRunningがfalseならポーリングを終了
			thread.setIsRunning(false);
			done = true;
			System.out.println("ポーリング終わらせたつもり");
		}
		return done;
	}
}
