package to.lova.vaadin.bootstrap.client;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.client.annotations.OnStateChange;
import com.vaadin.client.communication.StateChangeEvent;
import com.vaadin.client.connectors.AbstractSingleSelectConnector;
import com.vaadin.client.data.DataSource;
import com.vaadin.shared.Range;
import com.vaadin.shared.Registration;
import com.vaadin.shared.data.selection.SelectionServerRpc;
import com.vaadin.shared.ui.Connect;
import com.vaadin.shared.ui.optiongroup.RadioButtonGroupState;

import elemental.json.JsonObject;
import to.lova.vaadin.bootstrap.RadioButtonGroup;

@Connect(RadioButtonGroup.class)
@SuppressWarnings("serial")
public class RadioButtonGroupConnector extends AbstractSingleSelectConnector<RadioButtonGroupWidget> {

    private Registration selectionChangeRegistration;
    private Registration dataChangeRegistration;

    private final SelectionServerRpc selectionRpc = getRpcProxy(SelectionServerRpc.class);

    @Override
    protected void init() {
        super.init();

        this.selectionChangeRegistration = getWidget().addSelectionChangeHandler(e -> this.selectionRpc.select(getRowKey(e)));
    }

    @Override
    public void onUnregister() {
        super.onUnregister();
        this.selectionChangeRegistration.remove();
        this.selectionChangeRegistration = null;
    }

    @Override
    public void onStateChanged(StateChangeEvent stateChangeEvent) {
        super.onStateChanged(stateChangeEvent);
        getWidget().setTabIndex(getState().tabIndex);
        getWidget().client = getConnection();
    }

    @Override
    public void setDataSource(DataSource<JsonObject> dataSource) {
        if (this.dataChangeRegistration != null) {
            this.dataChangeRegistration.remove();
        }
        this.dataChangeRegistration = dataSource.addDataChangeHandler(this::onDataChange);
        super.setDataSource(dataSource);
    }

    @OnStateChange("readOnly")
    void updateWidgetReadOnly() {
        getWidget().setEnabled(isEnabled() && !isReadOnly());
    }

    @OnStateChange("selectedItemKey")
    void updateSelectedItem() {
        getWidget().selectItemKey(getState().selectedItemKey);
    }

    @Override
    public RadioButtonGroupState getState() {
        return (RadioButtonGroupState) super.getState();
    }

    /**
     * A data change handler registered to the data source. Updates the data
     * items and selection status when the data source notifies of new changes
     * from the server side.
     *
     * @param range
     *            the new range of data items
     */
    private void onDataChange(Range range) {
        assert range.getStart() == 0
                && range.getEnd() == getDataSource().size() : "RadioButtonGroup only supports full updates, but " + "got range "
                        + range;

        final RadioButtonGroupWidget select = getWidget();
        DataSource<JsonObject> dataSource = getDataSource();
        int size = dataSource.size();
        List<JsonObject> options = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            options.add(dataSource.getRow(i));
        }
        select.buildOptions(options);
        updateSelectedItem();
    }

}
