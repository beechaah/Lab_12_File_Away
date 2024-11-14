import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DataSaver
{
    public static void main(String[] args)
    {
        ArrayList<String> records = new ArrayList<>();
        boolean moreRecords = true;
        int idCounter = 1;
        int yearOfBirth = 0;

        while (moreRecords)
        {
            String firstName = "Enter first name: ";
            String lastName = "Enter last name: ";
            String idNumber = String.format("%06d", idCounter++);
            String email = "Enter email: ";
            System.out.println("Enter your year of birth: ");

            String record = String.join(", ", firstName, lastName, idNumber, email, String.valueOf(yearOfBirth));
            records.add(record);

            String more = "Do you want to add another record? (yes/no): ";
            moreRecords = more.equalsIgnoreCase("yes");
        }

        String fileName = "Enter the file name to save (with .csv extension): ";
        saveToFile(records, fileName);
    }

        private static void saveToFile(ArrayList<String> records, String fileName)
        {
            try (FileWriter writer = new FileWriter("src/" + fileName))
            {
                for (String record : records)
                {
                    writer.write(record + "\n");
                }
                System.out.println("Data saved to " + fileName);
            }
            catch (IOException e)
            {
                System.out.println("An error occurred while saving the file: " + e.getMessage());
            }
        }
    }