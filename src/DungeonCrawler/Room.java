package DungeonCrawler;



import java.sql.Array;
import java.util.ArrayList;

public class Room  {

    private String name;
    private int number;
    private String description;
    int N, S, E ,W;
    private boolean win;
    Item item;

    //static int count;
    public Room(){

    }
    public Room(String name, int number, String description, int N, int S, int E, int W, boolean win ){
        this.name = name;
        this.number = number;
        this. description = description;
        this.N = N;
        this.S = S;
        this. E = E;
        this. W = W;
        this.win = win;
    }

    public int move(int cardinal){
        if(cardinal == 0){
            System.out.println("You cant move in that direction");
        }


        return cardinal;
    }

    public int directions(String answer){
        answer = answer.toLowerCase();
        int newIndex = 0;

        if(answer.equals("n")){
            newIndex= getN();
        }
        else if(answer.equals("s")){
            newIndex= getS();
        }
        else if(answer.equals("e")){
            newIndex=getE();
        }
        else if(answer.equals("w")){
           newIndex = getW();
        }

         return newIndex;
    }


    //public boolean isVisited(){
       //count++;
       // return true;

    //}


    public int getN() {
        return N;
    }

    public int getS() {
        return S;
    }

    public int getE() {
        return E;
    }

    public int getW() {
        return W;
    }

    public String getName() {
        return name;
    }

    public boolean getWin(){
        return win;
    }

    @Override
    public String toString(){
        /*count++;
        if(count>1){
            System.out.println("You have visited this room " + count + "times");
        }*/
        return description;

    }

    public ArrayList<Integer> getExits(){
        ArrayList<Integer> exit = new ArrayList<>();
        exit.add(getN());
        exit.add(getS());
        exit.add(getE());
        exit.add(getW());
        return exit;
    }


}
