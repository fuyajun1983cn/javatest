package me.ifjy.niotest;
import java.io.*;
import java.util.*;

class TextFileTest
{
    public static void main(String args[])
    {
        Employee[] staff = new Employee[3];
        staff[0] = new Employee("Carl Cracker", 75000, 1987, 12, 15);
        staff[1] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee("Tony Tester", 40000, 1990, 3, 15);

        try
            {
                //save all employee records to the file employee.dat
                PrintWriter out = new PrintWriter("employee.dat");
                writeData(staff, out);
                out.close();

                Scanner in = new Scanner(new FileReader("employee.dat"));
                Employee[] newStaff = readData(in);
                in.close();

                //print the newly read employee records
                for (Employee e: newStaff)
                    System.out.println(e);
            }
        catch (IOException exception)
            {
                exception.printStackTrace();
            }
    }

    private static void writeData(Employee[] Employees, PrintWriter out) throws IOException
    {
        out.println(Employees.length);

        for (Employee e: Employees)
            e.writeData(out);
    }

    private static Employee[] readData(Scanner in) throws IOException
    {
        int n = in.nextInt();
        in.nextLine();

        Employee[] employees = new Employee[n];
        for (int i = 0; i < n; i++) {
            employees[i] = new Employee();
            employees[i].readData(in);
        }

        return employees;
    }
}

class Employee
{
    public Employee()
    {
        
    }

    public Employee(String n, double s, int year, int month, int day)
    {
        name = n;
        salary = s;
        GregorianCalendar calendar = new GregorianCalendar(year, month-1, day);
        hireDay = calendar.getTime();
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    public Date getHireDay()
    {
        return hireDay;
    }

    public void raiseSalary(double byPercent)
    {
        double raise = salary * byPercent / 100;
        salary += raise;
    }

    public String toString()
    {
        return getClass().getName() + "[name=]" + name + ",salary=" + salary + ",hireDay=" + hireDay + "]";
    }

    public void writeData(PrintWriter out)
    {
        GregorianCalendar calendar = new GregorianCalendar();
        calendar.setTime(hireDay);
        out.println(name + "|" + salary + "|" + calendar.get(Calendar.YEAR) + "|" + (calendar.get(Calendar.MONTH) + 1) + "|" + calendar.get(Calendar.DAY_OF_MONTH));
    }

    public void readData(Scanner in)
    {
        String line = in.nextLine();
        String[] tokens = line.split("\\|");
        name = tokens[0];
        salary = Double.parseDouble(tokens[1]);
        int y = Integer.parseInt(tokens[2]);
        int m = Integer.parseInt(tokens[3]);
        int d = Integer.parseInt(tokens[4]);
        GregorianCalendar calendar = new GregorianCalendar(y, m-1, d);
        hireDay = calendar.getTime();
    }

    private String name;
    private double salary;
    private Date hireDay;
}
