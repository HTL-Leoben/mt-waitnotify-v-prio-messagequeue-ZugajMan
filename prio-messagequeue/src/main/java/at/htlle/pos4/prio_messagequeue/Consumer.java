package at.htlle.pos4.prio_messagequeue;

class Consumer extends Thread {
    PriorityMessageQueue p;
    // Consumer name
    private String name;

    // Constructor, getter, setter
    @Override
    public void run(){
        p.receiveMessage();
    }
}
