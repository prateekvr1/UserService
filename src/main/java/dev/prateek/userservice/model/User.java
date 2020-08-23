package dev.prateek.userservice.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String fullname;
    private String password;
    private boolean active;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_role",joinColumns = @JoinColumn(name="user_id" ,referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"))
    private List<Roles> rolesList;
    private String email;
}
