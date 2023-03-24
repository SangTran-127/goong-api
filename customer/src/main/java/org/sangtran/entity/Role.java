package org.sangtran.entity;

import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;

public enum Role {
    @JsonEnumDefaultValue
    USER,
    ADMIN
}
