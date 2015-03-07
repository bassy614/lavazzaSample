package model;

import javax.servlet.http.HttpServletRequest;

public class SampleLogic {
	/*
	 * システム始動と終了のメソッド
	 */
	public boolean doIt(HttpServletRequest request) {
		boolean done = false;
		// セッションスコープからisRunningの値を取得
		boolean isRunning = (Boolean) request.getSession().getAttribute("isRunning");
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
