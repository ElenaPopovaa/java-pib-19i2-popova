import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    Restaurant restaurant;
    public static void main(String[] args) throws IOException {
        Main main = new Main();
        File file = new File("data.txt");
        if (!file.exists()) {
            System.out.println("Файла нет, создаём данные");
            main.init();
            Gson gson = new Gson();
            Files.write( Paths.get("data.txt"), gson.toJson(main.restaurant).getBytes());
        } else {
            System.out.println("Читаем файл, извлекаем данные");
            Gson gson = new Gson();
            String text = new String(Files.readAllBytes(Paths.get("data.txt")), StandardCharsets.UTF_8);
            main.restaurant = gson.fromJson(text, Restaurant.class);
        }
        System.out.println("Столы: ");
        main.restaurant.printTable();
        System.out.println("\nМеню:");
        main.restaurant.printMenu();
        System.out.println(main.restaurant);
    }

    void init() {
        restaurant = new Restaurant();
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
        restaurant.printMenu();

        restaurant.makeOrder(2, "8", "Побыстрее!");
        restaurant.changeShift(1);
        restaurant.pay("8");
    }
}
