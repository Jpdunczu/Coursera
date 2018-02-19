import java.util.*;



public class DifferentSummands {
    

	private static List<Integer> optimalSummands(int n) {
        
		List<Integer> summands = new ArrayList<Integer>();
        
		//write your code here
        
		int compare = 0;
		int i = 1;
		int lastAccess = 0;
		while( compare < n ) {
			compare = compare + i;
			if( compare <= n) {
				summands.add(i);
			} else if ( compare > n && lastAccess == 0 ) {
				summands.remove(i - 2);
				summands.add(i);
				lastAccess = i - 2;
				compare = (compare-i) + 1;
			} else if ( compare > n && lastAccess != 0 ) {
				summands.remove(lastAccess);
				summands.add(i);
				//lastAccess = lastAccess +1;
				compare = (compare-i) + 1;
			}
			i++;
		}
		return summands;
    
	}
    
    

	public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
        
		int n = scanner.nextInt();
        
		List<Integer> summands = optimalSummands(n);
        
		System.out.println(summands.size());
    
    
		for (Integer summand : summands) {
            
			System.out.print(summand + " ");
        
		}
    
	}

}

