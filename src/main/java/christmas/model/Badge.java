package christmas.model;

import christmas.constant.Numbers;
import christmas.view.OutputView;

public class Badge {
    public enum PrintBadge {
        SANTA("산타"),
        TREE("트리"),
        STAR("별"),
        ;

        private String label;

        PrintBadge(String label) {
            this.label = label;
        }

        public String label() {
            return label;
        }
    }
    public static String eventBadge() {
        if(OutputView.getCalculateTotalBeneit() >= Numbers.SANTALINE){
            return PrintBadge.SANTA.label();
        }
        else if(OutputView.getCalculateTotalBeneit() >= Numbers.TREELINE) {
            return PrintBadge.TREE.label();
        }
        else if(OutputView.getCalculateTotalBeneit() >= Numbers.STARLINE) {
            return PrintBadge.STAR.label();
        }
        return OutputView.PrintOutputMessage.X.label();
    }
}
