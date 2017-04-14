package to.lova.vaadin.bootstrap.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

import com.google.gwt.aria.client.Roles;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.ui.FocusWidget;
import com.google.gwt.user.client.ui.HasEnabled;
import com.google.gwt.user.client.ui.Widget;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.BrowserInfo;
import com.vaadin.client.WidgetUtil;
import com.vaadin.client.ui.Field;
import com.vaadin.client.ui.Icon;
import com.vaadin.client.widgets.FocusableFlowPanelComposite;
import com.vaadin.shared.Registration;
import com.vaadin.shared.data.DataCommunicatorConstants;
import com.vaadin.shared.ui.ListingJsonConstants;

import elemental.json.JsonObject;

public class RadioButtonGroupWidget extends FocusableFlowPanelComposite implements Field, ClickHandler, HasEnabled {

    public static final String CLASSNAME = "v-select-optiongroup";
    public static final String CLASSNAME_OPTION = "v-select-option";

    private final Map<RadioButtonWidget, JsonObject> optionsToItems;
    private final Map<String, RadioButtonWidget> keyToOptions;

    /**
     * For internal use only. May be removed or replaced in the future.
     */
    public ApplicationConnection client;

    private boolean htmlContentAllowed = false;

    private boolean enabled;
    private boolean readonly;
    private final String groupId;
    private List<Consumer<JsonObject>> selectionChangeListeners;

    public RadioButtonGroupWidget() {
        this.groupId = DOM.createUniqueId();
        getWidget().setStyleName(CLASSNAME);
        this.optionsToItems = new HashMap<>();
        this.keyToOptions = new HashMap<>();
        this.selectionChangeListeners = new ArrayList<>();
    }

    /*
     * Build all the options
     */
    public void buildOptions(List<JsonObject> items) {
        Roles.getRadiogroupRole().set(getElement());
        int i = 0;
        int widgetsToRemove = getWidget().getWidgetCount() - items.size();
        if (widgetsToRemove < 0) {
            widgetsToRemove = 0;
        }
        List<Widget> remove = new ArrayList<>(widgetsToRemove);
        for (Widget widget : getWidget()) {
            if (i < items.size()) {
                updateItem((RadioButtonWidget) widget, items.get(i), false);
                i++;
            } else {
                remove.add(widget);
            }
        }
        remove.stream().forEach(this::remove);
        while (i < items.size()) {
            updateItem(new RadioButtonWidget(this.groupId), items.get(i), true);
            i++;
        }
    }

    private void remove(Widget widget) {
        getWidget().remove(widget);
        JsonObject item = this.optionsToItems.remove(widget);
        if (item != null) {
            String key = item.getString(DataCommunicatorConstants.KEY);
            this.keyToOptions.remove(key);
        }
    }

    private void updateItem(RadioButtonWidget button, JsonObject item, boolean requireInitialization) {
        String itemHtml = item.getString(ListingJsonConstants.JSONKEY_ITEM_VALUE);
        if (!isHtmlContentAllowed()) {
            itemHtml = WidgetUtil.escapeHTML(itemHtml);
        }

        String iconUrl = item.getString(ListingJsonConstants.JSONKEY_ITEM_ICON);
        if (iconUrl != null && iconUrl.length() != 0) {
            Icon icon = this.client.getIcon(iconUrl);
            itemHtml = icon.getElement().getString() + itemHtml;
        }

        button.setHTML(itemHtml);
        button.setValue(item.getBoolean(ListingJsonConstants.JSONKEY_ITEM_SELECTED));
        boolean optionEnabled = !item.getBoolean(ListingJsonConstants.JSONKEY_ITEM_DISABLED);
        boolean enabled = optionEnabled && !isReadonly() && isEnabled();
        button.setEnabled(enabled);
        String key = item.getString(DataCommunicatorConstants.KEY);

        if (requireInitialization) {
            getWidget().add(button);
            button.addStyleName(CLASSNAME_OPTION);
            button.addClickHandler(this);
        }
        this.optionsToItems.put(button, item);
        this.keyToOptions.put(key, button);
    }

    @Override
    public void onClick(ClickEvent event) {
        if (event.getSource() instanceof RadioButtonWidget) {
            RadioButtonWidget source = (RadioButtonWidget) event.getSource();
            if (!source.isEnabled()) {
                // Click events on the text are received even though the
                // radiobutton is disabled
                return;
            }
            if (BrowserInfo.get().isWebkit() || BrowserInfo.get().isIE11()) {
                // Webkit does not focus non-text input elements on click
                // (#11854)
                source.setFocus(true);
            }

            JsonObject item = this.optionsToItems.get(source);
            assert item != null;

            new ArrayList<>(this.selectionChangeListeners).forEach(listener -> listener.accept(item));
        }
    }

    public void setTabIndex(int tabIndex) {
        for (Widget anOptionsContainer : getWidget()) {
            FocusWidget widget = (FocusWidget) anOptionsContainer;
            widget.setTabIndex(tabIndex);
        }
    }

    protected void updateEnabledState() {
        boolean radioButtonEnabled = isEnabled() && !isReadonly();
        // sets options enabled according to the widget's enabled,
        // readonly and each options own enabled
        for (Map.Entry<RadioButtonWidget, JsonObject> entry : this.optionsToItems.entrySet()) {
            RadioButtonWidget radioButton = entry.getKey();
            JsonObject value = entry.getValue();
            Boolean isOptionEnabled = !value.getBoolean(ListingJsonConstants.JSONKEY_ITEM_DISABLED);
            radioButton.setEnabled(radioButtonEnabled && isOptionEnabled);
        }
    }

    public boolean isHtmlContentAllowed() {
        return this.htmlContentAllowed;
    }

    public void setHtmlContentAllowed(boolean htmlContentAllowed) {
        this.htmlContentAllowed = htmlContentAllowed;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    public boolean isReadonly() {
        return this.readonly;
    }

    public void setReadonly(boolean readonly) {
        if (this.readonly != readonly) {
            this.readonly = readonly;
            updateEnabledState();
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        if (this.enabled != enabled) {
            this.enabled = enabled;
            updateEnabledState();
        }
    }

    public Registration addSelectionChangeHandler(Consumer<JsonObject> selectionChanged) {
        this.selectionChangeListeners.add(selectionChanged);
        return (Registration) () -> this.selectionChangeListeners.remove(selectionChanged);
    }

    public void selectItemKey(String selectedItemKey) {
        RadioButtonWidget radioButton = this.keyToOptions.get(selectedItemKey);
        if (radioButton != null) {// Items might not be loaded yet
            radioButton.setValue(true);
        }
    }

}
