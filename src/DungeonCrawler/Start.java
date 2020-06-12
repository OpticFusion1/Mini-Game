package DungeonCrawler;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Start {

    public static void main(String[] args) throws FileNotFoundException{
        Map game = new Map();
        System.out.println("Welcome to Dungeon Crawler 3. If you want to play, type (y). Otherwise type (n)");
        Scanner sc = new Scanner(System.in);
        String ans = sc.nextLine();
        ans = ans.toLowerCase();


        try {
            if (ans.equals("n")) {
                System.out.println("goodbye");
            } else if (ans.equals("y")) {
                game.run("src/DungeonCrawler/rooms.txt");
            }
        }
        catch(FileNotFoundException ex){
            System.out.println("Somethings missing, the adventure cannot start without some information");
        }
    }
}
