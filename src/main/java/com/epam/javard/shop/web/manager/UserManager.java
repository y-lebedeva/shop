package com.epam.javard.shop.web.manager;

import com.epam.javard.shop.dto.User;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

@Service
@SessionScope(proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserManager {

    private User currentUser;

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
}
