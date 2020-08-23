package dev.prateek.userservice.model;

import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@Entity
public class VerificationToken {
    public VerificationToken(){
        super();
    }
    private static final int VALIDITY_TIME=4*60;
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String token;
    @OneToOne(targetEntity =User.class)
    private     User user;
    private Date expirytime;
    public VerificationToken(User user){
        String token=generateRandomUniqueToken();
        this.token=token;
        this.expirytime=calculateExpiryTime();
        this.user=user;

    }
        private String generateRandomUniqueToken(){
        return UUID.randomUUID().toString();
        }
       public void updateToken(){
        this.token=generateRandomUniqueToken();
        this.expirytime=calculateExpiryTime();
       }
    private Date calculateExpiryTime(){
        Calendar calendar=Calendar.getInstance();
        Date currentTimeAndDate=new Date();
        calendar.setTimeInMillis(currentTimeAndDate.getTime());
        calendar.add(Calendar.MINUTE,VALIDITY_TIME);
        return new Date(calendar.getTime().getTime());
    }
}
