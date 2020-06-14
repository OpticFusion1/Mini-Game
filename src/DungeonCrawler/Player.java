package DungeonCrawler;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player  {
    private String name;
    private ArrayList<Item> items;
    ArrayList<Integer> myVisit = new ArrayList<>();

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

    public void create(){

    }
}
