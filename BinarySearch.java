/*
Problem Description
Task. The goal in this code problem is to implement the binary search algorithm.
Input Format. The first line of the input contains an integer 𝑛 and a sequence 𝑎0 < 𝑎1 < . . . < 𝑎𝑛−1
of 𝑛 pairwise distinct positive integers in increasing order. The next line contains an integer 𝑘 and 𝑘
positive integers 𝑏0, 𝑏1, . . . , 𝑏𝑘−1.
Constraints. 1 ≤ 𝑛, 𝑘 ≤ 10^4; 1 ≤ 𝑎𝑖 ≤ 10^9 for all 0 ≤ 𝑖 < 𝑛; 1 ≤ 𝑏𝑗 ≤ 10^9 for all 0 ≤ 𝑗 < 𝑘;
Output Format. For all 𝑖 from 0 to 𝑘 − 1, output an index 0 ≤ 𝑗 ≤ 𝑛 − 1 such that 𝑎𝑗 = 𝑏𝑖 or −1 if there
is no such index.
*/

import java.io.*;
import java.util.*;



public class BinarySearch {

  
  
	static int binarySearch(int[] a, int x) {
        
		int left = 0, right = a.length - 1;
     
   
		//write your code here

 
		while ( left <= right ) {      
			int mid = (left + right) /2;
			if( a[mid] == x ) {
				// we found x
				return mid;
			} else if ( a[mid] < x ) {
				// check to the right
				left = mid +1;
			} else if ( a[mid] > x ) {
				// check to the left
				right = mid -1;
			}
		//System.out.println(x + ", " + left + ", " + mid + ", " + right);
		}
		return -1;
	}

    

	static int linearSearch(int[] a, int x) {
        
		for (int i = 0; i < a.length; i++) {
            
			if (a[i] == x) return i;
        
		}
        
		return -1;
    
	}

    

	public static void main(String[] args) {
        
		FastScanner scanner = new FastScanner(System.in);
        
		int n = scanner.nextInt();
        
		int[] a = new int[n];
    
    
		for (int i = 0; i < n; i++) {
            
			a[i] = scanner.nextInt();
        
		}
        

		int m = scanner.nextInt();
        
		int[] b = new int[m];
        

		for (int i = 0; i < m; i++) {
          
			b[i] = scanner.nextInt();
        
		}
        

		for (int i = 0; i < m; i++) {
            
			//replace with the call to binarySearch when implemented
            
			//System.out.print(linearSearch(a, b[i]) + " ");
        
			System.out.print(binarySearch(a, b[i]) + " ");
  
		}
    
	}
    

	static class FastScanner {
        
		BufferedReader br;
        
		StringTokenizer st;

        

		FastScanner(InputStream stream) {
            
			try {
                
				br = new BufferedReader(new InputStreamReader(stream));
            
			} catch (Exception e) {
                
				e.printStackTrace();
            
			}
        
		}

        

		String next() {
            
			while (st == null || !st.hasMoreTokens()) {
               
				try {
                    
					st = new StringTokenizer(br.readLine());
                
				} catch (IOException e) {
                    
					e.printStackTrace();
                
				}
            
			}
            

			return st.nextToken();
        
		}

        

		int nextInt() {
            
			return Integer.parseInt(next());
        
		}
    
	}

}
