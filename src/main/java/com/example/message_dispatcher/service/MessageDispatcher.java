package com.example.message_dispatcher.service;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class MessageDispatcher {

	private final AtomicInteger counter = new AtomicInteger(0);
	private final int TOTAL_REQUESTS = 1000; // số lượng request JMeter gửi
	private long startTime = System.currentTimeMillis();

	@Async("myTaskExecutor") // dùng thread pool đã cấu hình
	public void processAsync(String input) {
		System.out.println("Start processing: " + input + " | Thread: " + Thread.currentThread().getName());
		int finished = counter.incrementAndGet();
		if (finished == 1) {
			startTime = System.currentTimeMillis();
		}

		try {
			Thread.sleep(1000); // mô phỏng xử lý lâu
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println("Done processing: " + input + " | Thread: " + Thread.currentThread().getName());

		// kiểm tra khi task cuối cùng hoàn thành
		System.out.println("finished: " + finished);
		if (finished == TOTAL_REQUESTS) {
			long endTime = System.currentTimeMillis();
			System.out.println("✅ All async tasks completed in: " + (endTime - startTime) + " ms");
			counter.setPlain(0);
		}
	}

	public void processSync(String input) {
		System.out.println("Start processing: " + input + " | Thread: " + Thread.currentThread().getName());
		int finished = counter.incrementAndGet();
		if (finished == 1) {
			startTime = System.currentTimeMillis();
		}
		try {
			Thread.sleep(1000); // mô phỏng xử lý lâu
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}

		System.out.println("Done processing: " + input + " | Thread: " + Thread.currentThread().getName());
		// kiểm tra khi task cuối cùng hoàn thành
		System.out.println("finished: " + finished);
		if (finished == TOTAL_REQUESTS) {
			long endTime = System.currentTimeMillis();
			System.out.println("✅ All sync tasks completed in: " + (endTime - startTime) + " ms");
			counter.setPlain(0);
		}
	}

}
