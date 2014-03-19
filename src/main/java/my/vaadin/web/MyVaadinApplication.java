package my.vaadin.web;

import com.vaadin.Application;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Window;
import my.vaadin.web.api.IWebController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * The Application's "main" class
 */
@Component("my.vaadin.web.MyVaadinApplication")
@Scope(value = "prototype")
public class MyVaadinApplication extends Application
{
    private Window window;
    @Autowired
    private IWebController controller;

    @Override
    public void init()
    {
        window = new Window("My Vaadin Application");
        setMainWindow(window);
        Button button = new Button("Click Me");
        button.addListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                window.addComponent(new Label(controller.findPerson("0001").toString()));
            }
        });
        window.addComponent(button);
        
    }
    
}
