package at.htlle.pos4.prio_messagequeue;

import java.util.LinkedList;
import java.util.List;

class PriorityMessageQueue {

    // necessary Constructor


    LinkedList<Message>priorityList;

    LinkedList<Message>spamList;
    public synchronized void sendMessge(Message msg) {
        if(msg.isPriority == true){
            priorityList.add(msg);
        }else{
            spamList.add(msg);
        }
    }

    public synchronized Message receiveMessage() {

    }
}
