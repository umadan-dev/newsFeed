package com.scaler.newsfeed.models;

import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserFollow extends BaseModel{
    @ManyToOne
    private User user;
    @ManyToOne
    private User following;
}
