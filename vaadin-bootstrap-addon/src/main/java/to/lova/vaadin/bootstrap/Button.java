package to.lova.vaadin.bootstrap;

import com.vaadin.server.Resource;

import to.lova.vaadin.bootstrap.utility.BootstrapUtilities;

@SuppressWarnings("serial")
public class Button extends com.vaadin.ui.Button implements BootstrapUtilities {

    protected String context;

    protected String size;

    protected boolean block = false;

    protected boolean outline = false;

    public Button() {
        super();
        this.setPrimaryStyleName("btn");
        this.setContext("primary");
    }

    public Button(Resource icon) {
        super(icon);
        this.setPrimaryStyleName("btn");
        this.setContext("primary");

    }

    public Button(String caption, ClickListener listener) {
        super(caption, listener);
        this.setPrimaryStyleName("btn");
        this.setContext("primary");
    }

    public Button(String caption, Resource icon) {
        super(caption, icon);
        this.setPrimaryStyleName("btn");
        this.setContext("primary");
    }

    public Button(String caption) {
        super(caption);
        this.setPrimaryStyleName("btn");
        this.setContext("primary");
    }

    public void setSize(String size) {
        if (this.size != null) {
            this.removeStyleName(this.size);
        }
        this.size = size;
        if (this.size != null) {
            this.addStyleName(this.size);
        }
    }

    public void setBlock(boolean block) {
        if (this.block) {
            this.removeStyleName("block");
        }
        this.block = block;
        if (this.block) {
            this.addStyleName("block");
        }
    }

    public void setOutline(boolean outline) {
        if (this.outline) {
            this.removeStyleName("outline-" + this.context);
            this.addStyleName(this.context);
        } else {
            this.addStyleName("outline-" + this.context);
            this.removeStyleName(this.context);
        }
        this.outline = outline;
    }

    public void setContext(String context) {
        if (this.outline) {
            this.removeStyleName("outline-" + this.context);
        } else {
            this.removeStyleName(this.context);
        }
        this.context = context;
        if (this.outline) {
            this.addStyleName("outline-" + this.context);
        } else {
            this.addStyleName(this.context);
        }
    }

}
