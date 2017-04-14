package to.lova.vaadin.bootstrap;

import java.util.Collection;

import com.vaadin.data.provider.DataProvider;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class CheckBoxGroup<T> extends com.vaadin.ui.CheckBoxGroup<T> implements BootstrapUtilities {

    public CheckBoxGroup() {
        super();
        // TODO Auto-generated constructor stub
    }

    public CheckBoxGroup(String caption, Collection<T> items) {
        super(caption, items);
        // TODO Auto-generated constructor stub
    }

    public CheckBoxGroup(String caption, DataProvider<T, ?> dataProvider) {
        super(caption, dataProvider);
        // TODO Auto-generated constructor stub
    }

    public CheckBoxGroup(String caption) {
        super(caption);
        // TODO Auto-generated constructor stub
    }

}
