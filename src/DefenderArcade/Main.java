package DefenderArcade;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] var0) {

        //path to input file
        String input = "src/DefenderArcade/input.txt";

        //validation no input file
        if (input.length() == 0) {
            System.out.println("ERROR: Missing program argument for input file path. Usage: java -cp . Main <file>");
        } else {
            //get input file
            File var1 = new File(input);

            //validation if not exist file
            if (!var1.exists()) {
                System.out.println("ERROR: File [" + var1.getAbsolutePath() + "] not found.");
            } else {
                try {
                    //get content from file
                    List var2 = Files.readAllLines(var1.toPath(), StandardCharsets.UTF_8);

                    //initiate DefenderArcade class
                    DefenderArcade var3 = new DefenderArcade();

                    //call contArcades funtion as var4
                    int var4 = var3.countArcades(var2);

                    System.out.println(var4);
                } catch (Exception var5) {
                    var5.printStackTrace();
                }

            }
        }
    }
}

