package to.lova.vaadin.bootstrap;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class TextField extends com.vaadin.ui.TextField implements BootstrapUtilities {

    public TextField() {
        super();
        this.setPrimaryStyleName("form-control");
    }

    public TextField(String caption, String value, ValueChangeListener<String> valueChangeListener) {
        super(caption, value, valueChangeListener);
        this.setPrimaryStyleName("form-control");
    }

    public TextField(String caption, String value) {
        super(caption, value);
        this.setPrimaryStyleName("form-control");
    }

    public TextField(String caption, ValueChangeListener<String> valueChangeListener) {
        super(caption, valueChangeListener);
        this.setPrimaryStyleName("form-control");
    }

    public TextField(String caption) {
        super(caption);
        this.setPrimaryStyleName("form-control");
    }

    public TextField(ValueChangeListener<String> valueChangeListener) {
        super(valueChangeListener);
        this.setPrimaryStyleName("form-control");
    }

}
