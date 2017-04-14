package to.lova.vaadin.bootstrap;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class Navbar extends CssLayout implements BootstrapUtilities {

    private static final String BG = "bg-";

    private static final String TOGGLEABLE = "toggleable-";

    protected String style = "light";

    protected String background = "faded";

    protected String toggleableBreakpoint = "md";

    public Navbar(Component... children) {
        super(children);
        this.setPrimaryStyleName("navbar");
        this.addStyleName(this.style);
        this.addStyleName(BG + this.background);
        this.addStyleName(TOGGLEABLE + this.toggleableBreakpoint);
    }

    public void setStyle(String style) {
        this.removeStyleName(this.style);
        this.style = style;
        this.addStyleName(this.style);
    }

    public void setBackground(String background) {
        this.removeStyleName(BG + this.background);
        this.background = background;
        this.addStyleName(BG + this.background);
    }

    public void setToggleableBreakpoint(String toggleableBreakpoint) {
        this.removeStyleName(TOGGLEABLE + this.toggleableBreakpoint);
        this.toggleableBreakpoint = toggleableBreakpoint;
        this.addStyleName(TOGGLEABLE + this.toggleableBreakpoint);
    }

    public Navbar addBrand(Component component) {
        component.addStyleName("navbar-brand");
        this.addComponentAsFirst(component);
        return this;
    }

    public Navbar addNav(Nav nav) {
        nav.setPrimaryStyleName("navbar-nav");
        this.addComponent(nav);
        return this;
    }

}
