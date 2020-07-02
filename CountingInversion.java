import java.util.*;
public class CountingInversion {
    public static void main(String args[]){
        int n;
        System.out.println("Enter array length");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        long t1 = System.nanoTime();
        int result = sort(arr,0,n-1);
        long t2 = System.nanoTime();
        System.out.println("#inversion: "+result);
        System.out.println("\nEnd\nExecution Time: "+(t2-t1));
    }

    static int sort(int[] arr,int l,int r){
        
        int rl=0,rr=0,rm=0;
        if(l<r){
            int m = l + (r-l)/2;
            rl = sort(arr,l,m);
            rr = sort(arr,m+1,r);
            rm =merge(arr,l,m,r);
            return rl+rm+rr;
        }
        return 0;
    }

    static int merge(int[] arr,int l,int m,int r){
        int i=0,j=0,k=l;
        int n1 = m-l+1;
        int n2 = r-m;
        int[] left = new int[n1];
        int[] right = new int[n2];
        for(i=0;i<n1;i++) left[i] = arr[l+i];
        for(i=0;i<n2;i++) right[i] = arr[m+1+i];
        i=0;
        int counts = 0;
        while(i<n1 && j<n2){
            if(left[i]<right[j]){
                arr[k] = left[i];
                i++;k++;
            }
            else{
                arr[k] = right[j];
                counts+=n1-i;
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
        counts+=n1-i;
        return counts;
    }
}