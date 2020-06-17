import java.util.*;

class Bucket{
    ArrayList<Float> elements ;
    Bucket(){
        elements = new ArrayList<Float>();
        elements.add(Float.MAX_VALUE);
    }
    void addele(float ele){
        //System.out.println("Inside addele()");
        int index = 0;
        while(ele > elements.get(index)) index++;
        elements.add(index, ele);
    }

    public String toString(){
        String s = new String();
        for(int i=0;i<elements.size()-1;i++){
            s.concat(Float.toString(elements.get(i)));
            s.concat(" ");
        }
        return s;
    }
}

public class BucketSort {
    public static void main(String args[]){
        System.out.println("Bucket Sort Algorithm.");
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Input Size of Array");
        n = sc.nextInt();
        float[] arr = new float[n];
        Bucket[] buckets = new Bucket[n];
        for(int i=0;i<n;i++){
            buckets[i] = new Bucket();
        }
        System.out.println("Enter elements");
        for(int i=0;i<n;i++){
            arr[i] = sc.nextFloat(); 
        }
        long t1 = System.nanoTime();
        for(int i=0;i<n;i++){
            int bi = (int)(n*arr[i]);
            buckets[bi].addele(arr[i]);
        }
        long t2 = System.nanoTime();
        System.out.println("Sorted Array");
        for(int i=0;i<n;i++){
            for(int j=0;j<buckets[i].elements.size()-1;j++){
                System.out.print(buckets[i].elements.get(j)+" ");
            }
            System.out.print("/");
        }
        System.out.println("\nEnd");
        System.out.println("Execution Time: "+(t2-t1));
    }
}