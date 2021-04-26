package RoyalRumble;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Iterator;
import java.util.List;

public class Main {
    public Main() {
    }

    public static void main(String[] var0) {

        //path to input file
        String input = "src/RoyalRumble/input.txt";

        //validation no input file
        if (input.length() == 0) {
            System.out.println("ERROR: Missing program argument for input file path. Usage: java -cp . Main <file>");
        } else {
            //get input file
            File var1 = new File(input);

            //validation if not exists file
            if (!var1.exists()) {
                System.out.println("ERROR: File [" + var1.getAbsolutePath() + "] not found.");
            } else {
                try {
                    //get content from file
                    List var2 = Files.readAllLines(var1.toPath(), StandardCharsets.UTF_8);
                    //initiate RoyalRumble class
                    RoyalRumble var3 = new RoyalRumble();
                    //sort content
                    List var4 = var3.getSortedList(var2);

                    //show content
                    if (var4 != null) {
                        Iterator var5 = var4.iterator();

                        //ileteral print each content of list
                        while (var5.hasNext()) {
                            String var6 = (String) var5.next();
                            System.out.println(var6);
                        }
                    }
                } catch (Exception var7) {
                    var7.printStackTrace();
                }

            }
        }
    }
}
