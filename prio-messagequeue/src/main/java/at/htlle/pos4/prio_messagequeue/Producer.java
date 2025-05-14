package at.htlle.pos4.prio_messagequeue;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class Producer extends Thread {
    private final PriorityMessageQueue queue;
    private final Random rand = new Random();

    public Producer(String name, PriorityMessageQueue queue) {
        super(name);
        this.queue = queue;
    }

    @Override
    public void run() {
        int counter = 1;
        try {
            while (true) {
                boolean isPriority = rand.nextBoolean();
                String content = "Message " + counter++;
                Message msg = new Message(isPriority, content);
                queue.sendMessage(msg);
                Thread.sleep(ThreadLocalRandom.current().nextInt(500, 1500)); // Random sleep
            }
        } catch (InterruptedException e) {
            System.out.println(getName() + " interrupted.");
        }
    }
}
