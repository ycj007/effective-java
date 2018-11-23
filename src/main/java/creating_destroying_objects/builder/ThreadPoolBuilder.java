package creating_destroying_objects.builder;

import java.util.concurrent.*;

public class ThreadPoolBuilder implements Builer<ThreadPoolExecutor> {


    private int corePoolSize = 1;
    private int maximumPoolSize = 1;
    private long keepAliveTime = 1;
    private TimeUnit unit = TimeUnit.MINUTES;
    private BlockingQueue<Runnable> workQueue = new LinkedBlockingDeque<>();
    private ThreadFactory threadFactory = new DefaulThreaFactory();
    private RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();

    private class DefaulThreaFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            return new Thread(r);
        }
    }

    public void setCorePoolSize(int corePoolSize) {
        if (corePoolSize < 0) {
            throw new IllegalArgumentException();
        }
        this.corePoolSize = corePoolSize;
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        if (maximumPoolSize < 1) {
            throw new IllegalArgumentException();
        }
        this.maximumPoolSize = maximumPoolSize;
    }

    public void setKeepAliveTime(long keepAliveTime) {
        if (keepAliveTime < 0) {
            throw new IllegalArgumentException();
        }
        this.keepAliveTime = keepAliveTime;
    }

    public void setUnit(TimeUnit unit) {
        this.unit = unit;
    }

    public void setWorkQueue(BlockingQueue<Runnable> workQueue) {
        if (workQueue == null) {
            throw new NullPointerException();
        }
        this.workQueue = workQueue;
    }

    public void setThreadFactory(ThreadFactory threadFactory) {
        if (threadFactory == null) {
            throw new NullPointerException();
        }
        this.threadFactory = threadFactory;
    }

    public void setHandler(RejectedExecutionHandler handler) {
        if (handler == null) {
            throw new NullPointerException();
        }
        this.handler = handler;
    }

    @Override
    public ThreadPoolExecutor build() {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue, threadFactory, handler);
    }

    public static void main(String[] args) {
        ThreadPoolBuilder threadPoolBuilder = new ThreadPoolBuilder();
        threadPoolBuilder.build();
    }
}
