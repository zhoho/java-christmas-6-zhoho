package christmas.constant;

public class ErrorMessage {
    public enum PrintErrorMessage {
        INVAILDDATE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),

        INVAILDMENU("[ERROR] 유효하지 않은 메뉴가 있습니다. 다시 입력해 주세요."),
        INVAILDAMOUNT("[ERROR] 메뉴는 한 번에 최대 20개까지만 주문할 수 있습니다."),
        INVAILDONLYDRINK("[ERROR] 음료만 주문 시, 주문할 수 없습니다."),
        INVAILDORDER("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."),
        ;
        private final String label;

        PrintErrorMessage(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }
}