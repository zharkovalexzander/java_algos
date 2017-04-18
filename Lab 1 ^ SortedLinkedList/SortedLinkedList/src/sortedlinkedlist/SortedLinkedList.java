package sortedlinkedlist;
public class SortedLinkedList 
{
    protected Node first;
    public SortedLinkedList()
    {
        first = null;
    }
public Boolean LiEmpty()
{
    return(first == null);  
}
public Boolean LiFull()
    {
        try{
            Node nd = new Node();
        }
        catch(Exception E)
        {
            System.out.println(E);
            return true;
        }
        return false;
}
private Node GetNode(int i)
{

     Node m = first;
     for(int n = 0; n < i; n++){
        m = m.next;
     }
     return m;
}
public SortedLinkedList[] SplitList(int index)
{
    if(LiEmpty())
    {
       System.out.println("Impossible to split empty list");
       System.exit(1);
    }
    if(index >= this.Length() || index < 0)
    {
       System.out.println("Incorrect index");
       System.exit(1);
    }
    SortedLinkedList li1 = new SortedLinkedList();
    SortedLinkedList li2 = new SortedLinkedList();
    SortedLinkedList[] result = new SortedLinkedList[2];
    int splitter = 0;
    Node current = this.first;
    while(current!=null)
    {
        if(splitter < index)
        {
            if(li1.first == null)
            {
                li1.first = new Node(current.obj, null);
            }
            else
            {
                Node l1current = li1.first;
                while(l1current.next!=null)
                {
                    l1current = l1current.next;
                }
                l1current.next = new Node(current.obj, null);
            }
        }
        else
        {
            if(li2.first == null)
            {
                li2.first = new Node(current.obj, null);
            }
            else
            {
                Node l2current = li2.first;
                while(l2current.next!=null)
                {
                    l2current = l2current.next;
                }
                l2current.next = new Node(current.obj, null);
            }
        }
        splitter++;
        current = current.next;
    }
    result[0] = li1;
    result[1] = li2;
    return result;
}
public Object GetByIndex(int i)
{
     if(i>=this.Length() || i < 0){
            System.out.println("Index is not in list's acceptable range");
            return null;
     }
     Node m = first;
     for(int n = 0; n < i; n++){
        m = m.next;
     }
     return m.obj;
}
private int recursivelen(Node p,int cnt)
{
        if(p!=null)
        {
           cnt++;
           return recursivelen(p.next,cnt);
        }
        return cnt;
}
public int Length()
{
       return recursivelen(first,0);
}
public void AddIt(Object item)
    {
        if(LiFull())
        {     	
            System.exit(1);
        }
          Node n = first, previous = null;
          if(first == null)
          {
             first = new Node(item,first);
          }
          else
          {
            while(n!= null && !(item.hashCode() <= n.obj.hashCode()))
            {
                  previous = n;
                  n = n.next;
            }
            if(previous == null && n == first)
            {
                first = new Node(item, n);
            }
            else
            {
                previous.next = new Node(item,n);
            }
          }
    }
public Object DelOneThis(Object item)
{
    if(LiEmpty())
    {
        System.out.println("List is empty");
        System.exit(1);
    }
    Node n = first, previous = null;
    while(n!=null && !(n.obj.equals(item)))
    {
        previous = n;
        n = n.next;
    }
    if(n == null)
    {
        System.out.println(item+" Was not found");
        System.exit(1);
    }
    Node temp = new Node();
    if(previous==null)
    {
        first = first.next;
        return n.obj;
    }
    else
    {
        previous.next = n.next;
        return n.obj;
    }
}
private Boolean recbolsea(Object it, Node n)
{
    if(LiEmpty()){
        System.out.println("List is empty");
        return false;
    }
    while(n!=null && !(n.obj.equals(it)))
    {
        n = n.next;
    }
    if(n == null){
        return false;
    }
    return true;
}
public Boolean BoolSearch(Object item)
{
  return recbolsea(item,first);
}
public boolean SameElements(SortedLinkedList li2){
    if(this.Length() < li2.Length()){
        System.out.println("Second list is bigger than first");
        return false;
    }
    int counter = 0;
    Node p = li2.first;
    while(p!=null){
        Node n = first;
        while(n!=null && !(n.obj.hashCode()==p.obj.hashCode())){
            n = n.next;
        }
      if(n!=null){
        counter++;
      }
       p = p.next;
    }
    if(counter == li2.Length()){
        return true;
    }
    return false;
}
private void prrecursive(Node n)
{
        if(n!=null)
        {
            System.out.println(n.obj + " ,");
            prrecursive(n.next);
        }
}
public void PrintAll()
{
        if(LiEmpty())
        {
            System.out.println("List is empty");
            System.exit(1);
        }
        prrecursive(first);
    }
}
