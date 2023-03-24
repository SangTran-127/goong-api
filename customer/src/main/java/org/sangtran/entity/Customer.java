package org.sangtran.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("customer")
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class Customer {

    @Email
    private String email;

    private String firstName;

    private String lastName;
    @JsonSerialize(using= ToStringSerializer.class)
    private ObjectId _id;
    public Customer(String email) {
        this.email = email;
    }




}

