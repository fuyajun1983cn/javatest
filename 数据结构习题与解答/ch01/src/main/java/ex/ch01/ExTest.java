/**
 * 
 * Copyright (c)  2016 Yajun Fu (fuyajun1983cn@163.com)
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


package ex.ch01;

public class ExTest {
    public static void main(String args[]) {
        //测试

        //ex01
        System.out.println(ExTest.monthName(2));

        //ex02
        System.out.println(ExTest.daysInMonth(2, 2000));

        //ex03
        System.out.println(ExTest.numberOfDigits(-8036800));

        //ex04
        System.out.println(ExTest.sumOfDigits(-8036800));

        //ex05
        System.out.println("Ex05: " + ExTest.reverseDigits(-8036800));

        //ex06
        System.out.println(ExTest.round(803.50592, 4));

        //ex07
        System.out.println(ExTest.signedToBinary(-5));

        //ex08
        System.out.println(ExTest.binaryToSigned("010100001001"));
        System.out.println(ExTest.binaryToSigned("101011110111"));
		
        //ex11
        System.out.println(ExTest.format("tomato", 9, 1));
		
        //ex12
        System.out.println(ExTest.randomInt(-1, 7));
    }

    //Ex1.1
    /**
       前提条件： 0 < month < 13
       结果示例： monthName(2)返回"二月"
    */
    public static String monthName(int month)
    {
        if (month < 0 || month > 12)
            return  "非法输入";
        else {
            switch (month) {
            case 1:
                return "一月";
            case 2:
                return "二月";
            case 3:
                return "三月";
            case 4:
                return "四月";
            case 5:
                return "五月";
            case 6:
                return "六月";
            case 7:
                return "七月";
            case 8:
                return "八月";
            case 9:
                return "九月";
            case 10:
                return "十月";
            case 11:
                return "十一月";
            case 12:
                return "十二月";
            default:
                break;
            }
        }
        return "";
    }

    //EX02
    /**
       前提条件： 0 < month < 13
       结果示例： daysInMonth(2, 2000)返回29
    */
    public static int daysInMonth(int month, int year)
    {
        int days []  = {
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month< 0 || month > 12)
            return -1;
        //判断是否为闰年
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            if (month == 2)
                return days[1] + 1;
        return days[month-1];
    }

    //Ex03
    /**
       结果示例： numberOfDigits(-8036800)返回7
    */
    public static int numberOfDigits(int n)
    {
        int c = 0;
        while (n / 10 != 0) {
            c++;
            n /= 10;
        }
        c++;

        return c;
    }


    //Ex04
    /**
       结果示例：sumOfDigits(-8036800)返回25
    */
    public static int sumOfDigits(int n)
    {
        int sum = 0;
        if (n < 0)
            n = -n;
        while (n / 10 != 0) {
            sum += n % 10;
            n /= 10;
        }
        sum += n;
        return sum;
    }

    //Ex05
    /**
       结果示例: reverseDigits(-8036800)返回-80386
    */
    public static int reverseDigits(int n)
    {
        if (n == 0)
            return 0;
        int sign = n < 0? -1: 1;
        if (n < 0)
            n = -n;
        int reverse= 0;
        while (n > 0) {
            reverse = 10 * reverse + n%10;
            n /= 10;
        }
        
        return sign * reverse;
    }

    //Ex06
    /**
       结果示例：round(803.505692, 4) = 8035057
    */
    public static double round(double x, int precision)
    {
        boolean carry= false;
        x *= Math.pow(10, precision);
        String str_x = String.valueOf(x);
        int index = str_x.lastIndexOf('.');
        if (index != -1) {
            char c = str_x.charAt(index+1);
            if (c >= '5') {
                carry = true;
            }
        }

        str_x = str_x.substring(0, index);
        System.out.println(str_x);
        
        if (carry)
            return (Double.parseDouble(str_x) + 1) / Math.pow(10, precision);
        else
            return (Double.parseDouble(str_x)) /Math.pow(10, precision);
     
    }

    public static double round2(double x, int precision)
    {
        double pow10 = Math.pow(10, precision);
        return Math.round(x * pow10) / pow10;
    }

    /**
     * Ex07
     * 结果示例： signedToBinary(1289) 返回“010100001001”
     *                       signedToBinary(-1289) 返回 "101011110111"
     * 负数： 反码 + 符号位
     */
    public static String signedToBinary(int n)
    {
        if (n == 0)
            return "0";
        if (n > 0)
            return "0" + unsignedToBinary(n);
        //负数转化为二进制可以转化为
        //对求等同的正数的运算。
        int mod = 1;
        while (mod + 2*n < 0)
            mod *= 2;
        return unsignedToBinary(mod + n);
    }
    
    public static String signedToBinary2(int n)
    {
        String tempStr = "";
        String result = n > 0? "0" : "1";
        boolean signed = n < 0? true: false;
        n = n > 0? n : -n;
        do {
            if (n%2 == 1)
                tempStr += "1";
            else
                tempStr += "0";
            n /= 2;
        } while (n !=0);

        for (int i = tempStr.length() - 1; i >= 0; i--) {
            if (signed) {
                if (i == 0) {
                    result += tempStr.charAt(i);
                    break;
                }
                if (tempStr.charAt(i) == '0')
                    result += '1';
                else
                    result += '0';
            } else
                result += tempStr.charAt(i);
        }

        return result;
        
    }

    /**
     * Ex08
     * 前提条件：n > 0
     *结果示例：unsignedToBinary(1289), 返回"010100001001"
     */
    public static String unsignedToBinary(int n)
    {
        if (n < 0) {
            return " 输入非法!";
        }
        String code = "";
        while (n > 0) {
            code = "" + (n%2) + code; //append next bit to the left of the code
            n /= 2;
        }
        return code;
    }

    /**
     * Ex09
     * 前提条件： Code中每个字符要么是'0', 要么是‘1’：
     *                       Code.length <= 32
     *结果示例：binaryToSigned("010100001001") 返回1289
     *                    binaryToSigned("1010111101111")返回-1289
     */
    public static int binaryToSigned(String code)
    {
        int len = code.length();
        int unsigned = binaryToUnsigned(code);
        if (code.charAt(0) == '0')
            return unsigned;
        return unsigned - (int)Math.pow(2, len);
    }
    public static int binaryToSigned2(String code)
    {
        if (code.length() > 32)
            return -1;

        int result = 0;
        char[] chrs = code.toCharArray();
        int len = code.length();
        boolean signed  = chrs[0] == '1' ? true:false;
        for (int i = 1; i < len; i++) {
            if (signed) {
                if (chrs[i] == '0')
                    result += Math.pow(2, len-1-i);
            } else {
                if (chrs[i] == '1')
                    result += Math.pow(2, len-1-i);
            }
        }
        if (signed) {
            result -= 1;
            result = -result;
        }

        return result;
    }

    /**
     * Ex10: 
     */
    public static int binaryToUnsigned(String code)
    {
        int n = code.length();
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer = answer*2 + (code.charAt(i) == '1' ? 1 : 0);
        }
        return answer;
    }
     
    /**
     * Ex11:
     * 结果示例：
     *  		format("tomato", 9, d), 当d为-1，0，1时将分别返回
     *			"tomato  ", "  tomato  ", "   tomato"
     */
    public static String format(String s, int len, int d)
    {
        if (s.length() >= len) {
            return s.substring(0, len);
        }
		 
        String result = s;
		 
        switch (d) {
        case -1://左对齐
            for (int i = 0; i < len - s.length(); i++) {
                result += " ";
            }
            break;
        case 0://中间对齐
            {
                int i = 0; 
                for (; i < (len - s.length())/2; i++) {
                    result = " " + result;
                }
				 
                for (i = (len - s.length())/2; i < len - s.length(); i++)
                    result += " ";
            }
            break;
        case 1://右对齐
            for (int i = 0; i < len - s.length(); i++)
                result = " " + result;
            break;
        }
        return result;
    }
	 
    /**
     * Ex12:
     * 	前提条件：start < stop
     *		返回位于[start, stop-1]区间中均匀分布的整型数
     */
    public static int randomInt(int start, int stop)
    {
        if (start >= stop) {
            System.err.println("非法输入！！！");
            return -1;
        }
		  
        return (int)(start + (stop - start) * Math.random());
    }
}

