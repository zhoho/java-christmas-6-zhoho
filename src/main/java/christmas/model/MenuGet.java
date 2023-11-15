package christmas.model;
import christmas.constant.Constants;
import christmas.constant.ErrorMessage;
import christmas.constant.Numbers;
import christmas.view.OutputView;
public class MenuGet {
    static String[] orders;
    static String[] userOrders;
    static int mainMenuDiscount;
    static int dessertMenuDiscount;
    private static final String menuSplit = ",";
    private static final String amoutSplit = "-";
    public static void menuCheck(String menuOrder) {
        String[] parts;
        orders = menuOrder.split(menuSplit);
        menuNames();
        for (String order : orders) {
            parts = order.split(amoutSplit);
            String itemName = parts[Numbers.ZERO];
            int quantity = Integer.parseInt(parts[Numbers.ONE]);
            OutputView.printMenu(itemName, quantity);
            Calculate.getOriginTotalPrice(itemName, quantity);
            countingDessertmenu(quantity);
            countingMainmenu(quantity);
        }
        checkAllBeverage();
    }

    public static void menuNames() {
        userOrders = new String[orders.length];
        for (int i = Numbers.ZERO; i < orders.length; i++) {
            userOrders[i] = orders[i].split(amoutSplit)[Numbers.ZERO];
        }
    }

    public static void countingDessertmenu(int quantity) {
        dessertMenuDiscount = Numbers.ZERO;
        for (String order : userOrders) {
            Constants.Menu menu = findMenuByName(order);
            if(menu.getType().equals(Constants.MenuType.DESSERT)) {
                dessertMenuDiscount += Numbers.EVENTYEAR * quantity;
            }
        }
    }

    public static void countingMainmenu(int quantity) {
        mainMenuDiscount = Numbers.ZERO;
        for (String order : userOrders) {
            Constants.Menu menu = findMenuByName(order);
            if(menu.getType().equals(Constants.MenuType.MAIN)) {
                mainMenuDiscount += Numbers.EVENTYEAR * quantity;
            }
        }
    }

    public static Constants.Menu findMenuByName(String menuName) {
        for (Constants.Menu menu : Constants.Menu.values()) {
            if (menu.getName().equalsIgnoreCase(menuName)) {
                return menu;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.PrintErrorMessage.INVAILDMENU.label());
    }

    private static void checkAllBeverage() {
        for (String order : userOrders) {
            Constants.Menu menu = findMenuByName(order);
            if (!menu.getType().equals(Constants.MenuType.BEVERAGE)) {
                return;
            }
        }
        throw new IllegalArgumentException(ErrorMessage.PrintErrorMessage.INVAILDONLYDRINK.label());
    }

    public static int getDessertDiscount() {
        return dessertMenuDiscount;
    }

    public static int getMainDiscount() {
        return mainMenuDiscount;
    }
}