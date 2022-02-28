import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/********************************************************************
 * Written by: Yoav
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

public class StateDB
{
    public static void main(String[] args) {
        String states[][] = new String[50][5];
        print(states);
    }

    public static void print(String[][] states)
    {
        JTextArea area = new JTextArea();
        //append column headings here
        String name = "name", capital = "capital", flower = "flower", bird = "bird", pop = "population";

        for (int i=0; i<states.length; i++)
        {
            area.setColumns(5);
            area.setRows(50);
            //adjust column sizes here
            try {
                Scanner inFile = new Scanner(new File("data/states.txt"));
                while (inFile.hasNext()) {
                    name = inFile.nextLine();
                    capital = inFile.nextLine();
                    flower = inFile.nextLine();
                    bird = inFile.nextLine();
                    pop = inFile.nextLine();
                    area.append(name+capital+flower+bird+pop+"\n");
                }
                inFile.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }





        area.setBackground(new Color(255,250,205));
        area.setForeground(new Color(0,0,0));
        area.setFont(new Font("Consolas", Font.PLAIN, 15));
        // how many rows will show at one time
        area.setRows(35);
        // how many columns (1 char) will show at one time
        area.setColumns(115);
        JScrollPane pane = new JScrollPane(area);
        JOptionPane.showMessageDialog(null,pane);
    }
}

