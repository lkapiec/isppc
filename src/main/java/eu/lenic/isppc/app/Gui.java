package eu.lenic.isppc.app;

import eu.lenic.isppc.Delays;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//import javajs.util.PT;

import javax.swing.*;
import java.awt.GraphicsConfiguration;
import javax.swing.JFrame;

public class Gui extends JPanel {

    public GraphicsConfiguration gc;
    private JFrame isppcFrame;

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

        isppcFrame = new JFrame();

        isppcFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosed(java.awt.event.WindowEvent windowEvent) {
                System.out.println("Zamkniecie aplikacji");
                System.exit(0);
            }
        });

    //    isppcFrame.getContentPane().add("St", this);


        isppcFrame.setTitle("ISP Programmer clone");
        isppcFrame.setSize(600, 450);
        isppcFrame.setLocation(100, 150);


        isppcFrame.setDefaultLookAndFeelDecorated(true);
        JLabel labelM = new JLabel("Created by Adam Dybkowski");
        labelM.setBounds(50, 50, 200, 30);

        labelM.setForeground(Color.BLUE);

       // label1.

        isppcFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        isppcFrame.getContentPane().setBackground(Color.lightGray);
        // isppcFrame.getContentPane().setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();
        jPanel.setBackground(new Color(0xdddddd));
        //szwe, wyxz
        jPanel.setPreferredSize(new Dimension(200,290));


        jPanel.setLayout(new BoxLayout(jPanel,
                BoxLayout.Y_AXIS));

        //add a button.
        JButton resetOnButton = new JButton("Reset ON");
       // resetOnButton.setBounds(0,0,40,30);

        //add button to the frame.
        jPanel.add(resetOnButton, BorderLayout.WEST);

        //add a button.
        JButton resetOffButton = new JButton("Reset OFF");
        //add button to the frame.
        jPanel.add(resetOffButton, BorderLayout.CENTER);

        //add a button.
        JButton restartButton = new JButton("Restart");
        //add button to the frame.
        jPanel.add(restartButton, BorderLayout.SOUTH);

        //add a button.
        JButton readSignatureButton = new JButton("Read signature");
        //add button to the frame.
        jPanel.add(readSignatureButton, BorderLayout.CENTER);

        JLabel label1 = new JLabel("Created by Adam Dybkowski '1999-2011");
        JTextArea jtA = new JTextArea("Created by Adam Dybkowski '1999-2011");

        //label1.setBounds(50, 50, 20, 30);
        label1.setForeground(Color.BLUE);
        jtA.setForeground(Color.BLUE);
        jtA.setLineWrap(true);
        jtA.setBackground(Color.lightGray);
        //label1.set

        jPanel.add(jtA);


        //add a button.
        JButton eraseButton = new JButton("Erase");
        //add button to the frame.
        jPanel.add(eraseButton, BorderLayout.SOUTH);

        JSeparator sep = new JSeparator(SwingConstants.HORIZONTAL/*JSeparator.HORIZONTAL*/);

        //sep.setPreferredSize(new Dimension(0,50));

        jPanel.add(sep
        //        ,BorderLayout.LINE_START
        );

        //add a button.
        JButton setupButton = new JButton("Setup");
        //add button to the frame.
        jPanel.add(setupButton, BorderLayout.SOUTH);

        //...
////Where the GUI is constructed:
        JProgressBar progressBar = new JProgressBar();
        progressBar.setMaximum(100);
        progressBar.setMinimum(0);
        progressBar.setValue(58);
        progressBar.setString("ooiioo");
        progressBar.setStringPainted(true);
        progressBar.setOrientation(JProgressBar.HORIZONTAL);

        isppcFrame.getContentPane().add(jPanel, BorderLayout.WEST);
        isppcFrame.getContentPane().add(progressBar, BorderLayout.SOUTH);
        //setBorder(BorderFactory.createEtchedBorder());
        setLayout(new BorderLayout());


        //jPanel.add(progressBar);

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
