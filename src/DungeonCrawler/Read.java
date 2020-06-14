package DungeonCrawler;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Read {

    String rStr;
    String iStr;

    private ArrayList<Room> place = new ArrayList<>();
    protected ArrayList<Item> things = new ArrayList<>();

    public ArrayList readFile(String roomName, String itemName) {


        try{
            File file = new File(roomName);
            Scanner content = new Scanner(file);

            File itemFile = new File(itemName);
            Scanner itemContent = new Scanner(itemFile);
            //content.useDelimiter(";");
            //int count = 0;
            while(content.hasNextLine()){
                this.rStr = content.nextLine();
                this.place.add(parse(rStr));
                //count++;
            }

            while(itemContent.hasNextLine()){
                this.iStr = itemContent.nextLine();
                this.things.add(parseItem(iStr));
                //count++;
            }

        }
        catch(FileNotFoundException ex){
            System.out.println( "The file " +roomName+" doesnt exist. Please check your spelling or provide a different file name");
        }
    return place;

    }

    public Room parse(String str){
        String name, number, description, win;
        boolean winInBoolean;
        Room r = new Room();

        Scanner room = new Scanner(str);

        room.useDelimiter(";");
        while(room.hasNext()){
            name=room.next();
            number=room.next();
            int ID = Integer.parseInt(number);
            description =room.next();

            int north =Integer.parseInt(room.next());
            int south  = Integer.parseInt(room.next());
            int east  = Integer.parseInt(room.next());
            int west  = Integer.parseInt(room.next());

            //info = room.next();

            //Scanner NSEW = new Scanner(info);
            //NSEW.useDelimiter(",");
            //while(NSEW.hasNext()){

            //}

            win=room.next();
            if(win.equals("win")) {
                winInBoolean = true;
            }
            else {
                winInBoolean = false;
            }
            r =  new Room(name,ID,description,north,south,east,west,winInBoolean);
        }
        room.close();
        return r;
    }

    public Item parseItem(String str){
        String name,description;

        Item i = new Item();

        Scanner item = new Scanner(str);

        item.useDelimiter(";");
        while(item.hasNext()){
            name=item.next();
            description=item.next();
            i =  new Item(name,description);
        }
        item.close();
        return i;
    }

    public ArrayList<Item> getThings() {
        return things;
    }
}
