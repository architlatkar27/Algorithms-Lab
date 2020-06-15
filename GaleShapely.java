import java.util.*;

public class GaleShapely {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Gale-Shapely Algorithm");
        System.out.println("Input the number of men");
        int n = sc.nextInt();
        int[][] menpref = new int[n][n];
        int[][] womenpref = new int[n][n];
        System.out.println("Input men's preferences");
        for(int i=0;i<n;i++){
            System.out.print("Preference of man "+i+" ->");
            for(int j=0;j<n;j++){
                menpref[i][j] = sc.nextInt();
            }
        }
        System.out.println("\nInput women's preferences");
        for(int i=0;i<n;i++){
            System.out.print("Preference of woman "+i+" ->");
            for(int j=0;j<n;j++){
                womenpref[i][j] = sc.nextInt();
            }
        }
        galeshapely(menpref,womenpref,n);
        System.out.println("End");
    }

    static boolean wPrefersm(int[] wpref,int n,int m,int m1){
        for(int i=0;i<n;i++){
            if(wpref[i] == m) return true;
            if(wpref[i] == m1) return false;
        }
        return false;
    }

    static void galeshapely(int[][] menpref,int[][] womenpref,int n){
        boolean[] mtaken = new boolean[n];
        for(int i=0;i<n;i++) mtaken[i] = false;
        int[] wpartner = new int[n];
        Arrays.fill(wpartner, -1);
        int m,freecount = n;
        while(freecount>0){
            for(m=0;m<n;m++){
                if(mtaken[m] == false) break;
            }
            for(int i=0;i<n;i++){
                if(wpartner[i] == -1){
                    wpartner[i] = m;
                    mtaken[m] = true;
                    freecount--;
                }
                else{
                    if(wPrefersm(womenpref[i],n,m,wpartner[i])){
                        mtaken[m] = true;
                        mtaken[wpartner[i]] = false;
                        wpartner[i] = m;
                    }
                }
                if(mtaken[m] == true) break;
            }
        }
        System.out.println("Man Woman");
        for(int i=0;i<n;i++){
            System.out.println(wpartner[i]+"\t"+i);
        }
    }
}