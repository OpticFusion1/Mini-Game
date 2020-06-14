package DungeonCrawler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class Map {
    Random rand = new Random();
    int index;
    String direction;
    Create dungeon1 = new Create();
    Scanner sc = new Scanner(System.in);

    //Tracker track1 = new Tracker();
    Player player = new Player();
    Room starter;
    ArrayList<Room> All;
    ArrayList<Item> items;
    ArrayList<Integer> itemIndexes;


    public void run(String room, String item) {
        dungeon1.createRooms(room, item);
          this.All = dungeon1.getAllRooms();
          this.items = dungeon1.getAllItems();

        this.starter = All.get(0);
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
             player.setVisited(index); //stores the index of a room here.
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
                     player.setVisited(index);
                     starter = All.get(index);
                 }
                 else if(starter.getWin()){
                     System.out.println(starter.toString());
                     System.out.println("You got her out! Great work!");
                 }

        }
         while(!starter.getWin());


    }

    public void look(){
        System.out.println("You look around and see these sights..."); //not done yet. need to add the item method for description
        System.out.println(starter.toString());
    }

    public void itemGenerator(ArrayList rooms){
        int i = 0;
        int limit = items.size();
        this.itemIndexes.add(-1); //first location will never have an item
        while(i<= rooms.size()){
            this.itemIndexes.add(rand.nextInt(limit));
            i++;
        }


    }


}
