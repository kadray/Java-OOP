package lab5;

import java.util.Scanner;

public class DrawTriangle {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
		int len = scan.nextInt();
		for(int i=0; i<len; i++) {
			System.out.println(" ".repeat((len-i))+"#".repeat(1+2*i));
		}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}

}
