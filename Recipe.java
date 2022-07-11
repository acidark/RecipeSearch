import java.util.ArrayList;
public class Recipe {
    private ArrayList<String> ingredients;
    private String name;
    private int time;

    public Recipe(ArrayList<String> ingre,String name,int time){
        this.ingredients = ingre;
        this.name = name;
        this.time = time;
    }

    public String getName(){
        return this.name;
    }
    public int getTime(){
        return this.time;
    }
    public ArrayList<String> getRecipe(){

        return this.ingredients;
    }
    public String toString(){
        return this.name+", cooking time: "+this.time;
    }

}
