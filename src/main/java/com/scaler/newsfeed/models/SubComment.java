package com.scaler.newsfeed.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class SubComment extends BaseModel{
    private String text;
}
