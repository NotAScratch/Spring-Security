package com.example.fullstack.event;

import com.example.fullstack.entities.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

@Getter
@Setter
public class RegistrationCompleteEvent extends ApplicationEvent {

    private User user;
    private String conformationUrl;

    public RegistrationCompleteEvent(User user, String confomrationUrl) {
        super(user);
        this.user = user;
        this.conformationUrl = confomrationUrl;
    }
}
