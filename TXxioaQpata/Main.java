package TXxioaQpata;

import java.util.Scanner;

/**
 * Created With IntelliJ IDEA.
 * Descriptions:小Q正在攀爬一座宝塔，这座宝塔很特别，塔总共有n层，但是两层之间的净高却不相同，所以造成小Q爬过每层的时间也不同。
 * 如果某一次高度为x，那么爬过这一层所需时间也就是x。小Q还会使用一种魔法，每使用一次可以让他向上跳1层或者两层，但是每次调后，
 * 必须至少爬一层才能接着使用魔法。小Q想用最短的时间上顶，希望你能告诉他
 * User:Mr.Du
 * Date:2019-06-28
 * Time:15:53
 */

/*
*
* p[i]表示到达第i层最短时间，并且到达第i层方式是爬
* t[i]表示到达第i层最短时间，并且到达第i层方式是跳
* 情况一:到达第i层的方式是爬
* 那么到达第i-1层的方式可以是跳，也可以是爬，二者选一
* p[i] = Math.min(p[i-1],t[i-1])+x;
* 情况二:到达第i层的方式是跳
* 那么可以从第i-1层起跳，也可以从i-2层起跳，并且到达i-1层和i-2层的方式只能是爬，所以二者选最小的
* t[i] = Math.min(p[i-1],p[i-2]);
*
*
* */
public class Main {
    public static void main(String[] args) {
        int[] p = new int[10005];
        int[] t = new int[10005];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <=n ; i++) {
            int x = sc.nextInt();
            p[i] = Math.min(p[i-1],t[i-1]) + x;
            if(i == 1) continue;
            t[i] = Math.min(p[i-1],p[i-2]);
        }
        System.out.println(Math.min(p[n],t[n]));

    }
}
