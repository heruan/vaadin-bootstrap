package to.lova.vaadin.bootstrap.utility.border;

import com.vaadin.ui.Component;

public interface BorderRadius extends Component {

    public static final String ROUNDED = "rounded";

    public static final String ROUNDED_TOP = "rounded-top";

    public static final String ROUNDED_RIGHT = "rounded-right";

    public static final String ROUNDED_BOTTOM = "rounded-bottom";

    public static final String ROUNDED_LEFT = "rounded-left";

    public static final String ROUNDED_CIRCLE = "rounded-circle";

    public static final String ROUNDED_NONE = "rounded-0";

    default void roundedBorder() {
        this.addStyleName(ROUNDED);
    }

    default void roundedBorderTop() {
        this.addStyleName(ROUNDED_TOP);
    }

    default void roundedBorderRight() {
        this.addStyleName(ROUNDED_RIGHT);
    }

    default void roundedBorderBottom() {
        this.addStyleName(ROUNDED_BOTTOM);
    }

    default void roundedBorderLeft() {
        this.addStyleName(ROUNDED_LEFT);
    }

    default void roundedBorderCircle() {
        this.addStyleName(ROUNDED_CIRCLE);
    }

    default void roundedBorderNone() {
        this.addStyleName(ROUNDED_NONE);
    }

    default void resetRoundedBorder() {
        this.removeStyleName(ROUNDED);
    }

    default void resetRoundedBorderTop() {
        this.removeStyleName(ROUNDED_TOP);
    }

    default void resetRoundedBorderRight() {
        this.removeStyleName(ROUNDED_RIGHT);
    }

    default void resetRoundedBorderBottom() {
        this.removeStyleName(ROUNDED_BOTTOM);
    }

    default void resetRoundedBorderLeft() {
        this.removeStyleName(ROUNDED_LEFT);
    }

    default void resetRoundedBorderCircle() {
        this.removeStyleName(ROUNDED_CIRCLE);
    }

    default void resetRoundedBorderNone() {
        this.removeStyleName(ROUNDED_NONE);
    }

}