class Point
{
    protected double x,y;

    //Ex14: 原点
    public static final Point origin = new Point(0,0);
	
    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * Ex15
     * 拷贝构造函数
     */
    public Point(Point point)
    {
        x = point.getX();
        y = point.getY();
    }
	
    /**
     * Ex13:
     *      Point的缺省构造函数
     */
    public Point()
    {
        x = 0;
        y = 0;
    }
	
    public double getX()
    {
        return x;
    }
	
    public double getY()
    {
        return y;
    }
	
    public Point getLocation()
    {
        return new Point(x, y);
    }
	
    public void setLocation(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
	
    public void translate(double dx, double dy)
    {
        x += dx;
        y += dy;
    }
	
    public boolean equals(Object object)
    {
        if (object == this)
            return true;
		
        if (object.getClass() != this.getClass())
            return false;
		
        Point point = (Point)object;
        return x == point.x && y == point.y;
    }
	
    public int hashCode()
    {
        return new Double(x).hashCode() + new Double(y).hashCode();
    }
	
    public String toString()
    {
        return new String("(" + (float)x + ", " + (float)y + " )");
    }

    /**
     * Ex16:
     *          返回该对象与指定Point对象间的欧几里德距离
     */
    public double distance(Point point)
    {
        double dx = x - point.getX();
        double dy = x - point.y;
        return Math.sqrt (dx * dx + dy * dy);
    }

    /**
     * Ex17:
     * 返回该对象与原点之间的欧几里德距离
     */
    public double magnitude()
    {
        return Math.sqrt(x*x + y*y);
    }

    /**
     * Ex18:
     * 返回该点的极坐标角弧度
     */
    public double amplitude()
    {
        double r = Math.atan(y/x);
        return r;
    }

    /**
     * Ex19
     * 将该点移到指定的极坐标
     */
    public void setPolar(double r, double theta)
    {
        x = r * Math.cos(theta);
        y = r * Math.sin(theta);
    }

    /**
     * Ex20
     * 返回极坐标(r,thera)的点对象
     */
    public  static Point polar(double r, double theta)
    {
        double x = r * Math.cos(theta);
        double y = r * Math.sin(theta);
        return new Point(x, y);
    }

    /**
     * Ex21
     * 将该点放大dr倍
     */
    public void expand(double dr)
    {
        x *= dr;
        y *= dr;
    }

    /**
     * Ex22
     * 将该点顺时针方向旋转thera弧度
     */
    public void rotate(double theta)
    {
        double xx = x;
        double yy = y;

        double sin = Math.sin(theta);
        double cos = Math.cos(theta);

        x = xx * cos - yy * sin;
        y = xx * sin + yy * cos;
    }
    
     
}

