
import java.io.*;
public class test {
    public static void main(String[] args)
    {
        // Create the console object
        Console cnsl
                = System.console();

        if (cnsl == null) {
            System.out.println(
                    "No console available");
            return;
        }

        // Read line
        String str = cnsl.readLine(
                "Enter string : ");

        // Print
        System.out.println(
                "You entered : " + str);
    }
}
