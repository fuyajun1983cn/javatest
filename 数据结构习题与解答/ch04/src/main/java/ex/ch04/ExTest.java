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

package ex.ch04;

public class ExTest {
    public static void main(String args[])
    {
        //Test01
        System.out.println(sumOfSquares(2));

        //Test02
        System.out.println(sumOfPower(2, 4));

        //Test03&test04
        {
            int []a = { 2, 3, 5, 1, 6, 9};
            System.out.println(test03(a, 8));
            System.out.println(test04(a, 3));
            System.out.println(test05(a, 3));
        }

        //test09
        {
            System.out.println(test09("abcxba"));
            //System.out.println(new String("aba").substring(1, 2));
        }

        //test10
        {
            System.out.println(dec2bin(-5));
            System.out.println(dec2hex(-3));
        }

        //test12
        {
            test12("ABC");
        }
    }

    //Ex01
    /**
     * 返回前n个整数的平方和
     */
    private static int sumOfSquares(int n)
    {
        if (n == 0)
            return 0;
        return n * n + sumOfSquares(n - 1);
    }

    /**
     * Ex02
     * 返回b的1到n次幂的和
     */
    private static double sumOfPower(int b, int n)
    {
        if (n == 0)
            return 1;
        return 1 + b * sumOfPower(b, n - 1);
    }

    /**
     * Ex03
     * 返回数组前n个元素中最大元素的递归函数
     */
    private static int test03(int a[], int n)
    {
        if (n > a.length)
            n = a.length;
        if (n == 1)
            return a[0];
       
        int tmp = test03(a, n - 1);
        return a[n - 1] > tmp ? a[n - 1] : tmp;
    }

    /**
     * Ex04
     * 返回数组前n个元素的和的递归函数
     */
    private static int test04(int a[], int n)
    {
        if (n > a.length)
            n = a.length;
        if (n == 0)
            return 0;
        return a[n-1] + test04(a, n-1);
    }

    /**
     * Ex05
     * 返回数组前n个元素中的最大元素，要求复杂度为lgn
     */
    private static int test05_impl(int a[], int low, int high)
    {
        if (low > high)
            return -1;
        int mid = (low +high)/2;
        int left = test05_impl(a, low, mid - 1);
        int right = test05_impl(a, mid + 1, high);

        int max = a[mid-1];
        if (right > max && right > left)
            max = right;
        if (left > max && left > right)
            max = left;
   
        return max;
    }

    private static int test05(int a[], int n)
    {
        if (n > a.length)
            n = a.length;
        return test05_impl(a, 1, n);
    }

    private static double max(double[] a, int n)
    {
        if (n == 1)
            return a[0];
        int n1 = n/2;
        int n2 = n - n1;
        double m1 = max(a, n1);
        double m2 = max(a+n1, n2);
        return m1 > m2 ? m1 : m2;
    }

    /**
     * Ex06
     * 返回x的n次幂
     */
    private static int test06(int x, int n)
    {
        if (n == 0)
            return 1;
        return x * test06(x, n - 1);
    }
    //Ex07
    private static int test06_2(int x, int n)
    {
        if (n == 0)
            return 1;
        if (n % 2 == 0)
            return test06_2(x, n/2) * test06_2(x, n/2);
        else
            return x * test06_2(x, n/2) * test06_2(x, n/2);
    }

    /**
     * Ex09
     * 判断一个字符串是否为一个回文字符串。
     */
    private static boolean test09(String str)
    {
        if (str == null || str.length() == 1)
            return true;
        else if (str.length() == 2)
            return true;
        else if (str.charAt(0) == str.charAt(str.length() - 1))
            return test09(str.substring(1, str.length() - 1));
        else
            return false;
    }

    /**
     * Ex10
     * 将十进制整数转换为二进制表示
     */
    private static String binary(int n)
    {
        String s = "" + n%2;
        if (n < 2)
            return s;  //basic case
        return binary(n/2) + s;
    }
    
    private static String dec2bin(int n)
    {
        if (n == 0)
            return "0";
        if (n > 0)
            return "0" + unsignedToBinary(n);
        else {
            //负数转化为二进制可以转化为
            //对求等同的正数的运算。
            int mod = 1;
            while (mod + 2*n < 0)
                mod *= 2;
            return unsignedToBinary(mod + n);
        }
    }

    public static String unsignedToBinary(int n)
    {
        if (n < 0) {
            return " 输入非法!";
        }
        if (n == 0)
            return "";
        return "" + n%2 + unsignedToBinary(n/2);
    }

    /**
     * Ex11
     * 将十进制数转换为十六进制表示的字符串
     */
    public static String dec2hex(int n)
    {
        if (n == 0)
            return "0";
        if ( n > 0)
            return unsignedToHex(n);
         else {
            //负数转化为十六进制可以转化为
            //对求等同的正数的运算。
            int mod = 1;
            while (mod + 16*n < 0)
                mod *= 16;
            return unsignedToHex(mod + n);
        }
    }

    public static String unsignedToHex(int n)
    {
        String alphbet = "0123456789ABCDEF";
        if (n < 0)
            return "输入非法";
        if (n == 0)
            return "";
        return "" + unsignedToHex(n/16) + alphbet.charAt(n%16) ;
    }

    /**
     * Ex12
     * 打印字符串中前n个字符的所有置换
     */
    private static void test12(String str)
    {
        permuate("", str);
    }

    //sofar: output, rest: input
    private static void permuate(String sofar, String rest)
    {
        if (rest.length() == 0) {
            System.out.println(sofar);
            return;
        }

        for (int i = 0; i < rest.length(); i++) {
            String next = sofar + rest.charAt(i);
            String remaing = rest.substring(0, i) + rest.substring(i+1);
            permuate(next, remaing);
        }
    }

}
