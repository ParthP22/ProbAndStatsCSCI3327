import java.io.*;
import java.util.Scanner;

public class Salter {

    public void saltValues(double saltLowerBound, double saltUpperBound) throws IOException {
        if(saltLowerBound > 0 || saltUpperBound < 0){
            return;
        }

        File csvFile = new File("plot.csv");

        Scanner reader = new Scanner(csvFile);

        Writer writer = new FileWriter("salted.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        while(reader.hasNext()){
            String[] line = reader.nextLine().split(",");
            double saltValue = Double.parseDouble(line[1]) + Math.random() * saltUpperBound + saltLowerBound;
            bufferedWriter.write(line[0].trim() + ", " + saltValue);
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        writer.close();
    }

}
