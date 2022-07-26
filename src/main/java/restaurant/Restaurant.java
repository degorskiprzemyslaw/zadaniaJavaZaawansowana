package restaurant;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Restaurant {

    private final Set<Dish> dishes = new HashSet<>();


    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void removeDish(Dish dish) {
        dishes.remove(dish);
    }

    public Set<Dish> getDishes() {
        return dishes;
    }

    public Dish getDishFromName(String dishName) throws RestaurantException {
        for (Dish dish : dishes) {
            if (dishName.equals(dish.getName())) {
                return dish;
            }
        }
        throw new RestaurantException("Nie znaleziono potrawy o podanej nazwie");

    }


    public List<Dish> getDishesFromType(DishType type) {
        List<Dish> dishesByType = new ArrayList<>();
        for (Dish dish : dishes) {
            if(dish.getType().equals(type)){
                dishesByType.add(dish);
            }

        }
        return dishesByType;
    }
}
