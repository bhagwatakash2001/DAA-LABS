import java.util.Scanner;

class FastModularExponentiation {
	static int iterative(int x, int y, int p) {
		int res = 1;
		x = x % p;

		if (x == 0)
			return 0;
		if (y == 0)
			return 1;

		while (y > 0) {
			
			if ((y & 1) != 0)
				res = (res * x) % p;
			
			y = y >> 1; 
			x = (x * x) % p;
		}
		return res;
	}

	static int recursive(int A, int B, int C) {
		if (A == 0)
			return 0;
		if (B == 0)
			return 1;
		
		long y;
		if (B % 2 == 0) {
			y = recursive(A, B / 2, C);
			y = (y * y) % C;
		}		
		else {
			y = A % C;
			y = (y * recursive(A, B - 1, C) % C) % C;
		}

		return (int) ((y + C) % C);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("***** Lab Program to Calculate Fast Modular Exponentiation *****");
		System.out.println("Enter base,power,mod :-");
		String[] ip = sc.nextLine().split(" ");
		int base = Integer.parseInt(ip[0]);
		int power = Integer.parseInt(ip[1]);
		int mod = Integer.parseInt(ip[2]);
		System.out.println("\nFast Modular Exponentiation \n1.Iterative \n2.Recursive\nEnter your choice :- ");
		switch (sc.nextInt()) {
			case 1:
				System.out.print("Answer :- " + iterative(base, power, mod));
				break;

			case 2:
				System.out.print("Answer :- " + recursive(base, power, mod));

		}

	}
}































// Time complexity ninary - log2 (y)
// Time complexity recursive - O(y)
