package lab4;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCounter {
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Brak argumentów programu.");
            return;
        }
        String fileName= new String();
        for(String element:args) {
        	if(element.contains(".")) {
        	fileName = element;
        	}
        }
        boolean countLines = false;
        boolean countWords = false;
        boolean countChars = false;

        for (int i = 0; i < args.length; i++) {
        	if (args[i].contains("-")) {
	        	if (args[i].contains("c")) countChars=true;
	        	if (args[i].contains("l")) countLines=true;
	        	if (args[i].contains("w")) countWords=true;
        	}
        }
        if (args.length==1) {
        	countChars=true;
        	countLines=true;
        	countWords=true;
        }

        int lines = 0;
        int words = 0;
        int chars = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines++;
                chars += line.length();
                String[] wordList = line.split("\\s+");
                words += wordList.length;
            }
        } catch (IOException e) {
            System.err.println("Błąd podczas odczytu pliku: " + e.getMessage());
        }

        if (countLines) {
            System.out.println("wierszy: " + lines);
        }
        if (countWords) {
            System.out.println("słów: " + words);
        }
        if (countChars) {
            System.out.println("znaków: " + chars);
        }
    }
}
