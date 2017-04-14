package to.lova.vaadin.bootstrap.utility.clearfix;

import com.vaadin.ui.Component;

public interface Clearfix extends Component {

    public static final String CLEARFIX = "clearfix";

    default void setClearfix(boolean clearfix) {
        if (clearfix) {
            this.addStyleName(CLEARFIX);
        } else {
            this.removeStyleName(CLEARFIX);
        }
    }

}
