package DungeonCrawler;

import java.util.ArrayList;

public class Tracker extends Create {
  private ArrayList<Integer> visited = new ArrayList<>();

    public ArrayList<Integer> getVisited() {
        return visited;
    }

   //This will add the index of the rooms to an array to track an instance of the game rooms visited
    public void setVisited(int index) {
        this.visited.add(index);
    }


}
