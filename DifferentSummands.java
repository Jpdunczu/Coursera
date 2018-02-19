/*
	Problem Description
Task. The goal of this problem is to represent a given positive integer 𝑛 as a sum of as many pairwise
distinct positive integers as possible. That is, to find the maximum 𝑘 such that 𝑛 can be written as
𝑎1 + 𝑎2 + · · · + 𝑎𝑘 where 𝑎1, . . . , 𝑎𝑘 are positive integers and 𝑎𝑖 ̸= 𝑎𝑗 for all 1 ≤ 𝑖 < 𝑗 ≤ 𝑘.
Input Format. The input consists of a single integer 𝑛.
Constraints. 1 ≤ 𝑛 ≤ 109.
Output Format. In the first line, output the maximum number 𝑘 such that 𝑛 can be represented as a sum
of 𝑘 pairwise distinct positive integers. In the second line, output 𝑘 pairwise distinct positive integers
that sum up to 𝑛 (if there are many such representations, output any of them).
*/

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

