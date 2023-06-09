package com.carsharing.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public final class UserRequestDto {
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
