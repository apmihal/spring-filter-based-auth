package org.launchcode.springfilterbasedauth.models.forms;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class DogForm {

    @NotNull
    @Pattern(regexp = "[a-zA-Z][a-zA-Z0-9_-]{4,11}", message = "Dog names must be between 5 and 12 characters, start with a letter, and contain only letters and numbers")
    private String name;

    public DogForm() { }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
