package to.lova.vaadin.bootstrap.client;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.connectors.AbstractFocusableListingConnector;
import com.vaadin.client.data.DataSource;
import com.vaadin.client.ui.HasRequiredIndicator;
import com.vaadin.shared.data.selection.MultiSelectServerRpc;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.optiongroup.CheckBoxGroupState;

import elemental.json.JsonObject;
import to.lova.vaadin.bootstrap.CheckBoxGroup;

@Connect(CheckBoxGroup.class)
@SuppressWarnings("serial")
public class CheckBoxGroupConnector extends AbstractFocusableListingConnector<CheckBoxGroupWidget>
        implements HasRequiredIndicator {

    @Override
    protected void init() {
        super.init();
        getWidget().addSelectionChangeHandler(this::selectionChanged);
    }

    private void selectionChanged(JsonObject changedItem, Boolean selected) {
        MultiSelectServerRpc rpc = getRpcProxy(MultiSelectServerRpc.class);
        String key = getRowKey(changedItem);
        HashSet<String> change = new HashSet<>();
        change.add(key);
        if (Boolean.TRUE.equals(selected)) {
            rpc.updateSelection(change, Collections.emptySet());
        } else {
            rpc.updateSelection(Collections.emptySet(), change);
        }
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setTabIndex(getState().tabIndex);
        getWidget().setReadonly(isReadOnly());
        getWidget().client = getConnection();
    }

    @Override
    public void setDataSource(DataSource<JsonObject> dataSource) {
        dataSource.addDataChangeHandler(range -> updateOptionGroup());
        super.setDataSource(dataSource);
    }

    private void updateOptionGroup() {
        List<JsonObject> items = new ArrayList<>(getDataSource().size());
        for (int i = 0; i < getDataSource().size(); ++i) {
            JsonObject item = getDataSource().getRow(i);
            items.add(item);
        }
        getWidget().buildOptions(items);
    }

    @Override
    public CheckBoxGroupState getState() {
        return (CheckBoxGroupState) super.getState();
    }

    // TODO remove once this extends AbstractMultiSelectConnector
    @Override
    public boolean isRequiredIndicatorVisible() {
        return getState().required && !isReadOnly();
    }
}
