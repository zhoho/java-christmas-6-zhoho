package christmas.view;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.Constants;

public class InputView {

    public static int readDate() {
        while (true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String input = Console.readLine();
            try {
                validateCheckDate(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String readMenu() {
        while (true) {
            System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
            String input = Console.readLine();
            try {
                validateMenuFormat(input);
                validateValidMenu(input);
                validateOrderAmount(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateCheckDate(String input) {
        try {
            int date = Integer.parseInt(input);
            if (date < 1 || date > 31) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 1에서 31 사이의 숫자로 다시 입력해 주세요.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }
    }

    private static void validateMenuFormat(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String[] parts = item.split("-");
            if (!isNumeric(parts[1].trim())) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }
    }

    private static void validateValidMenu(String input) {
        String[] orders = input.split(",");
        for (String order : orders) {
            String[] menuAndCount = order.split("-");
            String menu = menuAndCount[0];
            if (!isValidMenu(menu)) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 메뉴가 있습니다. 다시 입력해 주세요.");
            }
        }
    }

    private static void validateOrderAmount(String input) {
        String[] items = input.split(",");
        int orderAmount = 0;
        for (String item : items) {
            String[] parts = item.split("-");
            orderAmount += Integer.parseInt(parts[1]);
            }
        if(orderAmount > 20) {
            throw new IllegalArgumentException("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다.");
        }
    }

    private static boolean isValidMenu(String menuName) {
        for (Constants.Menu menu : Constants.Menu.values()) {
            if (menu.getName().equalsIgnoreCase(menuName)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
    }
}
