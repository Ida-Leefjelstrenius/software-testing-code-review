import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchString {

    public static void main(String[] args) {
        Scanner userScanner = new Scanner(System.in);
        String input = userScanner.nextLine();

        String[] inputParts= input.split(" ");
        
        String searchCommand = "search";
        if (inputParts.length != 3 || !inputParts[0].equals(searchCommand)) {
            System.out.println("Please give the right input format: search<pattern> <file> ");
            return;
        }

        String pattern = inputParts[1];
        String fileName = inputParts[2];

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exits");
        }

        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNextLine()) {
                String fileLine = fileScanner.nextLine();
                if (fileLine.contains(pattern)) {
                    System.out.println(fileLine);
                }
            }
            fileScanner.close();
            userScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not open the file");
        }   
    }
    
}
