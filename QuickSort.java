import java.util.*;
public class QuickSort {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Input Array Size");
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Input Array Elements");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        long t1 = System.nanoTime();
        algorithm(arr,0,n-1);
        long t2 = System.nanoTime();
        System.out.println("Sorted Array");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nEnd");
        System.out.println("Execution Time: "+(t2-t1));
    }
    static void algorithm(int[] arr,int start,int end){
        if(start<end){
            int pivpos = partition(arr,start,end);
            algorithm(arr,start,pivpos-1);
            algorithm(arr,pivpos+1,end);
        }
    }
    static int partition(int[] arr,int start,int end){
        int i = start+1;
        int piv = arr[start];
        for(int j=start+1;j<=end;j++){
            if(arr[j]<piv){
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i+=1;
            }
        }
        int temp = arr[start];
        arr[start] = arr[i-1];
        arr[i-1] = temp;
        return i-1;
    }
    
}