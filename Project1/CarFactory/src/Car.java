/**
 * @author Parth Patel
 *
 * This <code>Car/code> class is used to create Car objects,
 * which will then be used in the <code>Factory</code>
 *
 */
public class Car {

    /**
     * This String will act as the header for the .csv files
     */
    public static final String fileHeader = "CarType, Year, Color, Miles";

    /**
     * This String attribute will store the type of the car
     */
    private String carType;

    /**
     * This integer attribute will store the year that the car was made in
     */
    private int year;

    /**
     * This String attribute will store the color of the car
     */
    private String color;

    /**
     * This integer attribute will store the mileage of the car
     */
    private int miles;

    /**
     * This String array stores the different types of cars that can be selected from
     */
    public static String carTypes[] = {"SUV", "Limo", "Van", "Minivan","Truck","Sedan"};

    /**
     * This String array stores the various types of colors that the car can be
     */
    public static String colors[] = {"red", "orange", "yellow", "green", "blue", "violet", "white", "black", "gray"};


    /**
     * This constructor will initialize all the attributes of a car
     *
     * @param carType the type of car
     * @param year the year that the car was made in
     * @param color the color of the car
     * @param miles the mileage of the car
     */
    public Car(String carType, int year, String color, int miles){
        this.carType = carType;
        this.year = year;
        this.color = color;
        this.miles = miles;
    }


    /**
     * This constructor will return a String of all the attributes
     * of the car
     *
     * @return String containing all 4 attributes of the car separated by commas
     */
    @Override
    public String toString(){
        return carType + ", " + year + ", " + color + ", " + miles;
    }



}
