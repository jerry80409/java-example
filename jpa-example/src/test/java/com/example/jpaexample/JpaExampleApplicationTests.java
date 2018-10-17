package com.example.jpaexample;

import com.example.jpaexample.entity.Post;
import com.example.jpaexample.entity.ReactionUser;
import com.example.jpaexample.repository.PostRepository;
import com.example.jpaexample.repository.ReactionUserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaExampleApplicationTests {

    @Autowired
    private PostRepository postRepo;
    @Autowired
    private ReactionUserRepository reactionUserRepo;

    @Test
    public void assert_save_post() {
        Post post = new Post();
        post.setId("2");
        post.setMessage("foo2");
        post.setReactions(reactionUsers(post));

        postRepo.save(post);
    }


    public List<ReactionUser> reactionUsers(Post post) {

        List<ReactionUser> allUsers = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            ReactionUser user = new ReactionUser();
            user.setId(String.valueOf(i));
//            user.setPostReactionUserId(new PostReactionUserId(post.getId(), String.valueOf(i)));
            user.setName(String.valueOf(i) + "_name");
            user.setType("HAHA");
//            user.setPost(post);
            allUsers.add(user);
        }
        return allUsers;
    }
}
