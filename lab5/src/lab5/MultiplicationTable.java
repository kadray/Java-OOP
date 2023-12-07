package lab5;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Properties;
import java.util.Scanner;
import java.util.Random;
public class MultiplicationTable {
	public static Properties properties = new Properties();
	String prop_name="settings.properties";
	File properties_file = new File(prop_name);
	public MultiplicationTable() {
		try(FileReader properties_read = new FileReader(prop_name)) {
			properties.load(properties_read);
			}catch(IOException e) {
				properties.setProperty("wartosc_maximum", "10");
				properties.setProperty("wartosc_minimum", "1");
				properties.setProperty("procent", "0.7");
				properties.setProperty("powtorzen_maximum", "25");
				properties.setProperty("powtorzen_minimum", "10");
				try {
					FileOutputStream properties_out = new FileOutputStream(prop_name);
					properties.store(properties_out, null);
				}catch(IOException ee) {
					System.err.println(ee.getMessage());
					return;
				}
			}
	}
	public static int getMinValue() {
        return Integer.parseInt(properties.getProperty("wartosc_minimum"));
    }

    public static int getMaxValue() {
        return Integer.parseInt(properties.getProperty("wartosc_maximum"));
    }

    public static float getPercent() {
        return Float.parseFloat(properties.getProperty("procent"));
    }

    public static int getMaxRepeats() {
        return Integer.parseInt(properties.getProperty("powtorzen_maximum"));
    }

    public static int getMinRepeats() {
        return Integer.parseInt(properties.getProperty("powtorzen_minimum"));
    }
    
    
	public static void main(String[] args) {
		MultiplicationTable m = new MultiplicationTable();
		int rounds=1;
		int good_answer=0;
		Random rand_val = new Random();
		Scanner user_input = new Scanner(System.in);
		while(rounds <= m.getMaxRepeats()) {
			int val_1=rand_val.nextInt(m.getMinValue(), m.getMaxValue());
			int val_2=rand_val.nextInt(m.getMinValue(), m.getMaxValue());
			int answer=0;
			
			System.out.println(val_1 + " * " + val_2+ " =");
			try{
				answer=user_input.nextInt();
			}catch(InputMismatchException e) {
				System.err.println("Wprowadzono błędne dane");
				return;
			}
			
			
			if(answer == val_1*val_2) good_answer++;
			
			if((float)good_answer/rounds>=m.getPercent() && rounds>=m.getMinRepeats()) {
				System.out.println("Koniec gry, liczba rund: "+rounds);
				System.out.println("Oddałeś " + ((float)good_answer/rounds)*100 + "% poprawnych odpowiedzi");
				return;
			}
			rounds++;
		}
		System.out.println("Koniec gry, liczba rund: "+(rounds-1));
		System.out.println("Oddałeś " + ((float)good_answer/rounds)*100 + "% poprawnych odpowiedzi");
	}
}
