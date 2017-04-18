package javaapplication6;

public class Link {

    protected Vertex[] Vertices;
    protected int top;
    protected int range;

    public Link() {
        Vertices = new Vertex[20];
        top = -1;
        range = 0;
    }

    public boolean IsEmpty() {
        return (top == -1);
    }

    public void Add(Vertex Data) {
        Vertices[++top] = Data;
    }

    public int Next() {
        return Vertices[range++].Data;
    }

    public int RevealNext() {
        if (Vertices[range] == null) {
            return -1;
        }
        return Vertices[range].Data;
    }

    public int Index(int index) {
        return Vertices[index].Data;
    }

    public void BackwardRange() {
        range = 0;
    }    
}
