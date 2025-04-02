package org.webservice.api.domain;

import org.webservice.api.persistence.entity.Roles;

import java.time.LocalDateTime;
import java.util.List;

public class UsersDto {
    private Long userId;
    private String userName;
    private String userEmail;
    private String userPassword;
    private boolean userLocked;
    private boolean userDisabled;
    private LocalDateTime userCreated;
    private List<Roles> roles;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public boolean isUserLocked() {
        return userLocked;
    }

    public void setUserLocked(boolean userLocked) {
        this.userLocked = userLocked;
    }

    public boolean isUserDisabled() {
        return userDisabled;
    }

    public void setUserDisabled(boolean userDisabled) {
        this.userDisabled = userDisabled;
    }

    public LocalDateTime getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(LocalDateTime userCreated) {
        this.userCreated = userCreated;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }
}
