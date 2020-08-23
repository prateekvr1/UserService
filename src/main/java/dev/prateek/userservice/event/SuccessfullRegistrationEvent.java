package dev.prateek.userservice.event;

import dev.prateek.userservice.model.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;
@Getter
@Setter
public class SuccessfullRegistrationEvent extends ApplicationEvent {
    private final User registeredUser;

    public SuccessfullRegistrationEvent(User registeredUser) {
        super(registeredUser);

        this.registeredUser = registeredUser;
    }
}