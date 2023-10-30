import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Plotter plotter = new Plotter();
        plotter.valuesToCSV(-100,100,2,2,0,3);
        Salter salter = new Salter();
        salter.saltValues(-200,200);
    }
}
