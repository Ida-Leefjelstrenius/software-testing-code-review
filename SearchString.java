import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SearchString {

    public static void main(String[] args) {
        String command = args[0];
        String pattern = args[1];
        String fileName = args[2];
        
        String searchCommand = "search";
        if (command.equals(searchCommand)) {
            System.out.println("Please give the right input format: search <pattern> <file> ");
            return;
        }

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
        } catch (FileNotFoundException e) {
            System.out.println("Could not open the file");
        }   
    }
    
}
