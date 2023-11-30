package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPool {

	private final ExecutorService executorService;

	public ThreadPool() {
		this.executorService = Executors.newFixedThreadPool(5);

	}

	public <V> Future<V> use(Callable<V> task) {
		return executorService.submit(task);
	}
}
