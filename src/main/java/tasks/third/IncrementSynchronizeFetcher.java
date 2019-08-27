package tasks.third;

public class IncrementSynchronizeFetcher extends Thread {

    private IncrementSynchronize synchronize;
    private SynchronizationMethod method;

    public IncrementSynchronizeFetcher(IncrementSynchronize synchronize, SynchronizationMethod method) {
        this.synchronize = synchronize;
        this.method = method;
    }

    @Override
    public void run() {
        switch (method) {
            case UNSYNC: synchronize.getIncrementUnSynchronized();
            break;
            case KEYWORD: synchronize.getIncrementWithSynchronizedKeyword();
            break;
            case BLOCK: synchronize.getIncrementWithSynchronizedBlock();
            break;
            case LOCK: synchronize.getIncrementWithSynchronizedBlockByLock();
            break;
        }
    }

    public enum SynchronizationMethod {
        UNSYNC,
        KEYWORD,
        BLOCK,
        LOCK
    }

}
