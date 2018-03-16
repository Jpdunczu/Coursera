
import java.util.*;

public class Inversions {
    
    private static int[] arr;
    private static long numberOfInversions;
    
    private static long getNumberOfInversions(int[] a, int left, int right) {
        
        if (right <= left + 1) {
            return numberOfInversions;
        }
        
        arr = a;
        Mergesort(arr);
        
        return numberOfInversions;
    }
    
    private static void Mergesort(int[] a) {
        
        int mid = (a.length)/2;
        if ( a.length > 1 ) {
            int[] subArr1 = new int[mid];
            int[] subArr2 = new int[a.length - mid];
            for( int i = 0; i < mid; i++ ) {
                subArr1[i] = a[i];
            }
            int k = 0;
            for( int j = mid; j < a.length; j++ ) {
                subArr2[k] = a[j];
                k++;
            }
            
            Mergesort(subArr1);
            Mergesort(subArr2);
            
            Merge(subArr1, subArr2, a);
        }
    }
    
    private static void Merge(int[] aB, int[] aC, int[] aA) {
        int i = 0;
        int j = 0;
        int k = 0;
        
        while( i < aB.length && j < aC.length ) {
            if( aB[i] <= aC[j] ) {
                aA[k] = aB[i];
                i++;
            } else {
                aA[k] = aC[j];
                j++;
                numberOfInversions += aB.length - i;
            }
            k++;
        }
        
        if( i == aB.length ) {
            for(; j < aC.length; j++ ) {
                aA[k] = aC[j];
                k++;
            }
        } else {
            for(; i < aB.length; i++ ) {
                aA[k] = aB[i];
                k++;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        System.out.println(getNumberOfInversions(a, 0, a.length));
    }
}

