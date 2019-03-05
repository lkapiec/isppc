package eu.lenic.isppc.app;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.PropertyResourceBundle;
import java.util.Map.Entry;
import java.util.Properties;

//import javajs.util.PT;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class Gui extends JPanel {

    public GraphicsConfiguration gc;

    public Gui(String...args) {


        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFrame isppcFrame;

        isppcFrame = new JFrame();

    //    isppcFrame.getContentPane().add("St", this);


        isppcFrame.setTitle("ISP Programmer clone");
        isppcFrame.setSize(600, 450);
        isppcFrame.setLocation(100, 150);


        isppcFrame.setDefaultLookAndFeelDecorated(true);
        JLabel labelM = new JLabel("Created by Adam Dybkowski");
        labelM.setBounds(50, 50, 200, 30);

        labelM.setForeground(Color.BLUE);

       // label1.



        //isppcFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        isppcFrame.getContentPane().setBackground(Color.lightGray);
        // isppcFrame.getContentPane().setLayout(new BorderLayout());


        JPanel jPanel = new JPanel();
        //szwe, wyxz
        jPanel.setPreferredSize(new Dimension(100,10));


        //add a button.
        JButton resetOnButton = new JButton("Reset ON");
        resetOnButton.setBounds(0,0,20,30);

        //add button to the frame.
        jPanel.add(resetOnButton, BorderLayout.WEST);

        //add a button.
        JButton resetOffButton = new JButton("Reset OFF");
        //add button to the frame.
        jPanel.add(resetOffButton, BorderLayout.SOUTH);

        //add a button.
        JButton restartButton = new JButton("Restart");
        //add button to the frame.
        jPanel.add(restartButton, BorderLayout.SOUTH);

        //add a button.
        JButton readSignatureButton = new JButton("Read signature");
        //add button to the frame.
        jPanel.add(readSignatureButton, BorderLayout.SOUTH);

        JLabel label1 = new JLabel("Created by Adam Dybkowski '1999-2011");
        //label1.setBounds(50, 50, 20, 30);

        jPanel.add(label1);


        //add a button.
        JButton eraseButton = new JButton("Erase");
        //add button to the frame.
        jPanel.add(eraseButton, BorderLayout.SOUTH);

        //add a button.
        JButton setupButton = new JButton("Setup");
        //add button to the frame.
        jPanel.add(setupButton, BorderLayout.SOUTH);




        isppcFrame.getContentPane().add(jPanel, BorderLayout.WEST);
        //setBorder(BorderFactory.createEtchedBorder());
        setLayout(new BorderLayout());

        resetOffButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                label1.setText("Name has been submitted.");
                //System.exit(0);
            }
        });


        isppcFrame.setVisible(true);


        String vers = System.getProperty("java.version");
        if (vers.compareTo("1.1.2") < 0) {
            System.out.println("!!!WARNING: Swing components require a "
                    + "1.1.2 or higher version VM!!!");
        }



        System.out.println("tst");

        Delays delay = new Delays();

        delay.Tic(0);

        delay.WaitMS(500);
        System.out.println("upłyną czas " + delay.TicMS(0) + " [US]");

    }

    public void startGui()
    {

    }


    }
