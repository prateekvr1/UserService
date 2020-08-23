package dev.prateek.userservice.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany
    @JoinTable(name="role_perm",joinColumns = @JoinColumn(name="role_id",referencedColumnName = "id"),inverseJoinColumns = @JoinColumn(name="perm_id",referencedColumnName = "id"))
    private List<Permission> permissionList;
    @ManyToMany(fetch= FetchType.LAZY,mappedBy = "rolesList")
    private List<User> userList;
}
