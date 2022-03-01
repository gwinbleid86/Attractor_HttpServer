package com.company.lesson44;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SampleDataModel {
    private User user = new User("Apache", "FreeMarker");
    private LocalDateTime currentDateTime = LocalDateTime.now();
    private List<User> customers = new ArrayList<>();

    public SampleDataModel() {
        customers.add(new User("Marco"));
        customers.add(new User("Winston", "Duarte"));
        customers.add(new User("Amos", "Burton", "'Timmy'"));
        customers.get(1).setEmailConfirmed(true);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(LocalDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public List<User> getCustomers() {
        return customers;
    }

    public void setCustomers(List<User> customers) {
        this.customers = customers;
    }


}
