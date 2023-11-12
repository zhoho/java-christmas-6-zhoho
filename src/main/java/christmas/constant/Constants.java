package christmas.constant;

public class Constants {
    public enum Menu {
        APPETIZER_YANGSONGISOUP("양송이수프", 6000),
        APPETIZER_TAPAS("타파스", 5500),
        APPETIZER_CAESARSALAD("시저샐러드", 8000),

        MAIN_TIBONESTEAK("티본스테이크", 55000),
        MAIN_BBQRIB("바비큐립", 54000),
        MAIN_SEAFOODPASTA("해산물파스타", 35000),
        MAIN_CHRISTMASPASTA("크리스마스파스타", 25000),

        DESSERT_CHOCOCAKE("초코케이크", 15000),
        DESSERT_ICECREAM("아이스크림", 5000),

        BEVERAGE_ZEROCOLA("제로콜라", 3000),
        BEVERAGE_REDWINE("레드와인", 60000),
        BEVERAGE_CHAMPAGNE("샴페인", 25000);

        private final String name;
        private final int price;

        Menu(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }

}
