package DungeonCrawler;

import java.util.ArrayList;

public class Tracker extends Player {
  protected ArrayList<Integer> items = new ArrayList<>();

    public ArrayList<Integer> getItems() {
        return items;
    }

   //This will add the index of the rooms to an array to track an instance of the game rooms visited
   @Override
    public void setVisited(int index) {
        this.items.add(index);
    }




}
