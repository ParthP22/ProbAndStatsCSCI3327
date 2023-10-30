public class HypergeometricDistribution {

    public static double findHypergeometricDistribution(int N, int n, int r, int y){
        return (Combination.findCombination(r , y) * Combination.findCombination((N-r) , (n-y)) / Combination.findCombination(N , n));
    }

}
