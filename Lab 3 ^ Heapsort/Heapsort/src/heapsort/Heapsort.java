package heapsort;
import java.util.Random;
public class Heapsort {
    private static void swaptwochildren(int[] arr, int a, int b, int c)
    {
        if(arr[b] >= arr[a] && arr[b] >= arr[c])
        {
            int temp1 = arr[b];
            arr[b] = arr[a];
            arr[a] = temp1;
        }
        if(arr[c] >= arr[a] && arr[b] <= arr[c])
        {
            int temp2 = arr[c];
            arr[c] = arr[a];
            arr[a] = temp2;
        }
    }
    private static void swaponechildren(int[] arr, int a, int b)
    {
        if(arr[b] >= arr[a])
        {
            int temp1 = arr[b];
            arr[b] = arr[a];
            arr[a] = temp1;
        }
    }
    private static void swap(int[] arr, int a, int b)
    {
        int temp1 = arr[b];
        arr[b] = arr[a];
        arr[a] = temp1;
    }
    private static void children(int[] arr, int i, int lst)
    {
        if(((2*i + 1) <= lst-1) && ((2*i + 2) <= lst))
        {
            swaptwochildren(arr, i, (2*i+1) , (2*i+2));
        }
        else
        {
            if(((2*i + 1) == lst) && ((2*i + 2) == lst+1))
            {
                swaponechildren(arr,i,(2*i+1));
            }
        }
    }
    private static void rearrange(int[] arr, int lst)
    {
        int last = (int)Math.floor((lst-1)/2);
        for(int i = last; i >= 0; i--)
        {
            children(arr, i, lst);
            if(i == arr.length - 1)
            {
                break;
            }
            else
            {
                if(i == arr.length-1)
                {
                    break;
                }
             }
          }
    }
    private static void sorting(int[] arr)
    {
        int last = arr.length - 1;
        while(last!=0)
        {
            rearrange(arr, last);
            swap(arr, 0, last);
            last--;
        }
    }
    public static void printarr(int[] arr)
    {
        for(int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i]+", ");
        }
        System.out.print("\n");
    }
    public static void fill(int[] arr)
    {
        Random rand = new Random();
        for(int i = 0; i < arr.length; i++)
        {
            arr[i] = rand.nextInt(900);
        }
    }
    public static void main(String[] args) 
    {
       int[] arr = new int[50];
       fill(arr);
       printarr(arr);
       System.out.println("==============================================");
       sorting(arr);
       printarr(arr);
    }
    
}
