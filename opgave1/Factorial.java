public class Factorial {

    public static void main(String[] args) {
        int n    = Integer.parseInt(args[0]);
        int nfac = fac(n);
        System.out.println(n + "! = " + nfac);
    }

    public static int fac(int k) {
        if (k < 0)
            return 0;
        int kfac = 1;
        while (k > 1) {
            kfac = kfac * k;
            k = k - 1;
        }
        return kfac;
    }       
}
