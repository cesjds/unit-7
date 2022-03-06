import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.util.ArrayList;
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
 * ASSIGNMENT: Add a search method to your StateDB program that does
 * 	the following:
 *
 * search:  should ask the user what field they want to search
 * 	(using buttons) and then call one of three search methods:
 *
 * 	searchForState - should ask for the state to search for and
 * 		use a binary search to find the state and print the data
 * 		for that state.
 * 	searchForPopulation - should ask for a low and a high population
 * 		to search for and use a sequential search to print the data
 * 		for all states with populations in that range in one JOP
 * 		window.
 *  searchForBirdFlower - should ask for the bird or flower to
 *  	search for and use a sequential search to print all states
 *  	with that bird or flower in one JOP window.  You should only
 *  	have one set of search code that searches for either one.
 *
 * For all 3 searches if the search data isn't found you should print
 * 		an appropriate message.  Case shouldn't matter in your search.
 *
 * HAND IN: Copy and paste your code to Schoology and submit!
 *
 ********************************************************************/

public class StateDB
{
    public static void main(String[] args)
    {
        String states[][] = new String[51][5];

        openWindow(fillAray(states));
    }

    public static void openWindow(String states[][])
    {
        String message = "";
        message += "What do you want to do?";
        String[] buttons = {"Print",
                "Search",
                "Quit"};

        int choice=JOptionPane.showOptionDialog
                (null, message, "Choices",
                        0, 3, null, buttons, null);

        switch (choice)
        {
            case 0: print(states); break;
            case 1: search(states); break;
            case 2: System.exit(0); break;
            default: System.exit(0);
        }
    }

    public static String[][] fillAray(String states[][])
    {
        try {
            Scanner inFile = new Scanner(new File("data/states.txt"));

            while (inFile.hasNext())
            {
                for (int r = 0; r < 51; r++)
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

    public static void print(String[][] states)
    {
        JTextArea area = new JTextArea();
        //append column headings here
        int spaces[] = new int[]{22, 18, 30, 30};

        String name = "NAME", capital = "CAPITAL", flower = "FLOWER", bird = "BIRD", pop = "POPULATION";

        while(name.length() <= spaces[0])
            name += " ";
        while(capital.length() <= spaces[1])
            capital += " ";
        while(flower.length() <= spaces[2])
            flower += " ";
        while(bird.length() <= spaces[3])
            bird += " ";

        area.append(name+capital+flower+bird+pop+"\n\n");

        for (int i=0; i<states.length; i++) {
            name = states[i][0];
            capital = states[i][1];
            flower = states[i][2];
            bird = states[i][3];
            pop = states[i][4];

            while(name.length() <= spaces[0])
                name += " ";
            while(capital.length() <= spaces[1])
                capital += " ";
            while(flower.length() <= spaces[2])
                flower += " ";
            while(bird.length() <= spaces[3])
                bird += " ";

            area.append(name+capital+flower+bird+pop+"\n");
        }

        area.setBackground(new Color(255,250,205));
        area.setForeground(new Color(0,0,0));
        area.setFont(new Font("Andale Mono", Font.PLAIN, 15));
        // how many rows will show at one time
        area.setRows(35);
        // how many columns (1 char) will show at one time
        area.setColumns(115);
        JScrollPane pane = new JScrollPane(area);
        JOptionPane.showMessageDialog(null,pane);

        openWindow(states);
    }

    public static void search(String states[][])
    {
        String message = "";
        message += "What do you want to search for?";
        String[] buttons = {"State Name",
                            "Capital",
                            "Flower",
                            "Bird",
                            "Population"};

        int choice=JOptionPane.showOptionDialog
                (null, message, "Choices",
                        0, 3, null, buttons, null);

        switch(choice)
        {
            case 0: searchState(states); break;
            case 1: searchCapital(states); break;
            case 2: searchFlower(states); break;
            case 3: searchBird(states); break;
            case 4: searchPopulation(); break;
            default: searchState(states);
        }
    }

    public static void searchState(String states[][])
    {
        String state = JOptionPane.showInputDialog("What state would you like to search for?");

        int r = 0;

        while (state.equalsIgnoreCase(states[r][0]) == false)
        {
            r++;
        }

        String message = "";
        message += "Here is the information for " + state + ":" + "\n\n";
        message += "state name: " + states[r][0] + "\n";
        message += "state capital: " + states[r][1] + "\n";
        message += "state flower: " + states[r][2] + "\n";
        message += "state bird: " + states[r][3] + "\n";
        message += "state population: " + states[r][4] + "\n";

        JOptionPane.showMessageDialog(null, message);
        openWindow(states);
    }

    public static void searchCapital(String states[][])
    {
        String capital = JOptionPane.showInputDialog("What capital would you like to search for?");

        int r = 0;

        while (capital.equalsIgnoreCase(states[r][1]) == false)
        {
            r++;
        }

        String message = "";
        message += "Here is the information for " + capital + ":" + "\n\n";
        message += "state name: " + states[r][0] + "\n";
        message += "state capital: " + states[r][1] + "\n";
        message += "state flower: " + states[r][2] + "\n";
        message += "state bird: " + states[r][3] + "\n";
        message += "state population: " + states[r][4] + "\n";

        JOptionPane.showMessageDialog(null, message);
        openWindow(states);
    }

    public static void searchFlower(String states[][])
    {
        String flower = JOptionPane.showInputDialog("What flower would you like to search for?");

        int r = 0;

        ArrayList<String> flowerStates = new ArrayList<String>();

        for (int i = 0; i < 51; i++)
        {
            if (flower.equalsIgnoreCase(states[r][2]))
            {
                flowerStates.add(0, states[r][2]);
                r++;
            }
            else
                r++;
        }

        String message = "";
        message += "Here are all the states who have " + flower + " as their state flower:" + "\n\n";

        for (int i = 0; i < flowerStates.size(); i++)
            message += flowerStates.get(i) + "\n";

        JOptionPane.showMessageDialog(null, message);
        openWindow(states);
    }
    public static void searchBird(String states[][])
    {
        String bird = JOptionPane.showInputDialog("What bird would you like to search for?");

        int r = 0;

        ArrayList<String>  birdStates = new ArrayList<String>();

        for (int i = 0; i < 51; i++)
        {
            if (bird.equalsIgnoreCase(states[r][3]))
                birdStates.add(0, states[r][3]);
            else
                r++;
        }
    }
    public static void searchPopulation(){

    }
}
