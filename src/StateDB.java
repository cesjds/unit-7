import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class StateDB
{
    public static void main(String[] args) {

        String states[][] = new String[50][5];
        fillAray(states);
        printArray(states);

    }

    public static String[][] fillAray(String[][] states)
    {
        String name = "name", capital = "capital", flower = "flower", bird = "bird", pop = "population";
        try {
            Scanner inFile = new Scanner(new File("data/states.txt"));

            while (inFile.hasNext()) {
                for(int r = 0; r < 50; r++)
                {
                    for (int c = 0; c < 5; c++)
                    {
                        states[r][c] = inFile.nextLine();
                    }
                }
            }
            inFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return states;
    }

    public static void printArray(String states[][])
    {
        JTextArea area = new JTextArea();
        area.setColumns(5);
        area.setRows(50);

        int spaces = 50;
        int spacesAdd = 0;

        for(int r = 0; r < 50; r++)
        {
            for (int c = 0; c < 5; c++)
            {
                spacesAdd = spaces - states[r][c].length();
                area.append(states[r][c]);

                for (int s = 0; s < spacesAdd; s++)
                {
                    area.append(" ");
                }

            }
            area.append("\n");
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