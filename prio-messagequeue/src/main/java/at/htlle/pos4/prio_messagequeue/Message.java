package at.htlle.pos4.prio_messagequeue;

class Message {
    boolean isPriority = false;
    String content;

    public Message(boolean isPriority, String content) {
        this.isPriority = isPriority;
        this.content = content;
    }

    public boolean isPriority() {
        return isPriority;
    }

    public String getContent() {
        return content;
    }

    public void setPriority(boolean priority) {
        isPriority = priority;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
