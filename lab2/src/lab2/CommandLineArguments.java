package lab2;

public class CommandLineArguments {

	public static void main(String[] args) {
		if (args.length==0) {
			System.out.println("Brak argumentów programu");
			return;
		}
		System.out.println("Liczba argumentów: " + args.length);
		for (int i=0; i<args.length; i++) {
			System.out.println(args[i]);
		}
	}

}
