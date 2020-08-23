package dev.prateek.userservice.model;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name="permissions")

public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(mappedBy ="permissionList")
    private List<Roles> rolesList;
}
