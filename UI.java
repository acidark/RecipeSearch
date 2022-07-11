import java.util.ArrayList;
import java.util.Scanner;

//import javax.swing.text.html.HTMLDocument.HTMLReader.PreAction;

import java.nio.file.Paths;

public class UI {
    private ArrayList<Recipe> recipeList;
    private Scanner scanner;

    public UI(){       
    }

    public void start(){
        ArrayList<String> recipe1 = new ArrayList<>();
        ArrayList<String> prueba = new ArrayList<>();
        //ArrayList<Recipe> recipeList = new ArrayList<>();
        this.recipeList = new ArrayList<>();
        System.out.println("File to read");
        //Scanner scanner = new Scanner(System.in);
        scanner = new Scanner(System.in);
        String file = scanner.nextLine();
        //int i =0;
        try (Scanner fileToRead = new Scanner(Paths.get(file))){
            while(fileToRead.hasNextLine()){
                //System.out.println("1");
                //int i =0;
                String fileContents = fileToRead.nextLine();
                //System.out.println(fileContents);
                //i++;
                prueba.add(fileContents); /*
                if (fileContents.equals("")){
                    //int i =0;
                    //System.out.println("True");
                    prueba.remove(prueba.size()-1);
                    String nameOfRecipe = prueba.get(0);
                    int timeToCook = Integer.valueOf(prueba.get(1));
                    while(true){
                        if(prueba.get(i).equals("")){
                            break;
                        }
                        recipe1.add(prueba.get(i));
                        i++;
                    }
                    //for(int i =2;i<prueba.size();i++){
                    //    recipe1.add(prueba.get(i));
                    //}
                    System.out.println(recipe1);
                    //System.out.println(prueba);
                    recipeList.add(new Recipe(recipe1, nameOfRecipe, timeToCook));
                    recipe1.clear();
                } */
                //i++;

            }
            //System.out.println(fileContents);
        } catch (Exception e) {
            System.out.println("Error"+e);
            //TODO: handle exception
        }
        //int i = 0;
        int k =0;
        ArrayList<Integer> prueba2 = new ArrayList<>();
        while (k < prueba.size()-1){
            if(prueba.get(k).equals("")){
                prueba2.add(k);
            }
            k++;
        }
        prueba2.add(prueba.size());
        System.out.println(prueba2);
        int begin = 0;
        //int i = 0;
        //int end = i+1;
        int j =0;
        //int size = prueba2.size()+1;
        String nameOfRecipe = "";
        int timeToCook =0;
        ArrayList<String> ingreForRecipe = new ArrayList<>();
        for(int i=0;i<=prueba2.size()-1;i++){
            //int j =0;
            int p =0;
            for(j=begin;j<prueba2.get(i);j++){
                //System.out.println(p);
                //System.out.println(prueba.get(j)+"j:"+j+" i:"+i);
                if(p==0){
                    //System.out.println(p);
                    nameOfRecipe = prueba.get(j);
                }
                else if(p==1){
                    //System.out.println(p);
                    timeToCook = Integer.valueOf(prueba.get(j));
                } else {
                    //System.out.println(p);
                    recipe1.add(prueba.get(j));
                }
                p++;
            }
            //System.out.println(recipe1);
            //System.out.println(nameOfRecipe);
            //System.out.println(timeToCook);
            ingreForRecipe = new ArrayList(recipe1);
            this.recipeList.add(new Recipe(ingreForRecipe, nameOfRecipe, timeToCook));
            //System.out.println(recipeList.get(0).getRecipe());
            recipe1.clear();
            //System.out.println(recipeList.get(0).getRecipe());
            //System.out.println(recipeList.get(1).getRecipe());
            //System.out.println(recipeList.get(2).getRecipe());
            begin = prueba2.get(i)+1;

        }
        //while(true){
        System.out.println("Commands:");
        System.out.println("list - list the recipes");
        System.out.println("stop - stop the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - search recipes by ingredient");
        System.out.println("");
        while(true){
            //System.out.println("");
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            //System.out.println("");
            if(command.equals("stop")){
                break;
            }
            processCommand(command);
        }

        //public static void processCommand(String commando){
        //String kaka = comma;
        //}
        //System.out.println(recipeList.get(0).getRecipe());
        //System.out.println(recipeList.get(1).getRecipe());
        //System.out.println(recipeList.get(2).getRecipe());
        //for(Recipe i : recipeList){
        //    System.out.println(i);
        //}
        /*while (i < prueba.size()-1){
            if(prueba.get(i).equals("")){
                int j=i;
                while(!(prueba.get(i+1).equals(""))){
                    recipe1.add(prueba.get(j));
                    j++;
                }
                //for(int j =i;j<i;j++){
                //    recipe1.add(prueba.get(j));
                //}
                
                //String nameOfRecipe = prueba.get(i);
                //int timeToCook = Integer.valueOf(prueba.get(i));
                //i++;
            }
            i++;
            //recipe1.add(prueba.get(i));

        }
        //System.out.println(recipe1); */

    }
    public void processCommand(String command){
        if(command.equals("list")){
            System.out.println("");
            System.out.println("Recipes:");
            for(Recipe i : this.recipeList){
                //System.out.println("Recipes:");
                System.out.println(i);
                //System.out.println(i.getName()+",cooking time: "+i.getTime());
            }
            System.out.println("");
        }
        if(command.equals("find name")){
            //Scanner word = new Scanner(System.in);
            System.out.print("Searched word: ");
            String wordtoSearch = scanner.nextLine();
            System.out.println("");
            for(Recipe i : this.recipeList){
                if(i.getName().contains(wordtoSearch)){
                    System.out.println("Recipes:");
                    //System.out.println(i.getName()+", cooking time: "+i.getTime());
                    System.out.println(i);
                }
            }
            System.out.println("");
        }
        if(command.equals("find cooking time")){
            System.out.print("Max cooking time: ");
            int maxCookingTime = Integer.valueOf(scanner.nextLine());
            System.out.println("");
            System.out.println("Recipes:");
            for(Recipe i: this.recipeList){
                if(i.getTime() <= maxCookingTime){
                    System.out.println(i);
                }
            }
            System.out.println("");
        }
        if(command.equals("find ingredient")){
            System.out.print("Ingredient: ");
            String ingredient = scanner.nextLine();
            System.out.println("");
            System.out.println("Recipes:");
            for (Recipe i : this.recipeList){
                //ArrayList<String> rp = new ArrayList<>(i.getRecipe());
                for(String j : i.getRecipe())
                    if(j.equals(ingredient)){
                        System.out.println(i);
                }
            }
            System.out.println("");
        }
    }
}
