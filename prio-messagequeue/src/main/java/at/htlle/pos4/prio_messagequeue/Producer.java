package at.htlle.pos4.prio_messagequeue;

class Producer extends Thread {
    PriorityMessageQueue p;
    Message msg;
    // Producer name
    private String name;

    // Constructor, getter, setter

    // Produce at random time Messages
    @Override
    public void run(){
        p.sendMessge(msg);
    }
}
