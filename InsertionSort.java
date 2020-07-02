import java.util.*;
public class InsertionSort {
    public static void main(String args[]){
        int n;
        System.out.println("Enter array length");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter array elements");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        long t1 = System.nanoTime();
        algorithm(arr,n);
        long t2 = System.nanoTime();
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nEnd\nExecution Time: "+(t2-t1));
    }
    static void algorithm(int[] arr,int n){
        int key,i,j;
        for(i=1;i<n;i++){
            key = arr[i];
            j = i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
}