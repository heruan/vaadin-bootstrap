package to.lova.vaadin.bootstrap.client;

import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.InputElement;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.annotations.IsSafeHtml;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.ui.ButtonBase;
import com.google.gwt.user.client.ui.HasName;
import com.google.gwt.user.client.ui.HasValue;
import com.vaadin.client.ApplicationConnection;
import com.vaadin.client.Util;
import com.vaadin.client.ui.Field;
import com.vaadin.client.ui.Icon;
import com.vaadin.client.ui.aria.AriaHelper;
import com.vaadin.client.ui.aria.HandlesAriaInvalid;
import com.vaadin.client.ui.aria.HandlesAriaRequired;

public class RadioButtonWidget extends ButtonBase
        implements HasName, HasValue<Boolean>, Field, HandlesAriaInvalid, HandlesAriaRequired {

    /** For internal use only. May be removed or replaced in the future. */
    public String id;

    /** For internal use only. May be removed or replaced in the future. */
    public ApplicationConnection client;

    /** For internal use only. May be removed or replaced in the future. */
    public Element errorIndicatorElement;

    /** For internal use only. May be removed or replaced in the future. */
    public Icon icon;

    private final InputElement inputElement;

    private final Element indicatorElement = DOM.createSpan();

    private final Element descriptionElement = DOM.createSpan();

    public RadioButtonWidget(String name) {
        super(DOM.createLabel());
        this.inputElement = DOM.createInputRadio(name).cast();
        this.getElement().addClassName("custom-control");
        this.getElement().addClassName("custom-radio");
        this.inputElement.addClassName("custom-control-input");
        this.indicatorElement.addClassName("custom-control-indicator");
        this.descriptionElement.addClassName("custom-control-description");
        this.getElement().appendChild(this.inputElement);
        this.getElement().appendChild(this.indicatorElement);
        this.getElement().appendChild(this.descriptionElement);
    }

    @Override
    public HandlerRegistration addValueChangeHandler(ValueChangeHandler<Boolean> handler) {
        return addHandler(handler, ValueChangeEvent.getType());
    }

    @Override
    public Boolean getValue() {
        if (this.isAttached()) {
            return this.inputElement.isChecked();
        } else {
            return this.inputElement.isDefaultChecked();
        }
    }

    @Override
    public void setValue(Boolean value) {
        this.setValue(value, false);
    }

    @Override
    public void setValue(Boolean value, boolean fireEvents) {
        this.inputElement.setChecked(value);
        if (fireEvents) {
            ValueChangeEvent.fire(this, value);
        }
    }

    @Override
    public void setName(String name) {
        this.inputElement.setName(name);
    }

    @Override
    public String getName() {
        return this.inputElement.getName();
    }

    @Override
    public String getHTML() {
        return this.descriptionElement.getInnerHTML();
    }

    @Override
    public String getText() {
        return this.descriptionElement.getInnerText();
    }

    @Override
    public void setHTML(@IsSafeHtml String html) {
        this.descriptionElement.setInnerHTML(html);
    }

    @Override
    public void setHTML(SafeHtml html) {
        this.descriptionElement.setInnerSafeHtml(html);
    }

    @Override
    public void setText(String text) {
        this.descriptionElement.setInnerText(text);
    }

    @Override
    public void onBrowserEvent(Event event) {
        if (icon != null && event.getTypeInt() == Event.ONCLICK && DOM.eventGetTarget(event) == icon.getElement()) {
            // Click on icon should do nothing if widget is disabled
            if (isEnabled()) {
                setValue(!getValue());
            }
        }
        super.onBrowserEvent(event);
        if (event.getTypeInt() == Event.ONLOAD) {
            Util.notifyParentOfSizeChange(this, true);
        }
    }

    /**
     * Gives access to the input element.
     *
     * @return Element of the CheckBox itself
     */
    private Element getCheckBoxElement() {
        // FIXME: Would love to use a better way to access the checkbox element
        return getElement().getFirstChildElement();
    }

    @Override
    public void setAriaRequired(boolean required) {
        AriaHelper.handleInputRequired(getCheckBoxElement(), required);
    }

    @Override
    public void setAriaInvalid(boolean invalid) {
        AriaHelper.handleInputInvalid(getCheckBoxElement(), invalid);
    }

}
