package com.scaler.newsfeed.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Post extends BaseModel{
    @ManyToOne
    private User postedBy;

    private String content;
    @OneToMany
    private List<Comment> comments;
    @OneToMany
    private List<PostVote> votes;

}
