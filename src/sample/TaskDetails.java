package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.Date;
import java.time.LocalDate;

public class TaskDetails {

    private StringProperty taskName;
    private StringProperty taskDate;
    private StringProperty category;

    public TaskDetails(String name,String date,String cat)
    {
        this.taskName = new SimpleStringProperty(name);
        this.taskDate = new SimpleStringProperty(date);
        this.category = new SimpleStringProperty(cat);
    }
    //Getters


    public String getCategory() {
        return category.get();
    }

    public String getTaskName() {
        return taskName.get();
    }

    public String getTaskDate() {
        return taskDate.get();
    }

    //Setters
    public void setTaskDate(String taskDate) {
        this.taskDate.set(taskDate);
    }

    public void setCategory(String category) {
        this.category.set(category);
    }



    public void setTaskName(String taskName) {
        this.taskName.set(taskName);
    }

    public StringProperty categoryProperty() {
        return category;
    }

    public StringProperty taskNameProperty() {
        return taskName;
    }

    public StringProperty taskDateProperty() {
        return taskDate;
    }
}
