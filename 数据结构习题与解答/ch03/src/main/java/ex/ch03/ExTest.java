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

package ex.ch03;

public class ExTest {
    public static void main(String args[])
    {
        
    }
}

class Point {
    protected double x, y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
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
        if (object.hashCode() != this.hashCode())
            return false;
        Point point = (Point)object;
        if (point == null)
            return false;
        return x == point.getX() && y == point.getY();
    }

    public int hashCode()
    {
        return new Double(x).hashCode() + new Double(y).hashCode();
    }

    public String toString()
    {
        return new String("(" + x + " ," + y + ")");
    }
}

class Point3D extends Point {
    protected double z;
    public static final Point3D ORIGIN = new Point3D();

    public Point3D()
    {
        super(0, 0);
        z = 0;
    }
    public Point3D(double x, double y, double z)
    {
        super(x, y);
        this.z = z;
    }

    public Point3D(double x, double y)
    {
        super(x, y);
        z = 0.0;
    }

    public Point3D(Point3D q)
    {
        x = q.x;
        y = q.y;
        z = q.z;
    }

    public double getZ()
    {
        return z;
    }

    public void setLocation(double x, double y, double z)
    {
        super.setLocation(x, y);
        this.z = z;
    }

    public void translate(double dx, double dy, double dz)
    {
        super.translate(dx, dy);
        this.z += dz;
    }

    public boolean equals(Object object)
    {
        if (object == this)
            return true;
        if (object.getClass() != this.getClass())
            return false;
        if (object.hashCode() != this.hashCode())
            return false;
        Point3D point = (Point3D)object;
        if (point == null)
            return false;
        return x == point.x && y == point.y && z == point.z;
    }

    public int hashCode()
    {
        return super.hashCode() + new Double(z).hashCode();
    }

    public String toString()
    {
        return new String("(" + x + ", " + y + ", " + z + ")");
    }

    public double magnitude()
    {
        distance(ORIGIN);
    }

    public void expand(double dr)
    {
        x *= dr;
        y *= dr;
        z *= dr;
    }

    public double distance(Point3D point)
    {
        double dx = point.x - x;
        double dy = point.y - y;
        double dz = point.z - z;
        return Math.sqrt(dx*dx + dy*dy + dz*dz);
    }
}
