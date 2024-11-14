import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class FileInspector
{
    public static void main(String[] args)
    {
        JFileChooser fileChooser = new JFileChooser(new File("src"));
        int result = fileChooser.showOpenDialog(null);

        if (result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            processFile(selectedFile);
        }
        else
        {
            System.out.println("No file selected.");
        }
    }

    private static void processFile(File file)
    {
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                String line = scanner.nextLine();
                System.out.println(line);

                lineCount++;
                wordCount += line.split("\\s+").length;
                charCount += line.length();
            }

            System.out.println("\nSummary Report:");
            System.out.println("File Name: " + file.getName());
            System.out.println("Number of Lines: " + lineCount);
            System.out.println("Number of Words: " + wordCount);
            System.out.println("Number of Characters: " + charCount);

        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found: " + file.getAbsolutePath());
        }
    }
}