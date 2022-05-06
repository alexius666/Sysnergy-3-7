package java_synergy.Philosophers;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PhilThreadRunner {
    public static void main(String[] args) {
//        int person = 5; // Количество философов

        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500,300);
        frame.setSize(400,400);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.DARK_GRAY);

        JLabel labelTable = new JLabel();
        labelTable.setForeground(Color.GREEN);

        labelTable.setText("Вилки на столе:");

        labelTable.setBounds(3,3,100,10);
        JLabel label1 = new JLabel();
        label1.setForeground(Color.GREEN);
        label1.setBounds(3,50,100,10);
        JLabel label2 = new JLabel();
        label2.setForeground(Color.GREEN);
        label2.setBounds(3,100,100,10);
        JLabel label3 = new JLabel();
        label3.setForeground(Color.GREEN);
        label3.setBounds(3,150,100,10);
        JLabel label4 = new JLabel();
        label4.setForeground(Color.GREEN);
        label4.setBounds(3,200,100,10);
        JLabel label5 = new JLabel();
        label5.setForeground(Color.GREEN);
        label5.setBounds(3,250,100,10);

        label1.setText("Филосов #1: ");
        label2.setText("Филосов #2: ");
        label3.setText("Филосов #3: ");
        label4.setText("Филосов #4: ");
        label5.setText("Филосов #5: ");

        frame.add(labelTable);
        frame.add(label1);
        frame.add(label2);
        frame.add(label3);
        frame.add(label4);
        frame.add(label5);



//        HashMap<Integer,Boolean> fork = new HashMap<>();
//        for (int i = 0; i < person; i++) {
//            fork.put(i,true);
//        }
//
//        fork.forEach((k,v)->{
//            System.out.format("fork #%s on the table - %s%n",k+1, v);
//        });

        var philosopher = new ArrayList<Thread>();
        Status status = new Status();
        status.putAllFork();

        philosopher.add(new Thread(new Philosopher(1,5,status))); // понятно для чего Runnable
        philosopher.add(new Thread(new Philosopher(2,1,status)));
        philosopher.add(new Thread(new Philosopher(3,2,status)));
        philosopher.add(new Thread(new Philosopher(4,3,status)));
        philosopher.add(new Thread(new Philosopher(5,4,status)));
        philosopher.forEach(Thread::start);
        System.out.println(philosopher);
        //System.out.println("finished "+Thread.currentThread().getName());
    }
}
