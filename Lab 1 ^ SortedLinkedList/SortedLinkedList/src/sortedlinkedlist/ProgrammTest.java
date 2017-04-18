package sortedlinkedlist;
public class ProgrammTest {
    public static void main(String[] args) 
    {
        SortedLinkedList a = new SortedLinkedList();
        a.AddIt(10);
        a.AddIt(20);
        a.AddIt(30);
        a.AddIt(40);
        a.AddIt(50);
        a.SplitList(4)[1].PrintAll();
    }
}   
