package tasks.third;

public class IncrementSynchronize {

    private int value = 0;

    // For testing purposes same synchronized methods with timing added below
    public int getCountUnSynchronized() {
        return value++;
    }

    public synchronized int getCountWithSynchronizedKeyword() {
        return value++;
    }

    public int getCountWithSynchronizedBlock() {
        synchronized (this) {
            return value++;
        }
    }

    private Object lock = new Object();
    public int getCountWithSynchronizedBlockByLock() {
        synchronized (lock) {
            return value++;
        }
    }

    // Test methods
    int pauseMilliseconds = 300;

    public void getIncrementUnSynchronized() {
        incrementWithPause(pauseMilliseconds);
    }

    public synchronized void getIncrementWithSynchronizedKeyword() {
        incrementWithPause(pauseMilliseconds);
    }

    public void getIncrementWithSynchronizedBlock() {
        synchronized (this) {
            incrementWithPause(pauseMilliseconds);
        }
    }

    public void getIncrementWithSynchronizedBlockByLock() {
        synchronized (lock) {
            incrementWithPause(pauseMilliseconds);
        }
    }

    private void incrementWithPause(int pause) {
        for (int i = 0; i < 3; i++) {
            System.out.print(value++);
            try {
                Thread.sleep(pause);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }


}
