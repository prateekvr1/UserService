package dev.prateek.userservice.service;

import dev.prateek.userservice.dto.Userdto;
import dev.prateek.userservice.event.SuccessfullRegistrationEvent;
import dev.prateek.userservice.model.User;
import dev.prateek.userservice.model.VerificationToken;
import dev.prateek.userservice.repository.UserRepository;
import dev.prateek.userservice.repository.VerificationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    VerificationTokenRepository verificationTokenRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder(12);


    @Override
    public User registerUser(Userdto userdto) {
        if (userRepository.findByEmail(userdto.getEmail()) != null) {//TODO throw exceptions
        }
            User user = new User();
            user.setEmail(userdto.getEmail());
            user.setFullname(userdto.getFullName());
            user.setActive(false);
            user.setPassword(passwordEncoder.encode(userdto.getPassword()));
            User saveduser = userRepository.save(user);
            applicationEventPublisher.publishEvent(new SuccessfullRegistrationEvent(saveduser));
            return saveduser;
        }

    @Override
    public User validateUser(String token) {
        VerificationToken verificationToken=verificationTokenRepository.findByToken(token);
        if(verificationToken==null)
            return null;
        if (verificationToken.getExpirytime().getTime()-new Date().getTime()>0){
            User verifiedUser=verificationToken.getUser();
            verifiedUser.setActive(true);
            userRepository.save(verifiedUser);
            verificationTokenRepository.delete(verificationToken);
            return verifiedUser;

        }
        else{return null;}

    }
}

