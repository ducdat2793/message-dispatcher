package com.example.message_dispatcher.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@EnableAsync
@Configuration
public class AsyncConfig {

	@Bean(name = "myTaskExecutor")
	public Executor taskExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(100);
		executor.setMaxPoolSize(200);
		executor.setQueueCapacity(300);
		executor.setThreadNamePrefix("message-dispatcher-task");
		executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
		executor.initialize();
		return executor;
	}

	// corePoolSize: Số thread chạy song song luôn luôn có
	// maxPoolSize: Tối đa thread có thể tạo khi queue đầy
	// queueCapacity: Bao nhiêu task có thể xếp hàng khi core pool bận
	// keepAliveSeconds: Thread dư thừa (trên core) sẽ bị kill sau thời gian này
	// rejectedExecutionHandler: Khi queue đầy, xử lý như thế nào?

}
