public class GeometricDistribution {

    public static double findGeometricDistribution(int y, double p, double q){
        return (Math.pow(q,(y-1)) * p);
    }

    public static double findGeometricDistribution(int y, double p){
        return (Math.pow(1 - p,(y-1)) * p);
    }
}
