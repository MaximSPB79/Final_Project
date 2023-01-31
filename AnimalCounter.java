package pet_registry;

public class AnimalCounter {

    private static int id = 0;

    public static void add() {
        id++;
    }

    static public int getId() {
         return id;
    }
}
