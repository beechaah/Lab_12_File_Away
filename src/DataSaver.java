import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataSaver
{
    public static void main(String[] args)
    {
        ArrayList <String>recs = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String csvRec = "";
        boolean done = false;
        String firstName = "";
        String lastName = "";
        String idNum = "";
        String email = "";
        int yob = 0;

        do
        {
            firstName = SafeInput.getNonZeroLenString(in, "Enter your First Name: ");
            lastName = SafeInput.getNonZeroLenString(in, "Enter your Last Name: ");
            idNum = SafeInput.getRegExString(in, "Enter your ID Number: ", "^\\d{6}$");
            email = SafeInput.getRegExString(in, "Enter your Email Address: ", ".*@.*");
            yob = SafeInput.getRangedInt(in, "Enter your Year of Birth: ",1000, 9999);

            csvRec = firstName + ", " + lastName + ", " + idNum + ", " + email + ", " + yob;

            recs.add(csvRec);

            done = SafeInput.getYNConfirm(in, "Are you done?");
        }while(!done);
        

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\data.txt");

        try
        {
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : recs)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();

            }
            writer.close();
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

}
