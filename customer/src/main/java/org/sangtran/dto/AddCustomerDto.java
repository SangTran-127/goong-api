package org.sangtran.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

public class AddCustomerDto {
    @Email
    public String email;

    @NotNull
    public String password;

    @NotNull
    public String firstName;
    @NotNull
    public String lastName;

    @Override
    public String toString() {
        return email;
    }
}
