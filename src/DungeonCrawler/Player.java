package DungeonCrawler;

import java.lang.reflect.Array;
import java.util.*;
import java.util.Map;

public class Player  {
    private String name;
    private ArrayList<Item> items;
    ArrayList<Integer> myVisit = new ArrayList<>();
    HashMap<Integer,Integer> roomItemLocation = new HashMap<>();
    public Player(){}

    public Player(String name){
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVisited(int index) {
        this.myVisit.add(index);
    }

    public int convertItemToIndex(Scanner scan,ArrayList<Item> itemList){
        int indexNeeded=0;
        int x=0;
        String answer = scan.nextLine();
        for(Item drop: itemList){
            if(answer.toLowerCase().equals(drop.getName().toLowerCase())){
               indexNeeded = x;
            }
            else{
                x++;
                if(x==3){
                    indexNeeded = -1;
                }
            }

        }
        return indexNeeded;
    }
    public ArrayList<Integer> remove( int i, ArrayList<Integer> itemLocate, ArrayList<Room> rooms, Scanner scan, ArrayList<Item> item1){
        System.out.println("What item do you want to remove?");
        int indexNeed = convertItemToIndex(scan,item1);



        for(Iterator<Map.Entry<Integer, Integer>> it = roomItemLocation.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Integer, Integer> entry = it.next();
            if(indexNeed==-1){
                System.out.println("That's not an item...");
                break;
            }
            else if(entry.getValue() ==indexNeed) {
                it.remove();
                System.out.println("The " +item1.get(indexNeed).getName() + " has been dropped");
                itemLocate.set(i,indexNeed);
                break;
            }
            else
                System.out.println("You dont have this item.");
        }



        return itemLocate;


        //roomItemLocation.entrySet().removeIf(intEntry-> intEntry.equals(indexNeed) );
        }

        //counter to find the index of the item

        //check if you have the item. If item index == something that the hashmap values have.
        //if true remove that particular hashmap and set the value of the itemlocate array at that particular index to the item index you get from the name of the item.

        //if(itemList.get(itemLocate.get(myVisit.get(i))).getName().equals(answer)){
            //itemLocate.set();
        //}






    //put in the room index and the array of itemlocations and the arraylist of items. This will store the room index and the itemindexes (related to the location) in a hashmap.
    public ArrayList<Integer> get(int i,ArrayList<Integer> itemLocate,ArrayList<Item> itemList){
    roomItemLocation.put(i,itemLocate.get(i));
    //set the item in that location to nothing

    System.out.println( itemList.get(itemLocate.get(i)).getName()+" has been picked up and added to the inventory");
    itemLocate.set(i,-1);
    return itemLocate;
    //use the index of the particular item location to find the item and gets the name of that item.

    }

    public void backpack(ArrayList<Item> items){
        System.out.println("--------------Backpack--------------");
        //int x = 1;
        for(Integer itemIndexes : this.roomItemLocation.values()){
            System.out.println("-->"+ ": " +items.get(itemIndexes).getName());
        }
        System.out.println("------------------------------------"+"\n");



    }

    public Room mover(ArrayList<Room> allRooms, int index,Scanner sc){
        Room starter = allRooms.get(index);
        if(index == 0){
            System.out.println("Choose a different path");
        }
        else{
            //starter = allRooms.get(index);
            if(starter.getWin() && index!=6){
                System.out.println(starter.toString());
                System.out.println("Congratulations, you found a way out but this isn't where the princess is.");
                System.out.println("Choose a direction to go back.");
                //create a way to exit from here.
                String direction = sc.nextLine();
                index = starter.directions(direction);
                setVisited(index);
                starter = allRooms.get(index);
            }
            else if(starter.getWin()){
                System.out.println(starter.toString());
                System.out.println("You got her out! Great work!");
            }

        }
        return starter;
    }
}
