package christmas.model;

import christmas.view.OutputView;

public class MenuGet {
    public static void menuCheck(String menuOrder) {
        String[] parts;
        String[] orders = menuOrder.split(",");
        for (String order : orders) {
            parts = order.split("-");
            String itemName = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            OutputView.printMenu(itemName, quantity);
        }
    }
}
