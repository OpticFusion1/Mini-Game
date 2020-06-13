package DungeonCrawler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class Map {

     int index;
    String direction;

    public void run(String text) throws FileNotFoundException {

        Create dungeon1 = new Create();

        dungeon1.createRooms(text);

        Scanner sc = new Scanner(System.in);

        ArrayList<Room> All = dungeon1.getAllRooms();

        Room starter = All.get(0);

        Tracker track1 = new Tracker();
        System.out.println("You have dared to enter");
        System.out.println("So tenacious... there are only four ways you can move: North, South, East, West. Type in n,s,e, or w to replicate those cardinal directions.");

         do{
            System.out.println("You are currently at "+ starter.getName());
            System.out.println(starter.toString());
            System.out.println("Where do you want to go? If you dont care about saving her anymore, press X on your keyboard");
            direction = sc.nextLine();
            if(direction.toLowerCase().equals("x")){
                System.out.println("You have failed and disappointed everyone...");
                break;
            }
            index = starter.directions(direction);//A direction from the user converted into a int. These ints are indexes to other rooms
             track1.setVisited(index); //stores the index of a room here.
            if(index == 0) {
                System.out.println("Its impossible to move here. Choose a different route.");
            }
            else
                starter = All.get(index);
                 if(starter.getWin() && index!=6){
                     System.out.println(starter.toString());
                     System.out.println("Congratulations, you found a way out but this isn't where the princess is.");
                     System.out.println("Choose a direction to go back.");
                     //create a way to exit from here.
                     direction = sc.nextLine();
                     index = starter.directions(direction);
                     track1.setVisited(index);
                     starter = All.get(index);
                 }
                 else if(starter.getWin()){
                     System.out.println(starter.toString());
                     System.out.println("You got her out! Great work!");
                 }

        }
         while(!starter.getWin());


    }
}
