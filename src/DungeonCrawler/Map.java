package DungeonCrawler;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Map {
    Random rand = new Random();
    int index;
    String direction;
    Create dungeon1 = new Create();
    Scanner sc = new Scanner(System.in);


    Player player = new Player();
    Room starter;
    ArrayList<Room> All;
    ArrayList<Item> items;
    ArrayList<Integer> itemIndexes = new ArrayList<>();


    public void run(String room, String item) {
        dungeon1.createRooms(room, item);
        this.All = dungeon1.getAllRooms();
        this.items = dungeon1.getAllItems();
        itemGenerator(All);
        this.starter = All.get(0);

        System.out.println("You have dared to enter");
        player.setVisited(0);
        System.out.println("You are a tenacious one... there are only four ways you can move: North, South, East, West.\n");
        System.out.println("Type in n,s,e, or w to replicate those cardinal directions.\n");
        System.out.println("If you dont care about saving her anymore, press 'X' on your keyboard\n");
        System.out.println("Type 'drop' to drop an item, 'move' to move, 'inspect' to look around and 'pickup' to pickup an item\n");
        do {
            System.out.println("You are currently at " + starter.getName());
            //System.out.println(starter.toString());
            System.out.println("What do you want to do?");

            direction = sc.nextLine();
            if (direction.toLowerCase().equals("x")) {
                System.out.println("You have failed and disappointed everyone...");
                break;
            } else if (direction.toLowerCase().equals("move")) {
                System.out.println("Where do you want to go?");
                direction = sc.nextLine();
                this.index = starter.directions(direction);//A direction from the user converted into a int. These ints are indexes to other rooms
                starter = player.mover(All, this.index, sc);
                player.setVisited(this.index); //stores the index of a room here.
            } else if (direction.toLowerCase().equals("inspect")) {
                look();
            } else if (direction.toLowerCase().equals("drop")) {
                itemIndexes = player.remove(index, itemIndexes, All, sc, items);
            } else if (direction.toLowerCase().equals("pickup")) {
                itemIndexes = player.get(index, itemIndexes, items);
            } else if (direction.toLowerCase().equals("backpack")) {
                player.backpack(items);
            } else if (!Arrays.asList("inspect", "drop", "backpack", "pickup", "move", "x").contains(direction.toLowerCase())) {
                System.out.println("You can't do this here, try another command");
            }


        }
        while (!starter.getWin());


    }

    public void look() {
        System.out.println("You look around and see these sights...\n");
        if (itemIndexes.get(index) != -1) {
            System.out.println(starter.toString() + "\n" + items.get(itemIndexes.get(index)).getDescription() + "\n" + "Its the " + items.get(itemIndexes.get(index)).getName() + " item !");

        } else if (itemIndexes.get(index) == -1) {
            System.out.println(starter.toString() + "\n" + "There are no items here.");
        }
        ArrayList<Integer> exits;
        exits = starter.getExits();
        System.out.println("The exits you can see are: ");

        for (int exit : exits
        ) {
            if (exit != 0)
                System.out.println(All.get(exit).getName() + "\n");
        }
    }

    public void itemGenerator(ArrayList rooms) {
        int i = 1;
        int limit = items.size();
        this.itemIndexes.add(null); //first location will never have an item
        while (i < rooms.size()) {
            this.itemIndexes.add(rand.nextInt(limit));
            i++;
        }



    }

}


