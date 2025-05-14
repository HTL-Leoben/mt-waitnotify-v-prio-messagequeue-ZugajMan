package at.htlle.pos4.prio_messagequeue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class PriorityMessageQueue {

    // necessary Constructor
    private final LinkedList<Message>priorityQueue = new LinkedList<>();

    private final LinkedList<Message> spamQueue = new LinkedList<>();

    private final int capacity;

    public PriorityMessageQueue(int capacity) {
        this.capacity = capacity;
    }
    private int getTotalSize(){
        return priorityQueue.size()+spamQueue.size();
    }
    public synchronized void sendMessage(Message msg) throws InterruptedException {
        while(getTotalSize() >= capacity){
            wait();
        }

        if(msg.isPriority == true){
            priorityQueue.offer(msg);
        }else{
            spamQueue.offer(msg);
        }
        System.out.println(Thread.currentThread().getName() + " Send Message("+ msg.isPriority() + "): "+ msg.getContent());
        notifyAll();
    }

    public synchronized Message receiveMessage() throws InterruptedException {
        while(getTotalSize() ==0){
            wait();
        }

        Message msg;

        if(!priorityQueue.isEmpty()){
            msg = priorityQueue.poll();
        }else{
            msg = spamQueue.poll();
        }
        System.out.println(Thread.currentThread().getName() + " Receive Message(): "+ msg.isPriority() + ", "+ msg.getContent());
        notifyAll();
        return msg;
    }
}
