package christmas.model;

import christmas.constant.Constants;
import christmas.view.OutputView;

public class MenuGet {
    public static void menuCheck(String menuOrder) {
        String[] parts;
        String[] orders = menuOrder.split(",");
        for (String order : orders) {
            parts = order.split("-");
            String itemName = parts[0];
            int quantity = Integer.parseInt(parts[1]);
            menuValidate(itemName);
            OutputView.printMenu(itemName, quantity);
        }
    }

    public static void menuValidate(String itemName) {
        try {
            Constants.Menu menu = Constants.Menu.valueOf(itemName);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
        }
    }
}
