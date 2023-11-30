package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int x = 1200;
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		Future<Integer> f = executorService.submit(() -> f(x));
		Future<Integer> g = executorService.submit(() -> g(x));
		System.out.println("f : " + f.get() + " g: " + g.get());
		executorService.shutdown();
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
