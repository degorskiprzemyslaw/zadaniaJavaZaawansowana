package restaurant;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        Dish dish1 = new Dish("Spaghetti Bolognese", 33, DishType.DINNER, 500);
        Dish dish2 = new Dish("Scrambled Eggs", 23, DishType.BREAKFAST, 300);
        Dish dish3 = new Dish("Cheese Plate", 50, DishType.APPETIZER, 700);
        Dish dish4 = new Dish("Cinnamon Roll", 16, DishType.BREAKFAST, 600);
        Dish dish5 = new Dish("Tomato Soup", 12, DishType.DINNER, 250);
        Dish dish6 = new Dish("Tomato Soup", 12, DishType.DINNER, 250);

        restaurant.addDish(dish1);
        restaurant.addDish(dish2);
        restaurant.addDish(dish3);
        restaurant.addDish(dish4);
        restaurant.addDish(dish5);
        restaurant.addDish(dish6);
        System.out.println(restaurant.getDishes());

        try{
            System.out.println(restaurant.getDishFromName("Scrambled Eggs"));
            System.out.println(restaurant.getDishFromName("Fruit Salad"));

        } catch (RestaurantException e){
            System.out.println(e.getMessage());
        }

        System.out.println(restaurant.getDishesFromType(DishType.APPETIZER));




    }




}
    /*Stwórz obiekt Dish (potrawa), potrawa ma posiadać nazwę, cenę, wartość kaloryczną oraz enum -
    typ (np. BREAKFAST, DINNER, APPETIZER).

        Uwaga, żadna z poniższych metod nie powinna drukować nic w konsoli.
        Wykorzystaj metody toString oraz wartości zwracane lub obsługę wyjątków :)

        stwórz klasę Restaurant, zawierającą zbiór dań
        stwórz metody pozwalającą dodać danie i usunąć
        dodaj do restauracji 5 różnych dań
        zaimplementuj metody equals i hashCode aby uniknąć duplikatów i upewnij się, że spełniają swoje zadanie
        stwórz metodę pozwalającą wyszukać danie po nazwie, ma ona zwracać obiekt typu Dish,
        w przypadku nie odnalezienia takiego obiektu obiektu ma rzucać wyjątek typu RestaurantException
        stwórz metodę pozwalającą wyszukać dania po typie potrawy,
        jeśli nie ma żadnej potrawy w danym typie, metoda ma zwracać pustą listę.*/



