package javaapplication6;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    protected ArrayList<Vertex> graph;

    public Graph() {
        graph = new ArrayList<>();
    }

    public void CreateData(int count) {
        for (int i = 1; i <= count; i++) {
            graph.add(new Vertex(i));
        }
        System.out.println("Created!");
    }

    public void CreateLinks() {
        System.out.println("If you'll end creating edges for one vertex, print '0'");
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < graph.size(); i++) {
            System.out.println("Lets create edges for " + (i + 1) + " vertex");
            Vertex Vert = graph.get(i);
            while (true) {
                System.out.println("Link to :");
                int exit = in.nextInt();
                if (exit == 0) {
                    break;
                }
                Vert.Links.Add(graph.get(exit - 1));
            }
        }
    }

    public void DFS(int Data) {
        Vertex start = Reveal(Data);
        start.SetVisited();
        Stack stack = new Stack();
        stack.Push(start);
        System.out.print(start.Data + ", ");
        while (!stack.IsEmpty()) {
            Vertex next = findunvisited(stack.RevealTop());
            if (next.Data == -1) {
                stack.Pop();
            } else {
                next.SetVisited();
                System.out.print(next.Data + ", ");
                stack.Push(next);
            }
        }
        System.out.print("\n");
        ClearLabels();
        ClearRange();
    }

    public void BFS(int Data) {
        Vertex start = Reveal(Data);
        start.SetVisited();
        Queue queue = new Queue();
        queue.enqueue(start);
        System.out.print(start.Data + ", ");
        while (!queue.isEmpty()) {
            Vertex Vert = queue.dequeue();
            for (int i = 0; i <= Vert.LinkTop(); i++) {
                if (FindLink(Vert, i).ShowLabel().equals("NotVisited")) {
                    System.out.print(FindLink(Vert, i).Data + ", ");
                    FindLink(Vert, i).SetVisited();
                    queue.enqueue(FindLink(Vert, i));
                }
            }
        }
        System.out.print("\n");
        ClearLabels();
        ClearRange();
    }

    public void SolveMaze(int Start, int toFind) {
        Vertex start = Reveal(Start);
        start.SetVisited();
        Stack stack = new Stack();
        stack.Push(start);
        Vertex V = new Vertex(0);
        while (V.Data != toFind) {
            V = findunvisited(stack.RevealTop());
            if (V.Data == toFind) {
                stack.Push(V);
                break;
            }
            if (V.Data == -1) {
                stack.Pop();
            } else {
                V.label.Visit();
                stack.Push(V);
            }
        }
        stack.printStack();
        stack.Clear();
        ClearLabels();
        ClearRange();
    }

    protected Vertex findunvisited(Vertex Vert) {
        while (RevealNext(Vert) != null) {
            if (RevealNext(Vert).ShowLabel().equals("NotVisited")) {
                return RevealNext(Vert);
            }
            Vert = Next(Vert);
        }
        return new Vertex(-1);
    }

    protected Vertex RevealNext(Vertex Vert) {
        if (Vert.RevealNext() == -1) {
            return null;
        }
        return graph.get((Vert.RevealNext()) - 1);
    }

    protected Vertex Next(Vertex Vert) {
        return graph.get((Vert.Next()) - 1);
    }

    protected Vertex FindLink(Vertex Vert, int index) {
        return graph.get((Vert.LinkFind(index)) - 1);
    }

    protected void ClearLabels() {
        for (int i = 0; i < graph.size(); i++) {
            graph.get(i).ClearLabel();
        }
    }

    protected Vertex Reveal(int Data) {
        return graph.get(Data - 1);
    }

    protected void ClearRange() {
        for (int i = 0; i < graph.size(); i++) {
            graph.get(i).MoveRange();
        }
    }
}

