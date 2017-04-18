package javaapplication6;

import java.util.Scanner;

public class Program {

    public static Graph CreateGraph() {
        Graph Test = new Graph();
        Scanner in = new Scanner(System.in);
        System.out.println("Hello! Lets start with number of vertices in your graph");
        int Vertices = Integer.parseInt(in.nextLine());
        Test.CreateData(Vertices);
        Test.CreateLinks();
        return Test;
    }

    public static void CallFunc(Graph graph) {
        System.out.println("Print 0 for DFS traversal");
        System.out.println("Print 1 for BFS traversal");
        System.out.println("Print 'exit' to exit");
        Scanner in = new Scanner(System.in);
        String temp = "";
        while (!temp.equals("exit")) {
            temp = in.nextLine();
            if (temp.equals("0")) {
                System.out.println("Depth-first search");
                System.out.println("From which vertex do you want to start?");
                int Next = in.nextInt();
                graph.DFS(Next);
            }
            if (temp.equals("1")) {
                System.out.println("Breadth-first search");
                System.out.println("From which vertex do you want to start?");
                int Next = in.nextInt();
                graph.BFS(Next);
            }
            if (temp.equals("2")) {
                System.out.println("Maze Problem Solving");
                System.out.println("From which vertex do you want to start and which to end?");
                int Next1 = in.nextInt();
                int Next2 = in.nextInt();
                graph.SolveMaze(Next1, Next2);
            }
        }

    }

    public static void main(String[] args) {
        Graph Main = CreateGraph();
        CallFunc(Main);
        Graph Maze = CreateGraph();
        Scanner in = new Scanner(System.in);
        System.out.println("Maze Problem Solving");
        System.out.println("From which vertex do you want to start and which to end?");
        int Next1 = in.nextInt();
        int Next2 = in.nextInt();
        Maze.SolveMaze(Next1, Next2);
    }

}
