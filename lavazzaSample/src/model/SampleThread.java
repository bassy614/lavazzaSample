package model;

public class SampleThread extends Thread {
	private boolean isRunning;
	@Override
	public void run(){
		while(isRunning){
			// isRunningがtrueの間1秒間隔でポーリング
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				System.err.println("sleepのInterruptedException");
			}
			// TODO 家APIを実行する処理
			System.out.println("家APIで来客センサーのON/OFF状態を取得");
			// TODO 来客センサーがONならtwitterにポストする処理
			// TODO ポスト後システム停止するならisRunningをfalseにセット
		}
	}
	public void setIsRunning(boolean isRunning){
		this.isRunning = isRunning;
	}
}
