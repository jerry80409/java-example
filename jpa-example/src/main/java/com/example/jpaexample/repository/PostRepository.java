package com.example.jpaexample.repository;

import com.example.jpaexample.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by jerry on 2018/7/23.
 *
 * @author jerry
 */
@Repository
public interface PostRepository extends JpaRepository<Post, String> {
}
