package to.lova.vaadin.bootstrap;

import com.vaadin.ui.Component;
import com.vaadin.ui.CssLayout;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class FormGroup extends CssLayout implements BootstrapUtilities {

    public FormGroup(Component... components) {
        this.setPrimaryStyleName("form-group");
        this.addComponents(components);
    }

}
