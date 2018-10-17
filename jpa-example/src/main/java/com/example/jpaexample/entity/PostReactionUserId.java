package com.example.jpaexample.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */
@Data
@Embeddable
@AllArgsConstructor
public class PostReactionUserId {

    @Column(name = "post_id")
    private String postId;

    @Column(name = "reaction_user_id")
    private String reactionUserId;
}
