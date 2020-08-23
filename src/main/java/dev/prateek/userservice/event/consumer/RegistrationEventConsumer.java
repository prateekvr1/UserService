package dev.prateek.userservice.event.consumer;

import dev.prateek.userservice.event.SuccessfullRegistrationEvent;
import dev.prateek.userservice.model.User;
import dev.prateek.userservice.model.VerificationToken;
import dev.prateek.userservice.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class RegistrationEventConsumer implements ApplicationListener<SuccessfullRegistrationEvent> {

    @Autowired
    VerificationTokenRepository verificationTokenRepository;
    @Override
    public void onApplicationEvent(SuccessfullRegistrationEvent successfullRegistrationEvent) {
        User registeredUser=successfullRegistrationEvent.getRegisteredUser();
        VerificationToken verificationToken=new VerificationToken(registeredUser);
        verificationTokenRepository.save(verificationToken);


    }
}
