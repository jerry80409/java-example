package com.example.jpaexample.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */

@Table(name = "reaction_user")
@Entity(name = "reaction_user")
//@Table(
//    name = "reaction_user",
//    uniqueConstraints = @UniqueConstraint(columnNames = {"id", "post_id"}))
public class ReactionUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Getter
    @Setter
    @Id
    private String id;
//    @Getter
//    @Setter
//    @EmbeddedId
//    private PostReactionUserId postReactionUserId;

//    @Getter
//    @Setter
//    @Column(name = "post_id")
//    private String postId;

    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    @Getter
    @Setter
    @Column(name = "link")
    private String link;

    @Getter
    @Setter
    @Column(name = "pic")
    private String picLarge;

    @Getter
    @Setter
    @Column(name = "type")
    private String type;

//    @Getter
//    @Setter
//    @ManyToOne
//    @JoinColumn(name = "post_id")
//    private Post post;

//    @ManyToMany(
//        cascade = CascadeType.ALL,
//        fetch = FetchType.LAZY
//    )
//    @Column(name = "post")
//    private List<Post> posts;

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "-" + this.getId();
    }

}
