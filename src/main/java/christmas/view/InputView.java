package christmas.view;
import camp.nextstep.edu.missionutils.Console;
import christmas.constant.Constants;
import christmas.constant.ErrorMessage;
import christmas.constant.Numbers;

public class InputView {
    public enum PrintInputMessage {
        INPUTDATE("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)"),
        INPUTMENUWITHAMOUNT("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)"),
        ;
        private final String label;

        PrintInputMessage(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }

    private static final String menuSplit = ",";
    private static final String amoutSplit = "-";

    public static int readDate() {
        while (true) {
            System.out.println(PrintInputMessage.INPUTDATE.label());
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
            System.out.println(PrintInputMessage.INPUTMENUWITHAMOUNT.label());
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
            if (date < Numbers.STARTDATE || date > Numbers.ENDDATE) {
                throw new IllegalArgumentException(ErrorMessage.PrintErrorMessage.INVAILDDATE.label());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.PrintErrorMessage.INVAILDDATE.label());
        }
    }

    private static void validateMenuFormat(String input) {
        String[] items = input.split(menuSplit);
        for (String item : items) {
            String[] parts = item.split(amoutSplit);
            if (!isNumeric(parts[1].trim())) {
                throw new IllegalArgumentException(ErrorMessage.PrintErrorMessage.INVAILDORDER.label());
            }
        }
    }

    private static void validateValidMenu(String input) {
        String[] orders = input.split(menuSplit);
        for (String order : orders) {
            String[] menuAndCount = order.split(amoutSplit);
            String menu = menuAndCount[Numbers.ZERO];
            if (!isValidMenu(menu)) {
                throw new IllegalArgumentException(ErrorMessage.PrintErrorMessage.INVAILDMENU.label());
            }
        }
    }

    private static void validateOrderAmount(String input) {
        String[] items = input.split(menuSplit);
        int orderAmount = Numbers.ZERO;
        for (String item : items) {
            String[] parts = item.split(amoutSplit);
            orderAmount += Integer.parseInt(parts[1]);
            }
        if(orderAmount > Numbers.AMOUNTLIMIT) {
            throw new IllegalArgumentException(ErrorMessage.PrintErrorMessage.INVAILDAMOUNT.label());
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
