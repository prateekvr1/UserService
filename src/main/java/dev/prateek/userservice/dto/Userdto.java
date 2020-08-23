package dev.prateek.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
@Setter
public class Userdto {
    @NotEmpty
    @Size(min=5)
    private String fullName;
    @NotEmpty
    @Size(min=1)
    //TODO: Implement Custom Validators

    private String email;
    @NotEmpty
    @Size(min=6)
    private String password;
}
