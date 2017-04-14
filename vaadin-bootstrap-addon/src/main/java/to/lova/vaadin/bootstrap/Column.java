package to.lova.vaadin.bootstrap;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class Column extends CssLayout implements BootstrapUtilities {

    public Column(Component... children) {
        super(children);
        this.setPrimaryStyleName("col");
    }

    public void setSize(int size) {
        this.removeStyleNamesStartingWith("col-");
        this.addStyleName("col-" + size);
    }

}
