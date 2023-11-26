package lab4;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
public class LineCounter {

	public static void main(String args[]) {
        if (args.length < 1) {
            System.out.println("Brak argumentów programu.");
            return;
        }
        
        String file_path=args[0];
        int lines=0;
        
        try(BufferedReader file = new BufferedReader(new FileReader(file_path))){
        	while(file.readLine() !=null) {
        		lines++;
        	}
        	System.out.println("Liczba wierszy w pliku "+file_path+" wynosi: "+lines);
        }
        catch(Exception e) {
        	String e_msg = e.getMessage();
        	System.err.println("Wystąpił błąd: "+e_msg);
        }
	}
}