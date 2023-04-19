package thread.generate;

//Runnable 인터페이스 상속 받아서
public class ThreadTest2 implements Runnable { //이미 다른 클래스를 상속 받은 상태에서 스레드를 사용해야 할 때 쓰는 방법
	
	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			System.out.println("thread 실행 " + (i + 1));
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ThreadTest2 t2 = new ThreadTest2();
		Thread t3 = new Thread(t2); //new born
		t3.start(); //runnable
	}
}
