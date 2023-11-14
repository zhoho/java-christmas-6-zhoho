package christmas.model;

import christmas.constant.Constants;
import christmas.view.OutputView;

import java.util.Arrays;

public class MenuGet {
    static String[] orders;
    static String[] userOrders;
    static int mainMenuDiscount;
    static int dessertMenuDiscount;
    public static void menuCheck(String menuOrder) {
        String[] parts;
        orders = menuOrder.split(",");
        menuNames();
        for (String order : orders) {
            parts = order.split("-");
            String itemName = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            OutputView.printMenu(itemName, quantity);
            Calculate.getOriginTotalPrice(itemName, quantity);
            countingDessertmenu(quantity);
            countingMainmenu(quantity);
        }
    }

    public static void menuNames() {
        userOrders = new String[orders.length];
        for (int i = 0; i < orders.length; i++) {
            userOrders[i] = orders[i].split("-")[0];
        }
    }

    public static void countingDessertmenu(int quantity) {
        dessertMenuDiscount = 0;
        for (String order : userOrders) {
            Constants.Menu menu = findMenuByName(order);
            if(menu.getType().equals(Constants.MenuType.DESSERT)) {
                dessertMenuDiscount += 2023 * quantity;
            }
        }
    }

    public static void countingMainmenu(int quantity) {
        mainMenuDiscount = 0;
        for (String order : userOrders) {
            Constants.Menu menu = findMenuByName(order);
            if(menu.getType().equals(Constants.MenuType.MAIN)) {
                mainMenuDiscount += 2023 * quantity;
            }
        }
    }

    public static Constants.Menu findMenuByName(String menuName) {
        for (Constants.Menu menu : Constants.Menu.values()) {
            if (menu.getName().equalsIgnoreCase(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException("[ERROR] 메뉴가 없습니다: " + menuName);
    }

    public static int getDessertDiscount() {
        return dessertMenuDiscount;
    }

    public static int getMainDiscount() {
        return mainMenuDiscount;
    }
}