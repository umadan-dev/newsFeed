package com.scaler.newsfeed.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class PostVote extends BaseModel{
    @ManyToOne
    private User user;
    @ManyToOne
    private Post post;
    @Enumerated(EnumType.ORDINAL)
    private VoteType voteType;
}
