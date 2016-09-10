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
        int c = 1;
        while (n / 10 != 0) {
            c++;
            n /= 10;
        }

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
       结果示例: reverseDigits(-8036800)返回572038
    */
    public static int reverseDigits(int n)
    {
        return 0;
    }

    //Ex06
    /**
       结果示例：round(803.505692, 4) = 8035057
    */
    public static double round(double x, int precision)
    {
        
        return 1.0;
    }
       
    
}
