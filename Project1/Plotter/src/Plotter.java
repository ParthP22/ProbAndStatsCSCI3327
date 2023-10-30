import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Plotter {

    public double linearFunction(double m, double x, double b){
        return m*x + b;
    }

    public double quadraticFunction(double a, double x, double b, double c){
        return a*Math.pow(x,2) + b * x + c;
    }

    public void valuesToCSV(double rangeLowerBound, double rangeUpperBound, double increment, double a, double b, double c) throws IOException {
        Writer writer = new FileWriter("plot.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        for(double i = rangeLowerBound; i < rangeUpperBound; i += increment){
            bufferedWriter.write(""+i + ", " + quadraticFunction(a,i,b,c));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        writer.close();

    }

    public void valuesToCSV(double rangeLowerBound, double rangeUpperBound, double increment, double m, double b) throws IOException {
        Writer writer = new FileWriter("plot.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        for(double i = rangeLowerBound; i < rangeUpperBound; i += increment){
            bufferedWriter.write(""+i + ", " + linearFunction(m,i,b));
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
        writer.close();

    }



}
