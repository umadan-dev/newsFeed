package com.scaler.newsfeed.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CommentVote extends BaseModel{
    @ManyToOne
    private User user;
    @ManyToOne
    private Comment comment;
    private VoteType type;
}
