package com.scaler.newsfeed.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Session extends BaseModel{
    private String token;
    @Enumerated(EnumType.ORDINAL)
    private SessionTokenStatus tokenStatus;

}
