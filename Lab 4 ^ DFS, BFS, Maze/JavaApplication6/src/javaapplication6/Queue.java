package javaapplication6;

public class Queue {

    protected int front;
    protected int rear;
    protected Vertex[] queue;

    public Queue() {
        front = rear = 19;
        queue = new Vertex[20];
    }

    public boolean isEmpty() {
        return (front == rear);
    }

    public boolean isFull() {
        return ((rear + 1) % 20 == front);
    }

    public void makeEmpty() {
        front = rear = 19;
    }

    public void enqueue(Vertex Vert) {
        if (isFull()) {
            System.exit(1);
        }
        rear = (rear + 1) % 20;
        queue[rear] = Vert;
    }

    public Vertex dequeue() {
        if (isEmpty()) {
            System.exit(1);
        }
        front = (front + 1) % 20;
        return queue[front];
    }
}
