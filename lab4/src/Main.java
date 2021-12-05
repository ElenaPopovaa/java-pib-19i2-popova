import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.addShift("1 смена");
        restaurant.addShift("2 смена");
        restaurant.changeShift(0);
        List<Table> tableList = new ArrayList<>();
        tableList.add(new Table(TableStatus.FREE, "1", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "2", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "3", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "4", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "5", new ArrayList<>()));
        tableList.add(new Table(TableStatus.FREE, "6", new ArrayList<>()));
        restaurant.setTables(tableList);
        System.out.println("Столы: ");
        restaurant.printTable();
        List<Dish> menu = new ArrayList<>();
        menu.add(new Dish("Салат греческий", 249));
        menu.add(new Dish("Салат цезарь", 349));
        menu.add(new Dish("Курица в панировке", 399));
        menu.add(new Dish("Хлеб", 4));
        menu.add(new Dish("Суп из сёмги", 759));
        menu.add(new Dish("Фрикадельки из говядины", 429));
        menu.add(new Dish("Мохито", 119));
        menu.add(new Dish("Вино игристое", 789));
        restaurant.setMenu(menu);
        System.out.println("\nМеню ресторана:");
        restaurant.printMenu();

        restaurant.makeOrder(2, "8", "Побыстрее!");
        restaurant.changeShift(1);
        restaurant.pay("8");
        System.out.println(restaurant);
    }
}
