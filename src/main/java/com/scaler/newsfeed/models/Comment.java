package com.scaler.newsfeed.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Comment extends BaseModel{
    private String text;
    @OneToMany
    private List<SubComment> subComments;
    @OneToMany
    private List<CommentVote> votes;

}
