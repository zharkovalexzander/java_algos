package javaapplication6;

public class Stack {

    protected Vertex[] stack;
    protected int top;

    public Stack() {
        stack = new Vertex[20];
        top = -1;
    }

    public int GetTop() {
        return top;
    }

    public boolean IsEmpty() {
        return (top == -1);
    }

    public void Push(Vertex Data) {
        stack[++top] = Data;
    }

    public void Clear() {
        for (int i = 0; i <= top; i++) {
            stack[i] = null;
        }
        top = -1;
    }

    public Vertex Pop() {
        if (IsEmpty()) {
            System.out.println("The stack is empty");
            System.exit(1);
        }
        Vertex result = stack[top];
        stack[top--] = null;
        return result;
    }

    public Vertex RevealTop() {
        return stack[top];
    }

    public void printStack() {
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i].Data + ", ");
        }
        System.out.println("\n");
    }
}
