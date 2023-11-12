package christmas.view;

public class OutputView {
    public static void printWelcomeToEvent() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
    }

    public static void printShowDateOfEvent(int date) {
        System.out.println("12월 " + date + "일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!\n");
    }

    public static void printMenuSetting() {
        System.out.println("<주문 메뉴>");
    }
    public static void printMenu(String itemName, int quantity) {
        System.out.println(itemName + " " + quantity + "개");
    }
}
