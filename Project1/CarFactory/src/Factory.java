import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Factory {
    private File carsCSV;
    private File readCarsCSV;
    private FileWriter fileWriter;
    private Scanner reader;
    private BufferedWriter writer;

    private ArrayList<Car> cars;

    public Factory() throws IOException {
        this.carsCSV = new File("cars.csv");
        this.readCarsCSV = new File("readCars.csv");
        this.fileWriter = new FileWriter(carsCSV);
        this.writer = new BufferedWriter(fileWriter);

        this.reader = new Scanner(carsCSV);

        this.cars = new ArrayList<>();
    }

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

    public void generateCSV(int totalCars) throws IOException {
        this.fileWriter = new FileWriter(carsCSV);
        this.writer = new BufferedWriter(fileWriter);
        createCars(totalCars);

        writer.write(Car.fileHeader);
        for(int i = 0; i < cars.size(); i++){
            writer.newLine();
            Car currCar = cars.get(i);
            writer.write(currCar.ToString());

        }

        writer.close();
    }

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

    public void run(int totalCars) throws IOException {
        this.generateCSV(1000);
        this.readCSV();
    }


}
