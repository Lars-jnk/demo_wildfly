package de.freizeitbaltrum.lars.cdi;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import de.freizeitbaltrum.lars.cdi.entity.Person;
import de.freizeitbaltrum.lars.cdi.entity.repo.PersonRepo;
import java.util.List;
import javax.inject.Inject;

/**
 * The main view contains a simple label element and a template element.
 */
@Route("")
public class WildflyDemoView extends VerticalLayout implements BeforeEnterObserver {

    @Inject
    private MessageBean messageBean;

    @Inject
    private PersonRepo repo;

    public WildflyDemoView() {
    }

    @Override
    public void beforeEnter(BeforeEnterEvent bee) {
        update();
    }

    private void update() {
        removeAll();

        add(new H3("Personen"));
        List<Person> l = repo.findAll();
        for (Person person : l) {
            add(new Label(person.name));
        }

        add(new H3("Person anlegen"));
        TextField name = new TextField();
        Button btn = new Button("Anlegen", e -> {
            Person p = new Person();
            p.name = name.getValue();
            repo.create(p);
            update();
        });

        add(new HorizontalLayout(name, btn));
    }
}
