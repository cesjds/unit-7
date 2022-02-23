import java.awt.Color;
import java.awt.Font;
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
 *		state flower
 *		state bird
 *		state population (I think in 10 thousands)
 *
 * HAND IN:  Let me see your database print on your monitor.
 *
 *******************************************************************/

public class StateDB
{
    public static void main(String[]args)
    {
        String[][] states = new String[50][5];
        print(states);
    }

    public static void print(String[][] states)
    {
        JTextArea area = new JTextArea();
        //append column headings here
        String name = "State", capital = "Capital", flower = "Flower", bird = "Bird", pop = "Pop";
        for (int i=0; i<states.length; i++) {
            //adjust column sizes here
            area.append(name+capital+flower+bird+pop+"\n");
        }

        area.setBackground(new Color(51, 51, 51));
        area.setForeground(new Color(255, 255, 255));
        area.setFont(new Font("SF Pro", Font.PLAIN, 15));
        // how many rows will show at one time
        area.setRows(35);
        // how many columns (1 char) will show at one time
        area.setColumns(115);
        JScrollPane pane = new JScrollPane(area);
        JOptionPane.showMessageDialog(null,pane);
    }
}