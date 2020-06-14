package DungeonCrawler;

public class Item  {
    String Name;
    String itemdescription;

    public Item(){}

    public Item(String name, String Description){
        this.Name = name;
        this.itemdescription = Description;
    }


    public String getName() {
        return Name;
    }

    public String getDescription(){
        return this.itemdescription;
    }


}
