import java.util.Scanner;



public class Change {
    

	private static int getChange(int m) {

		int remainder = 0;
		int pennies = ((m%10)%5);
		remainder = m - pennies;
		int dimes = (remainder - (remainder%10))/10;
		remainder = remainder - (dimes*10);
		int nickels = (remainder - (remainder%5))/5;  
		      
		//write your code here
        
		return (dimes + nickels + pennies);
    
	}

    

	public static void main(String[] args) {
        
		Scanner scanner = new Scanner(System.in);
        
		int m = scanner.nextInt();
        
		System.out.println(getChange(m));

    
	}

}

