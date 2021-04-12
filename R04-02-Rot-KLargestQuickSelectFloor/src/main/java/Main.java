import orderStatistic.KLargest;
import orderStatistic.KLargestOrderStatisticsImpl;
import orderStatistic.QuickSelect;
import problems.Floor;
import problems.FloorBinarySearchImpl;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        QuickSelect<Integer> qs = new QuickSelect<>();

        Integer[] a = {9,4,8,3,7,2,6,1,5,0};

        for (int i = 0; i <= a.length; i++) {
            System.out.println(qs.quickSelect(a, i));
        }

        System.out.println("-----");

        KLargest<Integer> kl = new KLargestOrderStatisticsImpl<>();

        Integer[] b = {9,4,8,3,7,2,6,1,5,0};

        System.out.println(Arrays.toString(kl.getKLargest(b, 5)));
        System.out.println(Arrays.toString(kl.getKLargest(b, 1)));
        System.out.println(Arrays.toString(kl.getKLargest(b, 10)));
        System.out.println(Arrays.toString(kl.getKLargest(b, 0)));
        System.out.println(Arrays.toString(kl.getKLargest(b, 8)));
        System.out.println(Arrays.toString(kl.getKLargest(b, 9)));

        System.out.println("-----");

        Floor f = new FloorBinarySearchImpl();

        Integer[] c = {4,6,8,10};

        System.out.println(f.floor(c, 2)); // 7

        Integer[] d = {4,6,8,10};

        System.out.println(f.floor(c, 11)); // 10
    }

}
