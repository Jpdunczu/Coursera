import java.util.Scanner;



public class Fibonacci {
  

	private static long calc_fib(int n) {
  
		if (n <= 1)
      
			return n;

 
 
		int[] fibArray = new int[n + 1]; 
		fibArray[0] = 0;
		fibArray[1] = 1;
		for (int i = 2; i <= n; i++) {
			fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
		}   
		return fibArray[n];
  
	}

  

	private static int getFibonacciLastDigitNaive(int n) {
        
		if (n <= 1)
            
			return n;

        

		int previous = 0;
        
		int current  = 1;

    
    
		for (int i = 0; i < n - 1; ++i) {
            
			int tmp_previous = previous;
            
			previous = current;
            
			current = (tmp_previous + current) % 10;
        
		}

        

		return current;
    
	}
    
 

	public static void main(String args[]) {
    

		Scanner in = new Scanner(System.in);
    
		int n = in.nextInt();

    
		//System.out.println(calc_fib(n));
  
		int c = getFibonacciLastDigitNaive(n);
        
		System.out.println(c);
  
	}

}
