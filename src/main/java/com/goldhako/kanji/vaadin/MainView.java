package com.goldhako.kanji.vaadin;

import com.goldhako.kanji.po.Customer;
import com.goldhako.kanji.service.CustomerService;
import com.goldhako.kanji.service.impl.CustomerServiceImpl;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Route("")
public class MainView extends VerticalLayout {

    private CustomerService customerService;

    private Grid<Customer> grid = new Grid<>();

    private TextField filterText = new TextField();
    public MainView(CustomerService customerService) {
        this.customerService=customerService;
        customerService.findAll();
        filterText.setPlaceholder("Filter by name...");
        filterText.setValueChangeMode(ValueChangeMode.EAGER);
        filterText.addValueChangeListener(e -> updateList());
        Button clearFilterTextBtn = new Button(
                new Icon(VaadinIcon.CLOSE_CIRCLE));
        clearFilterTextBtn.addClickListener(e -> filterText.clear());
        HorizontalLayout filtering = new HorizontalLayout(filterText,
                clearFilterTextBtn);




        Button button = new Button("Click me",
                event -> Notification.show("Clicked!"));
        add(button);
        grid.setSizeFull();

        grid.addColumn(Customer::getFirstName).setHeader("First name");
        grid.addColumn(Customer::getLastName).setHeader("Last name");
        grid.addColumn(Customer::getStatus).setHeader("Status");
        add(filtering,grid);
        setHeight("100vh");
        updateList();
    }
    public void updateList() {
        grid.setItems(customerService.findAll());
    }
}