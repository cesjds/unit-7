import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class StateDB
{
    public static void main(String[] args) {

        String states[][] = new String[50][5];
        fillAray(states);

    }

    public static String[][] fillAray(String[][] states)
    {

        JTextArea area = new JTextArea();
        area.setColumns(5);
        area.setRows(50);


        String name = "name", capital = "capital", flower = "flower", bird = "bird", pop = "population";

        int spaces = 25;
        int spacesAdd = 0;
        String spacesAdded = "";

        try {
            Scanner inFile = new Scanner(new File("data/states.txt"));

            while (inFile.hasNext()) {
                for(int r = 0; r < states.length; r++)
                {
                    name = inFile.nextLine();
                    spacesAdd = spaces - states[r][0].length();
                    for (int a = 0; a < spacesAdd; a++)
                        name += " ";
                    capital = inFile.nextLine();
                    spacesAdd = spaces - states[r][1].length();
                    for (int a = 0; a < spacesAdd; a++)
                        capital += " ";
                    flower = inFile.nextLine();
                    spacesAdd = spaces - states[r][2].length();
                    for (int a = 0; a < spacesAdd; a++)
                        flower += " ";
                    bird = inFile.nextLine();
                    spacesAdd = spaces - states[r][3].length();
                    for (int a = 0; a < spacesAdd; a++)
                        bird += " ";
                    pop = inFile.nextLine();
                    spacesAdd = spaces - states[r][4].length();
                    for (int a = 0; a < spacesAdd; a++)
                        pop += " ";
                    area.append(name+capital+flower+bird+pop+"\n");
                }
            }
            inFile.close();
        } catch (Exception e) {
            e.printStackTrace();
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

        return states;
    }
}