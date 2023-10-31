import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Parth Patel
 *
 */
public class Factory {
    /**
     * This File will create the .csv file that we will write to
     */
    private File carsCSV;

    /**
     * This File is for reading from the .csv file
     */
    private File readCarsCSV;

    /**
     * This FileWriter is passed into the BufferedWriter
     */
    private FileWriter fileWriter;

    /**
     * This Scanner will be used to read the .csv file
     */
    private Scanner reader;

    /**
     * This BufferedWriter will be used to write to the .csv files
     */
    private BufferedWriter writer;

    /**
     * This ArrayList will contain all the Car objects
     */
    private ArrayList<Car> cars;

    /**
     * This constructor will initialize all the fields and objects used
     * in this class.
     *
     * @throws IOException
     */
    public Factory() throws IOException {
        this.carsCSV = new File("cars.csv");
        this.readCarsCSV = new File("readCars.csv");
        this.fileWriter = new FileWriter(carsCSV);
        this.writer = new BufferedWriter(fileWriter);

        this.reader = new Scanner(carsCSV);

        this.cars = new ArrayList<>();
    }

    /**
     * This function will create and fill up the <code>cars</code>
     * ArrayList for a specified number of cars
     *
     * @param num the specified number of cars to create
     */
    public void createCars(int num){
        int skew = 0;
        for(int i = 0; i < num; i++){
            int year = (int)(Math.random()*30) + 1975;
            int miles = (int)(Math.random()*250000);
            skew = (int)(Math.random() * 20) + 1;
            if(skew == 20){
                String carType = Car.carTypes[Car.carTypes.length - 1];
                String color = "red";
                cars.add(new Car(carType,year,color,miles));
                continue;
            }
            String carType = Car.carTypes[(int)(Math.random()*(Car.carTypes.length))];
            String color = Car.colors[(int)(Math.random()*(Car.colors.length))];

            cars.add(new Car(carType,year,color,miles));
        }
    }

    /**
     * This function will first create a specified number of cars,
     * and then print the data of each car to cars.csv
     *
     * @param totalCars the total number of cars to create
     * @throws IOException
     */
    public void generateCSV(int totalCars) throws IOException {
        this.fileWriter = new FileWriter(carsCSV);
        this.writer = new BufferedWriter(fileWriter);
        createCars(totalCars);

        writer.write(Car.fileHeader);
        for(int i = 0; i < cars.size(); i++){
            writer.newLine();
            Car currCar = cars.get(i);
            writer.write(currCar.toString());

        }

        writer.close();
        fileWriter.close();

    }

    /**
     * This function will read the cars.csv file into
     * another file called readCars.csv
     *
     * @throws IOException
     */
    public void readCSV() throws IOException{
        this.fileWriter = new FileWriter(readCarsCSV);
        this.writer = new BufferedWriter(fileWriter);

        while(reader.hasNext()){
            writer.write(reader.nextLine());
            writer.newLine();
        }
        writer.close();
        fileWriter.close();

        reader.close();

    }

    /**
     * This function will execute both the <code>generateCSV</code>
     * and <code>readCSV</code> functions, while taking in a parameter
     * for the number of cars to create
     *
     * @param totalCars the total number of cars to create
     * @throws IOException
     */
    public void run(int totalCars) throws IOException {
        this.generateCSV(1000);
        this.readCSV();
    }


}
