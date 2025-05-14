package at.htlle.pos4.prio_messagequeue;

import java.util.concurrent.ThreadLocalRandom;

class Consumer extends Thread {
    private final PriorityMessageQueue queue;

    public Consumer(String name, PriorityMessageQueue queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        try {
            while (true) {
                queue.receiveMessage();
                Thread.sleep(ThreadLocalRandom.current().nextInt(800, 2000)); // Random sleep
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
    }
}
