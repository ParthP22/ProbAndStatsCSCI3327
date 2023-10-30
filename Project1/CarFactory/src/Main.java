import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException{
        Factory factory = new Factory();
        factory.generateCSV(1000);
        factory.readCSV();
    }

}
