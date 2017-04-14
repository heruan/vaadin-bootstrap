package to.lova.vaadin.bootstrap;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class Nav extends CssLayout implements BootstrapUtilities {

    protected final List<Component> items = new ArrayList<>();

    public Nav(Component... components) {
        this.setPrimaryStyleName("nav");
        this.addItems(components);
    }

    public Nav addItems(Component... components) {
        for (Component component : components) {
            component.setPrimaryStyleName("nav-item nav-link");
        }
        this.addComponents(components);
        return this;
    }

}
