package threads;

public class ThreadExample {
	public static void main(String[] args) throws InterruptedException {
		int x = 1200;
		Result result = new Result();
		Thread t1 = new Thread(() -> {
			result.left = f(x);
		});
		Thread t2 = new Thread(() -> {
			result.right = g(x);
		});

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(result);
	}

	static class Result {
		private int right = 1;
		private int left = 1;

		@Override
		public String toString() {
			return "Result{" +
				"right=" + right +
				", left=" + left +
				'}';
		}
	}

	public static int f(int x) {
		return x + x;
	}

	public static int g(int x) {
		return x * x;
	}
}
