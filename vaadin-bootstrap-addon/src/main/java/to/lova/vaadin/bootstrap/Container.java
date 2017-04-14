package to.lova.vaadin.bootstrap;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class Container extends CssLayout implements BootstrapUtilities {

    protected boolean fluid = false;

    public Container(Component... children) {
        super(children);
        this.setPrimaryStyleName("container");
    }

    public boolean isFluid() {
        return this.fluid;
    }

    public void setFluid(boolean fluid) {
        this.fluid = fluid;
        if (this.fluid) {
            this.setPrimaryStyleName("container-fluid");
        } else {
            this.setPrimaryStyleName("container");
        }
    }

    public Row newRow() {
        Row row = new Row();
        this.addComponent(row);
        return row;
    }

}
