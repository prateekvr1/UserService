package dev.prateek.userservice.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDto {
    private long id;
    private String fullname;
    private String email;
    private boolean active;

    public UserResponseDto(long id, String fullname, String email, boolean active) {
        this.id = id;
        this.fullname = fullname;
        this.email = email;
        this.active = active;
    }
}
