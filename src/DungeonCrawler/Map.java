package DungeonCrawler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Map {




    public void run(String text) throws FileNotFoundException {
        boolean go = true;
        Create dungeon1 = new Create();

        dungeon1.createRooms(text);

        Scanner sc = new Scanner(System.in);

        ArrayList<Room> All = dungeon1.getAllRooms();
        Room starter = All.get(0);
        String direction;
        int index;
        System.out.println("You have dared to enter");
        System.out.println("So tenacious... there are only four ways you can move: North, South, East, West. Type in n,s,e, or w to replicate those cardinal directions.");

         while(go){
            System.out.println("You are currently at "+ starter.getName());
            System.out.println(starter.toString());

            if(starter.getWin()){
                 System.out.println("Congratulations, you found a way out");
                 break;
             }

            System.out.println("Where do you want to go? If you dont care about saving her anymore, press X on your keyboard");
            direction = sc.nextLine();
            if(direction.toLowerCase().equals("x")){
                System.out.println("You have failed and disappointed everyone...");
                break;
            }
            index = starter.directions(direction);
            if(index == 0) {
                System.out.println("Its impossible to move here. Choose a different route.");
            }
            else
                starter = All.get(index);


        }
    }
}
