package to.lova.vaadin.bootstrap.demo;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

import to.lova.vaadin.bootstrap.Button;
import to.lova.vaadin.bootstrap.CheckBox;
import to.lova.vaadin.bootstrap.Column;
import to.lova.vaadin.bootstrap.Container;
import to.lova.vaadin.bootstrap.Form;
import to.lova.vaadin.bootstrap.FormGroup;
import to.lova.vaadin.bootstrap.Nav;
import to.lova.vaadin.bootstrap.Navbar;
import to.lova.vaadin.bootstrap.RadioButtonGroup;
import to.lova.vaadin.bootstrap.Row;
import to.lova.vaadin.bootstrap.TextField;

@Theme("bootstrap")
@Title("Button Add-on Demo")
@SuppressWarnings("serial")
public class DemoUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
    public static class Servlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        Container container = new Container();

        Navbar navbar = new Navbar();

        Label brand = new Label("Navbar");
        navbar.addBrand(brand);
        navbar.setMarginBottom(3);

        Nav nav = new Nav();
        nav.addItems(new Button("Home"), new Button("Link"), new Button("Disabled"));
        nav.getComponent(0).addStyleName("active");
        nav.getComponent(nav.getComponentCount() - 1).addStyleName("disabled");
        nav.setMarginRightAuto();

        navbar.addNav(nav);

        Form form = new Form();
        form.setInline(true);
        TextField search = new TextField();
        search.setMarginRight(2);
        search.setPlaceholder("Search");
        Button searchButton = new Button("Search");
        searchButton.setOutline(true);
        searchButton.setContext("success");
        form.addComponents(search, searchButton);

        navbar.addComponent(nav);
        navbar.addComponent(form);

        container.addComponent(navbar);

        Row main = container.newRow();
        Column sidebar = main.newColumn();
        sidebar.setSize(2);

        Form sidebarForm = new Form();
        CheckBox fluid = new CheckBox("Fluid");
        fluid.addValueChangeListener(event -> container.setFluid(event.getValue()));
        sidebarForm.newGroup().addComponent(fluid);

        sidebar.addComponent(sidebarForm);

        Column content = main.newColumn();

        final Button button = new Button("Button");
        button.setBlock(true);
        button.setMarginBottom(3);

        content.addComponent(button);

        RadioButtonGroup<String> radioButtonGroup = new RadioButtonGroup<>("Context",
                DataProvider.ofItems("primary", "secondary", "success", "info", "warning", "danger"));
        radioButtonGroup.setSelectedItem("primary");
        radioButtonGroup.addValueChangeListener(event -> button.setContext(event.getValue()));

        CheckBox outline = new CheckBox("Outline");
        outline.addValueChangeListener(event -> button.setOutline(event.getValue()));

        RadioButtonGroup<String> size = new RadioButtonGroup<>("Size", DataProvider.ofItems("sm", "lg", null));
        size.addValueChangeListener(event -> button.setSize(event.getValue()));

        CheckBox block = new CheckBox("Block", true);
        block.addValueChangeListener(event -> button.setBlock(event.getValue()));

        content.addComponents(new FormGroup(radioButtonGroup), new FormGroup(outline), new FormGroup(size),
                new FormGroup(block));

        this.setContent(container);
    }

}
