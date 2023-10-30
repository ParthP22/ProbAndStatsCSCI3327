public class Main {
    public static void main(String[] args){
        BirthdayProbability bp = new BirthdayProbability();
        System.out.println("The probability of two people having the same birthday in this room is: " + bp.findProbabilityByCalculation(25) + "%");
        System.out.println(bp.findProbabilityByTrial(25,10000) + "%");
    }

}
