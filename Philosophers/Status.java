package java_synergy.Philosophers;

import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Status {
    private final HashMap<Integer, Boolean> fork = new HashMap<>();
    ReentrantLock locker;
    Condition condition;

    Status() {
        locker = new ReentrantLock();
        condition = locker.newCondition();
    }

    void putAllFork() {
        fork.put(1, true);
        fork.put(2, true);
        fork.put(3, true);
        fork.put(4, true);
        fork.put(5, true);

        fork.forEach((k, v) -> {
            System.out.format("вилка #%s на столе - %s%n", k, v);
        });
    }

    void getFork(int left,int right){
        locker.lock();
        try {
            while (true) {
                locker.lock();
                if (fork.get(left) && fork.get(right)) {
                    fork.put(left, false);
                    fork.put(right, false);
                    System.out.println(Thread.currentThread().getName()+": Филосов взял " + left + " и " + right + " вилки и ест... (Вилки на столе: "+fork+")");
                    locker.unlock();
                    //Thread.currentThread().getName()
                    Thread.sleep(1000);
                    locker.lock();
                    fork.put(left, true);
                    fork.put(right, true);
                    System.out.println(Thread.currentThread().getName()+": Филосов поел. Теперь думает...    (Вилки на столе: "+fork+")");
                    condition.signalAll();
                    locker.unlock();
                }else {
                    locker.unlock();
                }
                condition.await();
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            locker.unlock();
        }
    }
}

