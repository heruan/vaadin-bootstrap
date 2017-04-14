package to.lova.vaadin.bootstrap;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class Row extends CssLayout implements BootstrapUtilities {

    public Row(Component... children) {
        super(children);
        this.setPrimaryStyleName("row");
    }

    public Column newColumn(Component... components) {
        Column column = new Column(components);
        this.addComponent(column);
        return column;
    }

}
