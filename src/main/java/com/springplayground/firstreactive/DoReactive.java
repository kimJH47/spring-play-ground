package com.springplayground.firstreactive;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Flow;
import java.util.concurrent.RecursiveTask;

public class DoReactive {
	private Flow flow;
	private RecursiveTask recursiveTask;
	private CompletableFuture completableFuture;
	private ExecutorService executorService = Executors.newCachedThreadPool();

	private void run() {

	}
}
