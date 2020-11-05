import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class fileEditor {

    public List<String> grades = new ArrayList<>();

    public void fileCreator() {
        File file = new File("src/gradebook.txt");
    }

    public void fileReader() {
        try {
            FileReader reader = new FileReader("src/gradebook.txt");
            BufferedReader bReader = new BufferedReader(reader);

            String line = "";

            while ((line = bReader.readLine()) != null) {
                grades.add(line);
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Problem reading file");
        }
    }
    public void fileWriter(String[][] grade_book) {
        String format = "%-15s";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("src/gradebook.txt"));
            PrintWriter printWriter = new PrintWriter(writer);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    if (grade_book[i][j] == null) {
                        printWriter.printf(format, "N/A");
                    } else if (i == 0 || j == 0 || j == 6) {
                        printWriter.printf(format, grade_book[i][j]);
                    } else {
                        printWriter.printf(format, grade_book[i][j] + "%");
                    }
                }
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

    }
}
