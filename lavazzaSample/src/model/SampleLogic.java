package model;

public class SampleLogic {
	/*
	 * システム始動と終了のメソッド
	 */
	public boolean doIt(boolean isRunning) {
		boolean done = false;
		if (isRunning == true) {
			// isRunningがtrueならポーリングをマルチスレッドで開始
			System.out.println("ポーリングしているつもり");
			done = true;
		} else {
			// isRunningがfalseならポーリングを終了
			System.out.println("ポーリング終わらせたつもり");
			done = true;
		}
		return done;
	}
}
