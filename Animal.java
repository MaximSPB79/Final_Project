package pet_registry;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {


    public static final List<Animal> animals = new ArrayList<>();
    private int id;

    public abstract void addCommand(String command);

    public abstract List<String> getCommands();

    public static void setAnimals(Animal animal){
        animals.add(animal);
    }

    public int getId(){
        return id;
    }
}
