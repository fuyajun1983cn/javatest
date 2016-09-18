package ex.ch02;

import java.util.Random;
import java.util.Vector;

public class ExTest
{
    public static void main(String[] args)
    {
        //Ex01
        System.out.println("-------Ex01 Test----------");
        ex01();

        //Ex08
        System.out.println("-------Ex08 Test----------");
        int[] a = new int [10];
        Arrays.load(a, 0, 10);
        Arrays.print(a);
        System.out.print("Ex08: Array a is Sorted?: " + isSorted(a));

        //Ex09
        System.out.println("-------Ex09 Test----------");
        System.out.println("数组a中最小的元素： " + minum(a));

        //Ex10
        System.out.println("-------Ex10 Test----------");
        double[] b = new double[10];
        Arrays.load(b, 0, 10);
        Arrays.print(b);
        System.out.println("数组b的平均值:  " + mean(b));

        //Ex11
        System.out.println("-------Ex11 Test----------");
        Arrays.print(withoutDuplicates(a));

        //Ex13
        System.out.println("-------Ex13 Test----------");
        int[] c = new int[11];
        Arrays.load(c, 0, 11);
        Arrays.print(c);
        reverse(c);
        Arrays.print(c);
    }

    /**
     * Ex01:
     * 测试Arrays.fill
     */
    private static void ex01()
    {
        int[] a = new int[10];
        Arrays.load(a, 0, 10);
        Arrays.print(a);
    }

    /**
     * Ex08:
     * 当且仅当：a[0] <= a[1] <= ... <= a[a.length-1]时返回真
     */
    private static boolean isSorted(int [] a)
    {
        int n = a.length;
        if (n < 2)
            return true;
        int k = a[0];
        for (int i = 1; i < n; i++) {
            if (k > a[i])
                return false;
            k = a[i];
        }
        return true;
    }

    /**
     * Ex09:
     * 返回数组中最小的元素
     */
    private static int minum(int[] a)
    {
        int n = a.length;
        int k = a[0];
        for (int i = 1; i < n; i++) {
            if (k > a[i])
                k = a[i];
        }
        return k;
    }

    /**
     * Ex10:
     * 返回数组a[]中的所有元素的平均值
     */
    private static double mean(double a[])
    {
        int n = a.length;
        double sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
        }
        return sum / n;
    }

    /**
     * Ex11:
     * 返回一个数组，该数组的元素与a[]中的相同，但没有重复元素
     */
    private static int[] withoutDuplicates(int[] a)
    {
        if (a.length < 2)
            return a;
        int x = a[0]; //using this value as a dummy marker
        for (int i = 1; i < a.length-1; i++) {
            for (int j = i + 1; j < a.length; j++)
                if (a[j] == a[i])
                    a[j] = x;
        }
        int count; //count hte duplicate
        for (int i = 1;; i < a.length; i++) {
            if (a[i] == x)
                count++;
        }
        if (count == 0)
            return a;

        int[] b = new int[a.length - count];
        b[0] = x;
        int shift = 0;
        for (int i = 1; i < a.length; i++) {
            if (shift > 0 && a[i] != x)
                b[i-shift] = a[i];
            else if (a[i] == x)
                ++shift;
            else
                b[i] = a[i];
        }
        return b;
    }

    /**
     * Ex13:
     * 将数组倒序
     */
    private static void reverse(int[] a)
    {
        int n = a.length;
        for (int i = 0; i < n/2; i++) {
            int tmp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 -i] = tmp;
        }
    }
    
}

class Arrays
{
    private static Random random = new Random();

    public static int load(int start, int range)
    {
        return random.nextInt(range) + start;
    }

    public static void load(int[] a, int start, int range)
    {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(range) + start;
        }
    }

    public static void print(int[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + (i > 9? "":" ") + i);
        }
        System.out.print("\n{ " + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println(" }");
    }

    public static void load(double[] a, int start, int range)
    {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(range) + start;
        }
    }

    public static void print(double[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + (i > 9? "":" ") + i);
        }
        System.out.print("\n{ " + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println(" }");
    }

    public static void load(Object[] a, int start, int range)
    {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int m = random.nextInt(range) + start;
            if (i%3 == 0)
                a[i] = new Integer(m);
            else if (i%3 == 1)
                a[i] = new Double(m);
            else
                a[i] = "(" + m + ")";
        }
    }

    public static void print(Object[] a)
    {
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + (i > 9? "":" ") + i);
        }
        System.out.print("\n{ " + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println(" }");
    }

    public static void print(Object[] a, String label)
    {
        System.out.print(label + " = ");
        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + (i > 9? "":" ") + i);
        }
        System.out.print("\n{ " + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println(" }");
    }

    public static void swap(int[] a, int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void swap(Object[] a, int i, int j)
    {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    
}
