package me.ifjy.swingtest;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorld
{
    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable() {
                public void run()
                {
                    NotHelloWorldFrame frame = new NotHelloWorldFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
            });
    }
}

class NotHelloWorldFrame extends JFrame
{
    public NotHelloWorldFrame()
    {
        setTitle("NotHelloWorld");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        //add panel to frame
        NotHelloWorldPanel panel = new NotHelloWorldPanel();
        add(panel);
    }

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}

class NotHelloWorldPanel extends JPanel
{
    public void paintComponent(Graphics g)
    {
        g.drawString("Not a hello world program", MESSAGE_X, MESSAGE_Y);
    }

    public static final int MESSAGE_X = 75;
    public static final int MESSAGE_Y = 100;
}
