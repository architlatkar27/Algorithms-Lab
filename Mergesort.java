import java.util.*;

public class Mergesort {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Mergesort Algorithm");
        System.out.println("Input array size");
        int n = sc.nextInt();
        System.out.println("Input array elements");
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        long t1 = System.nanoTime();
        sort(arr,0,n-1);
        long t2 = System.nanoTime();
        System.out.println("Sorted Array");
        for(int i=0;i<n;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\nEnd\nExecution Time: "+(t2-t1));
    }

    static void merge(int[] arr,int l,int m,int r){
        int i=0,j=0,k=l;
        int n1 = m-l+1;
        int n2 = r-m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(i=0;i<n1;i++) left[i] = arr[l+i];
        for(i=0;i<n2;i++) right[i] = arr[m+1+i];
        i=0;
        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                arr[k] = left[i];
                i++;k++;
            }
            else{
                arr[k] = right[j];
                j++;k++;
            }
        }
        while(i<n1){
            arr[k] = left[i];
            i++;k++;
        }
        while(j<n2){
            arr[k] = right[j];
            j++;k++;
        }
    }
    static void sort(int[] arr,int l,int r){
        if(l<r){
            int m = l+(r-l)/2;
            sort(arr,l,m);
            sort(arr,m+1,r);
            merge(arr,l,m,r);
        }
    }
}