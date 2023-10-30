public class Car {
    public static final String fileHeader = "CarType, Year, Color, Miles";
    private String carType;
    private int year;
    private String color;
    private int miles;

    public static String carTypes[] = {"SUV", "Limo", "Van", "Minivan","Truck","Sedan"};

    public static String colors[] = {"red", "orange", "yellow", "green", "blue", "violet", "white", "black", "gray"};





    public Car(String carType, int year, String color, int miles){
        this.carType = carType;
        this.year = year;
        this.color = color;
        this.miles = miles;
    }



    public String ToString(){
        return carType + ", " + year + ", " + color + ", " + miles;
    }



}
