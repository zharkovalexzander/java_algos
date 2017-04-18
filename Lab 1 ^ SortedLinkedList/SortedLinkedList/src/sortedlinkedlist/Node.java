package sortedlinkedlist;
public class Node 
{ 
    protected Object obj;
    protected Node next;
    public Node(Object o, Node n)
    {
       obj = o;
       next = n;
    }
    public Node()
    {
      obj = new Object();
      next = null;
    }
 }