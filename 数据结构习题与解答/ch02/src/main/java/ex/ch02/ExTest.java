/**
 * Copyright (c)  2016     Yajun Fu (fuyajun1983cn@163.com)
 * 
 * Permission to use, copy, modify, and/or distribute this software for any
 * purpose with or without fee is hereby granted, provided that the above
 * copyright notice and this permission notice appear in all copies.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS" AND THE AUTHOR DISCLAIMS ALL WARRANTIES
 * WITH REGARD TO THIS SOFTWARE INCLUDING ALL IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS. IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR
 * ANY SPECIAL, DIRECT, INDIRECT, OR CONSEQUENTIAL DAMAGES OR ANY DAMAGES
 * WHATSOEVER RESULTING FROM LOSS OF USE, DATA OR PROFITS, WHETHER IN AN
 * ACTION OF CONTRACT, NEGLIGENCE OR OTHER TORTIOUS ACTION, ARISING OUT OF
 * OR IN CONNECTION WITH THE USE OR PERFORMANCE OF THIS SOFTWARE.
 */

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

        //Ex14
        System.out.println("-------Ex14 Test----------");
        Object[] d = new Object[10];
        Arrays.load(d, 0, 10);
        Arrays.print(d);
        Object[] e = new Object[5];
        Arrays.load(e, 0, 5);
        Arrays.print(e);
        Arrays.print(concatenate(d,e));

        System.out.println("-------Ex15 Test----------");
        Object[] f = new Object[10];
        Arrays.load(f, 34, 65);
        Arrays.print(f, "f");
        shuffle(f);
        Arrays.print(f, "f");

        System.out.println("--------Ex16 Test----------");
        int r[] = tally("thissfadsfsfwfwefsdfsfsf");
        for (int i = 0;i < 26; i++) {
            System.out.println("Frequency of " + (char)('a' + i) + " = " + r[i]);
        }
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
        int count = 0; //count hte duplicate
        for (int i = 1; i < a.length; i++) {
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
    private static void reverse(int[ ] a)
    {
        int n = a.length;
        for (int i = 0; i < n/2; i++) {
            int tmp = a[i];
            a[i] = a[n - 1 - i];
            a[n - 1 -i] = tmp;
        }
    }

    /**
     * Ex14:
     * 返回一个数组，该数组中的成份的前部分与数组a[]中相同，后面部分与数组b[]中相同。
     */
    private static Object[] concatenate(Object a[ ], Object b[ ])
    {
        if (a == null && b == null)
            return null;
        if (a == null && b != null)
            return b;
        if (a != null && b == null)
            return a;

        Object[] result = new Object[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);

        return result;
   }

    /**
     * Ex15:
     * 对数组的成份进行随机性序列调整
     */
    private static void shuffle(Object [] a)
    {
        if (a == null)
            return;
        Random r = new Random();
        int n = a.length;
        for (int i = 0;i < n; i++) {
            Arrays.swap(a, i, r.nextInt(a.length));
        }
    }

    /**
     * Ex16:
     * 返回一个26个整数值的数组a，该数组记录了字符串string中各个字母（不区分大小写）的
     * 出现频率。
     */
    private static int[] tally(String string)
    {
        int[] a = new int[26];
        for (int i =0; i < 26; i++)
            a[i] = 0;

        for (int i = 0; i < string.length(); i++) {
            char c = Character.toLowerCase(string.charAt(i));
            if (Character.isLetter(c))
                ++a[(int)c - (int)'a'];

        }
        
        return a;
    }

    /**
     * Ex17:
     * 两个向量的内积
     */
    private static double innerProduct(double[] x, double[] y)
    {
        if (x.length != y.length)
            return 0;
        double result = 0;
        for (int i = 0; i < x.length; i++) {
            result += x[i] * y[i];
        }
        return result;
    }

    /**
     * Ex18:
     * 两个向量的外积
     *
     */
    private static double[][] outerProduct(double[] x, double[] y)
    {
        double[][] z = new double[x.length][y.length];
        for (int i = 0; i < x.length; i++)
            for (int j = 0; j < y.length; j++)
                z[i][j] = x[i] * y[j];
        return z;
    }

    /**
     * Ex19
     *将两个数组看成是矩阵，该方法返回两矩阵的乘积
     */
    private static double[][] product(double[][] a, double[][] b)
    {
        //a的列数与b的行数相同
        if (a[0].length != b.length) {
            System.out.println("Cannot compute product for the two array");
            return null;
        }
            
        double[][] p = new double[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                p[i][j] = 0.0;
                for (int k = 0; k < a[0].length; k++)
                    p[i][j] += a[i][k]*a[k][j];
            }
        }
        return p;
    }

    /**
     * Ex20
     * 把数组看成矩阵，计算矩阵的转置
     */
    private static double[][] transpose(double[][] a)
    {
        double[][] result = new double[a[0].length][a.length];
        for (int i = 0; i < a[0].length; i++)
            for (int j = 0; j < a.length; j++) {
                result[i][j] = a[j][i];
            }
        return result;
    }

    /**
     * Ex21
     * 返回给定大小的帕斯卡三角形(杨辉三角)
     */
    private static int[][] pascal(int size)
    {
        int result[][] = new int[size][size];
        //每行第一个和最后一个元素都是1
        for (int j = 0; j < size; j++)
            result[j][0] = result[j][j] = 1;
        for (int i = 2; i < size; i++)
            for (int j = 2; j < i; j++)
                result[i][j] = result[i-1][j-1] + result[i-1][j];
        return result;
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
