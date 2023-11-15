package christmas.constant;

public class Constants {
    public enum Menu {
        APPETIZER_YANGSONGISOUP("양송이수프", 6000, MenuType.APPETIZER),
        APPETIZER_TAPAS("타파스", 5500, MenuType.APPETIZER),
        APPETIZER_CAESARSALAD("시저샐러드", 8000, MenuType.APPETIZER),

        MAIN_TIBONESTEAK("티본스테이크", 55000, MenuType.MAIN),
        MAIN_BBQRIB("바비큐립", 54000, MenuType.MAIN),
        MAIN_SEAFOODPASTA("해산물파스타", 35000, MenuType.MAIN),
        MAIN_CHRISTMASPASTA("크리스마스파스타", 25000, MenuType.MAIN),

        DESSERT_CHOCOCAKE("초코케이크", 15000, MenuType.DESSERT),
        DESSERT_ICECREAM("아이스크림", 5000, MenuType.DESSERT),

        BEVERAGE_ZEROCOLA("제로콜라", 3000, MenuType.BEVERAGE),
        BEVERAGE_REDWINE("레드와인", 60000, MenuType.BEVERAGE),
        BEVERAGE_CHAMPAGNE("샴페인", 25000, MenuType.BEVERAGE);

        private final String name;
        private final int price;
        private final MenuType type;

        Menu(String name, int price, MenuType type) {
            this.name = name;
            this.price = price;
            this.type = type;
        }


        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
        public MenuType getType() {
            return type;
        }
    }

    public enum MenuType {
        MAIN,
        DESSERT,
        BEVERAGE,
        APPETIZER
    }
    public static int getPriceForMenu(String menuName) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(menuName)) {
                return menu.getPrice();
            }
        }
        throw new IllegalArgumentException(ErrorMessage.PrintErrorMessage.INVAILDORDER.label());
    }

}
