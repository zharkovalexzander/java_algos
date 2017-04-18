package binarysearchtree;
public class MainOutput {
    public static void main(String[] args) 
    {
        BST tree = new BST();
        tree.AddNode(25);
        tree.AddNode(17);
        tree.AddNode(35);
        tree.AddNode(30);
        tree.AddNode(40);
        tree.PrintPre();
        System.out.println("===================");
        tree.Delete(17);
        tree.PrintPre();
        tree.Delete(50);
        System.out.println("===================");
        tree.PrintPre();
    }  
}
