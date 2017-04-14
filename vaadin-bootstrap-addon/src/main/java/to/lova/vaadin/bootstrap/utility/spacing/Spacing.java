package to.lova.vaadin.bootstrap.utility.spacing;

import com.vaadin.ui.Component;

public interface Spacing extends Component {

    public static final String AUTO = "auto";

    public static final String SEPARATOR = "-";

    public static final String MARGIN = "m";

    public static final String PADDING = "p";

    public static final String TOP = "t" + SEPARATOR;

    public static final String RIGHT = "r" + SEPARATOR;

    public static final String BOTTOM = "b" + SEPARATOR;

    public static final String LEFT = "l" + SEPARATOR;

    public static final String HORIZONTAL = "x" + SEPARATOR;

    public static final String VERTICAL = "y" + SEPARATOR;

    default void setMargin(int size) {
        this.resetMargin();
        this.addStyleName(MARGIN + SEPARATOR + size);
    }

    default void setMarginTop(int size) {
        this.resetMarginTop();
        this.addStyleName(MARGIN + TOP + size);
    }

    default void setMarginRight(int size) {
        this.resetMarginRight();
        this.addStyleName(MARGIN + RIGHT + size);
    }

    default void setMarginRightAuto() {
        this.resetMarginRight();
        this.addStyleName(MARGIN + RIGHT + AUTO);
    }

    default void setMarginBottom(int size) {
        this.resetMarginBottom();
        this.addStyleName(MARGIN + BOTTOM + size);
    }

    default void setMarginLeft(int size) {
        this.resetMarginLeft();
        this.addStyleName(MARGIN + LEFT + size);
    }

    default void setMarginLeftAuto() {
        this.resetMarginLeft();
        this.addStyleName(MARGIN + LEFT + AUTO);
    }

    default void setMarginHorizontal(int size) {
        this.resetMarginHorizontal();
        this.addStyleName(MARGIN + HORIZONTAL + size);
    }

    default void setMarginHorizontalAuto() {
        this.resetMarginHorizontal();
        this.addStyleName(MARGIN + HORIZONTAL + AUTO);
    }

    default void setMarginVertical(int size) {
        this.resetMarginVertical();
        this.addStyleName(MARGIN + VERTICAL + size);
    }

    default void resetMargin() {
        this.removeStyleNamesStartingWith(MARGIN + SEPARATOR);
    }

    default void resetMarginTop() {
        this.removeStyleNamesStartingWith(MARGIN + TOP);
    }

    default void resetMarginRight() {
        this.removeStyleNamesStartingWith(MARGIN + RIGHT);
    }

    default void resetMarginBottom() {
        this.removeStyleNamesStartingWith(MARGIN + BOTTOM);
    }

    default void resetMarginLeft() {
        this.removeStyleNamesStartingWith(MARGIN + LEFT);
    }

    default void resetMarginHorizontal() {
        this.removeStyleNamesStartingWith(MARGIN + HORIZONTAL);
    }

    default void resetMarginVertical() {
        this.removeStyleNamesStartingWith(MARGIN + VERTICAL);
    }

    default void setPadding(int size) {
        this.resetPadding();
        this.addStyleName(PADDING + SEPARATOR + size);
    }

    default void setPaddingTop(int size) {
        this.resetPaddingTop();
        this.addStyleName(PADDING + TOP + size);
    }

    default void setPaddingRight(int size) {
        this.resetPaddingRight();
        this.addStyleName(PADDING + RIGHT + size);
    }

    default void setPaddingBottom(int size) {
        this.resetPaddingBottom();
        this.addStyleName(PADDING + BOTTOM + size);
    }

    default void setPaddingLeft(int size) {
        this.resetPaddingLeft();
        this.addStyleName(PADDING + LEFT + size);
    }

    default void setPaddingHorizontal(int size) {
        this.resetPaddingHorizontal();
        this.addStyleName(PADDING + HORIZONTAL + size);
    }

    default void setPaddingVertical(int size) {
        this.resetPaddingVertical();
        this.addStyleName(PADDING + VERTICAL + size);
    }

    default void resetPadding() {
        this.removeStyleNamesStartingWith(PADDING + SEPARATOR);
    }

    default void resetPaddingTop() {
        this.removeStyleNamesStartingWith(PADDING + TOP);
    }

    default void resetPaddingRight() {
        this.removeStyleNamesStartingWith(PADDING + RIGHT);
    }

    default void resetPaddingBottom() {
        this.removeStyleNamesStartingWith(PADDING + BOTTOM);
    }

    default void resetPaddingLeft() {
        this.removeStyleNamesStartingWith(PADDING + LEFT);
    }

    default void resetPaddingHorizontal() {
        this.removeStyleNamesStartingWith(PADDING + HORIZONTAL);
    }

    default void resetPaddingVertical() {
        this.removeStyleNamesStartingWith(PADDING + VERTICAL);
    }

    default void removeStyleNamesStartingWith(String prefix) {
        for (String styleName : this.getStyleName().split(" ")) {
            if (styleName.startsWith(prefix)) {
                this.removeStyleName(styleName);
            }
        }
    }

}
