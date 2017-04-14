package to.lova.vaadin.bootstrap;

import java.util.Collection;

import com.vaadin.data.provider.DataProvider;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class RadioButtonGroup<T> extends com.vaadin.ui.RadioButtonGroup<T> implements BootstrapUtilities {

    public RadioButtonGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

    public RadioButtonGroup(String caption, Collection<T> items) {
        super(caption, items);
        // TODO Auto-generated constructor stub
    }

    public RadioButtonGroup(String caption, DataProvider<T, ?> dataProvider) {
        super(caption, dataProvider);
        // TODO Auto-generated constructor stub
    }

    public RadioButtonGroup(String caption) {
        super(caption);
        // TODO Auto-generated constructor stub
    }

}