package com.malikov.productmanager.model;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends NamedEntity {

    @Column(name = "password")
    private String password;

    @Transient
    private String confirmPassword;

    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role")
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<Role> roles;

    public User() {
    }

    public User(Integer id, String name, String password, Role... roles) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.roles = new HashSet<>();
        Collections.addAll(this.roles, roles);
    }

    public User(String name, String password, Role... roles) {
        this(null, name, password, roles);
    }

    public User(User u){
        this(u.getId(), u.getName(), u.getPassword (), u.getRoles().toArray(new Role[0]));
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {

        this.confirmPassword = confirmPassword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        if (!super.equals(o)) return false;
        User user = (User) o;
        return Objects.equals(password, user.password) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), password, roles);
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + name + '\'' +
                ", roles=" + roles +
                '}';
    }
}
