package org.sangtran.dto;

import jakarta.validation.constraints.Email;

public class AddCustomerDto {
    @Email
    public String email;
    @Override
    public String toString() {
        return email;
    }
}
