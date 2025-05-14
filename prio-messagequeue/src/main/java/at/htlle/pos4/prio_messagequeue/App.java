package at.htlle.pos4.prio_messagequeue;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args ) {
        PriorityMessageQueue queue = new PriorityMessageQueue(5);

        new Producer("Producer-1", queue).start();
        new Producer("Producer-2", queue).start();

        new Consumer("Consumer-1", queue).start();
        new Consumer("Consumer-2", queue).start();

    }
}
