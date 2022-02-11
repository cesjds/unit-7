import java.io.File;
import java.util.Scanner;

public class ReadingDataFilesPractice
{
    public static void main(String[] args)
    {

        readingFilesOne();
        readingFilesTwo();
        readingFilesThree();
        readingFilesFour();
    }

    public static void readingFilesOne()
    {
        try{
            Scanner inFile = new Scanner(new File("Inventory.txt"));
            String item;
            int numberOnHand;
            double price;
            System.out.println("Inventory.txt:");

            while (inFile.hasNext()) {
                item = inFile.nextLine();
                System.out.print(item+"\t");
                numberOnHand = Integer.parseInt(inFile.nextLine());
                System.out.print(numberOnHand+"\t");
                price = Double.parseDouble(inFile.nextLine());
                System.out.println(price);
            }
            inFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readingFilesTwo()
    {
        try{
            Scanner inFile = new Scanner(new File("Numbers.txt"));
            int iNum;
            double dNum;
            System.out.println("Numbers.txt:");

            while (inFile.hasNext()) {
                iNum = inFile.nextInt();
                System.out.print(iNum+"\t");
                dNum = inFile.nextDouble();
                System.out.print(dNum+"\t");
                System.out.println();
            }
            inFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readingFilesThree()
    {
        try {
            Scanner inFile = new Scanner(new File("Inventory2.txt"));
            String line;
            String[] data;
            System.out.println("Inventory2.txt:");

            while (inFile.hasNext()) {
                line = inFile.nextLine();
                data = line.split(" ");
                System.out.println(data[0] + "\t"
                        + Integer.parseInt(data[1]) + "\t"
                        + Double.parseDouble(data[2]));
            }
            inFile.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readingFilesFour()
    {
        String item[] = new String[];
        int numOnHand[] = new int[];
        double price[] = new double[];

        try{
            Scanner inFile = new Scanner(new File("Inventory.txt"));
            System.out.println("Inventory.txt:");

            for(int i = 0; i < 3; i++)
            {
                item[] = 
            }

            while (inFile.hasNext()) {
                item[] = inFile.nextLine();
                System.out.print(item+"\t");
                numberOnHand = Integer.parseInt(inFile.nextLine());
                System.out.print(numberOnHand+"\t");
                price = Double.parseDouble(inFile.nextLine());
                System.out.println(price);
            }
            inFile.close();
        }catch (Exception e){
            e.printStackTrace();
        }



    }

}
