package lab5;
import java.util.Scanner;
public class DrawSquare {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int len = scan.nextInt();
			if(len<=0) {
				System.out.println("Błędne dane");
				return;
			}
			drawBase(len);
			drawSides(len);
			drawBase(len);
		}
		catch(Exception e) {
			System.out.println("Wystąpił błąd: "+ e.getMessage());
		}


		
	}
	public static void drawBase(int len) {
		System.out.println("#".repeat(len));
	}
	public static void drawSides(int len) {
		int height=len-2;
		for(int i=0; i<height;i++) {
			System.out.println("#" + " ".repeat(len-2) +"#");
		}
	}	
}

