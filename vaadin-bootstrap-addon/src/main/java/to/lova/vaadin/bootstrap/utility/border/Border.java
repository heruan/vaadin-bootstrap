package to.lova.vaadin.bootstrap.utility.border;

import com.vaadin.ui.Component;

public interface Border extends Component {

    public static final String BORDER = "border-0";

    public static final String BORDER_TOP = "border-top-0";

    public static final String BORDER_RIGHT = "border-right-0";

    public static final String BORDER_BOTTOM = "border-bottom-0";

    public static final String BORDER_LEFT = "border-left-0";

    default void removeBorder() {
        this.addStyleName(BORDER);
    }

    default void removeBorderTop() {
        this.addStyleName(BORDER_TOP);
    }

    default void removeBorderRight() {
        this.addStyleName(BORDER_RIGHT);
    }

    default void removeBorderBottom() {
        this.addStyleName(BORDER_BOTTOM);
    }

    default void removeBorderLeft() {
        this.addStyleName(BORDER_LEFT);
    }

    default void resetBorder() {
        this.removeStyleName(BORDER);
    }

    default void resetBorderTop() {
        this.removeStyleName(BORDER_TOP);
    }

    default void resetBorderRight() {
        this.removeStyleName(BORDER_RIGHT);
    }

    default void resetBorderBottom() {
        this.removeStyleName(BORDER_BOTTOM);
    }

    default void resetBorderLeft() {
        this.removeStyleName(BORDER_LEFT);
    }

}
