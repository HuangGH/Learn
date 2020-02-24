import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 线程通信,子线程等待主线程结束
 * @author hgh 2019-07-25 22:34
 */
public class ThreadDemo {

	private final static Logger logger = LoggerFactory.getLogger(ThreadDemo.class);
	int nThread = Runtime.getRuntime().availableProcessors() + 1;
	ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("cusCall-pool-%d").build();
	ExecutorService fixedThreadPool = new ThreadPoolExecutor(10, 10, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024), nameThreadFactory);

	public static void main(String[] args) {
		ThreadDemo threadDemo = new ThreadDemo();
		threadDemo.start();
		threadDemo.start();
		threadDemo.start();
		threadDemo.start();
		threadDemo.start();
		threadDemo.start();
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		threadDemo.start();


	}

	public void start() {
		logger.info("主线程开始");
		Thread t = Thread.currentThread();
		logger.debug("当前线程名称 : {}", t.getName());
		Thread thread = new Thread(() -> subThread(t), t.getName() + "sub");
		thread.start();
//		try {
//			TimeUnit.SECONDS.sleep(1);
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
		logger.info("主线程结束");

	}

	public void subThread(Thread thread) {
		logger.info(thread.getName());
		logger.info("子线程开始");
		do {
		} while (thread.isAlive());
		logger.info("子线程结束");
	}

}
