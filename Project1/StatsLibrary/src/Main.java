import java.text.DecimalFormat;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        //Note to self: put all distributions in one class
        DecimalFormat decimalFormat = new DecimalFormat("#.########");
        /*
        //System.out.println(decimalFormat.format(BinomialDistribution.findBinomialDistribution(4,2,0.8,0.2)));
        System.out.println(decimalFormat.format(GeometricDistribution.findGeometricDistribution(1,0.45,0.55)
        + GeometricDistribution.findGeometricDistribution(2,0.45,0.55)
        + GeometricDistribution.findGeometricDistribution(3,0.45,0.55)
        + GeometricDistribution.findGeometricDistribution(4,0.45,0.55)));


        //System.out.println(HypergeometricDistribution.findHypergeometricDistribution(10,5,6,5));

         */

        //System.out.println(decimalFormat.format(Distributions.findNegativeBinomialDistribution(3,3,0.9,0.1) +
        //        Distributions.findNegativeBinomialDistribution(3,4,0.9,0.1) + Distributions.findNegativeBinomialDistribution(3,5,0.9,0.1)));
        //System.out.println();
        /*
        System.out.println(Distributions.findNegativeBinomialDistribution(3,7,0.2,0.8));
        System.out.println(Distributions.findNegativeBinomialDistributionVariance(3,0.2));

        System.out.println(Distributions.findGeometricDistribution(3,0.2));
        System.out.println(Distributions.findGeometricDistributionExpeceted(0.3));

        System.out.println(Distributions.findHypergeometricDistribution(10,3,5,3));
        System.out.println((0.14288)/(1 - (Distributions.findPoissonDistribution(2,2) +
                Distributions.findPoissonDistribution(2,1) + Distributions.findPoissonDistribution(2,0))));

         */

        SetOperations set = new SetOperations();
        for(int i = 0; i < 5; i++){
            set.addElement((int)(Math.random() * 20) + 1);
        }

        SetOperations set2 = new SetOperations();
        for(int i = 0; i < 5; i++){
            set2.addElement((int)(Math.random() * 100) + 1);
        }
        SetOperations sampleSpace = new SetOperations();
        for(int i = 0; i <= 20; i++){
            sampleSpace.addElement(i);
        }

        System.out.println(set2);
        System.out.println(set);

        System.out.println(set.complement(sampleSpace));

        ArrayList<Double> points = new ArrayList<>();
        for(int i = 0; i < 9; i++){
            double point = (double)((int)(Math.random()*10 + 1));
            points.add(point);
        }

        double[] modes = CentralTendency.findMode(points);

        for(double point : points){
            System.out.print(point + ", ");
        }
        System.out.println();

        for(double mode : modes){
            System.out.print(mode + ", ");
        }
        System.out.println();
        ArrayList<Double> points2 = new ArrayList<>();
        points2.add(1.1);
        System.out.println(CentralTendency.findMedian(points2));
        System.out.println(CentralTendency.findMean(points));



        //System.out.println(Distributions.findBinomialDistribution(3,2,0.5,0.5));
    }
}
