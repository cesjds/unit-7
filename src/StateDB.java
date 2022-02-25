import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/********************************************************************
 * Written by: Yoav Amit
 *
 * ASSIGNMENT:  Write a program that reads the data from states.txt
 * into a 2-D array. Modify the print method I give you to print your
 * database. Use the answer key I've attached to this assignment.
 * The data in states.txt is in the following order:
 *		state name
 *              state capital
 *		state flower
 *		state bird
 *		state population (I think in 10 thousands)
 *
 * HAND IN:  Let me see your database print on your monitor.
 *
 *******************************************************************/

public class StateDB {
    public static void main(String[] args) {
        String[][] states = new String[50][5];
        print(states);
    }

    public static void print(String[][] states) {
        String name, capital, flower, bird, pop;
        JTextArea area = new JTextArea();
        //append column headings here
        Scanner inFile = null;
        try {
            inFile = new Scanner(new File("states.txt"));
            while(inFile.hasNext()){
                name = inFile.nextLine();
                System.out.print(name + "\t");
                capital = inFile.nextLine();
                System.out.print(capital + "\t");
                flower = inFile.nextLine();
                System.out.println(flower);
                bird = inFile.nextLine();
                pop = inFile.nextLine();

                for (int i=0; i<states.length; i++) {
                    //adjust column sizes here
                    area.append(name+capital+flower+bird+pop+"\n");
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        area.setBackground(new Color(255, 250, 205));
        area.setForeground(new Color(0, 0, 0));
        area.setFont(new Font("Consolas", Font.PLAIN, 15));
        // how many rows will show at one time
        area.setRows(35);
        // how many columns (1 char) will show at one time
        area.setColumns(115);
        JScrollPane pane = new JScrollPane(area);
        JOptionPane.showMessageDialog(null, pane);

    }

    public static void print(){
        for(int i = 0; i <50; i++){
            for(int z = 0; z < 5; z++){
        }

    }
}