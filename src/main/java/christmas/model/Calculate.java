package christmas.model;

import christmas.constant.Constants;

public class Calculate {
    static int originTotalPrice = 0;
    public static void getOriginTotalPrice(String itemMenu, int quantity) {
        try {
            int price = Constants.getPriceForMenu(itemMenu);
            originTotalPrice += price * quantity;
//            System.out.println(itemMenu + "의 가격은 " + price + "원입니다.");
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 입력한 메뉴는 없습니다");
        }
    }

    public static int getOriginTotalPrice() {
        return originTotalPrice;
    }
}


