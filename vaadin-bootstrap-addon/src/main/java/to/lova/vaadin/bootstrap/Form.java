package to.lova.vaadin.bootstrap;

import com.vaadin.ui.CssLayout;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class Form extends CssLayout implements BootstrapUtilities {

    private static final String INLINE = "inline";

    protected boolean inline = false;

    public Form() {
        this.setPrimaryStyleName("form");
    }

    public boolean isInline() {
        return this.inline;
    }

    public void setInline(boolean inline) {
        if (this.inline) {
            this.removeStyleName(INLINE);
        }
        this.inline = inline;
        if (this.inline) {
            this.addStyleName(INLINE);
        }
    }

    public FormGroup newGroup() {
        FormGroup formGroup = new FormGroup();
        this.addComponent(formGroup);
        return formGroup;
    }

}
