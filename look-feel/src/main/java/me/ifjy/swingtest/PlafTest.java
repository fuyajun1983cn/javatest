package me.ifjy.swingtest;

import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.*;

public class PlafTest
{
    public static void main(String args[])
    {
        EventQueue.invokeLater(new Runnable() {
                public void run()
                {
                    PlafFrame frame = new PlafFrame();
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setVisible(true);
                }
            });
    }
}

class PlafFrame extends JFrame
{
    public PlafFrame()
    {
        setTitle("PlafTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        buttonPanel = new JPanel();

        UIManager.LookAndFeelInfo[] infos = UIManager.getInstalledLookAndFeels();
        for (UIManager.LookAndFeelInfo info : infos) {
            makeButton(info.getName(), info.getClassName());
        }

        add(buttonPanel);
    }

    void makeButton(String name, final String plafName)
    {
        JButton button = new JButton(name);
        buttonPanel.add(button);

        button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent event)
                {
                    try
                        {
                            UIManager.setLookAndFeel(plafName);
                            SwingUtilities.updateComponentTreeUI(PlafFrame.this);
                        }
                    catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                }
            });
    }

    private JPanel buttonPanel;

    public static final int DEFAULT_WIDTH = 300;
    public static final int DEFAULT_HEIGHT = 200;
}

