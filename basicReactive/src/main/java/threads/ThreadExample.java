package threads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ThreadExample {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		int x = 1200;
		Future<Integer> f = f(x);
		Future<Integer> g = g(x);
		System.out.println(f.get() + g.get());
	}

	public static Future<Integer> f(int x) {
		return new Future<Integer>() {
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return false;
			}

			@Override
			public boolean isCancelled() {
				return false;
			}

			@Override
			public boolean isDone() {
				return false;
			}

			@Override
			public Integer get() throws InterruptedException, ExecutionException {
				return x + x;
			}

			@Override
			public Integer get(long timeout, TimeUnit unit) throws
				InterruptedException,
				ExecutionException,
				TimeoutException {
				return null;
			}
		};
	}

	public static Future<Integer> g(int x) {
		return new Future<Integer>() {
			@Override
			public boolean cancel(boolean mayInterruptIfRunning) {
				return false;
			}

			@Override
			public boolean isCancelled() {
				return false;
			}

			@Override
			public boolean isDone() {
				return false;
			}

			@Override
			public Integer get() throws InterruptedException, ExecutionException {
				return x * x;
			}

			@Override
			public Integer get(long timeout, TimeUnit unit) throws
				InterruptedException,
				ExecutionException,
				TimeoutException {
				return null;
			}
		};
	}
}
