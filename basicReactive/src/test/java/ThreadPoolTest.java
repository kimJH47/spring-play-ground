import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

import org.junit.jupiter.api.Test;

import threads.ThreadPool;

public class ThreadPoolTest {


	@Test
	void test() throws Exception {
		//given
		ThreadPool threadPool = new ThreadPool();

		List<String> result = new ArrayList<>();
		for (int i = 0; i < 100; i++) {
			Future<String> use = threadPool.use(() -> {
				// Thread.sleep(500);
				System.out.println(Thread.currentThread().getName());
				return "done!!";
			});
		}
		//then
		System.out.println("finish");

	}
}
