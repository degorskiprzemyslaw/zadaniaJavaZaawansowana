package restaurant;

import java.util.Objects;

public class Dish {
    private String name;
    private double price;
    private DishType type;
    private int caloricValue;

    public Dish(String name, double price, DishType type, int caloricValue) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.caloricValue = caloricValue;
    }

    public String getName() {
        return name;
    }

    public DishType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Double.compare(dish.price, price) == 0 && caloricValue == dish.caloricValue && Objects.equals(name, dish.name) && type == dish.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, type, caloricValue);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", type=" + type +
                ", caloricValue=" + caloricValue +
                '}';
    }
}
