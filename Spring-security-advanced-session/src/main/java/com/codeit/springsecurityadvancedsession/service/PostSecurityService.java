package com.codeit.springsecurityadvancedsession.service;

import com.codeit.springsecurityadvancedsession.domain.Post;
import com.codeit.springsecurityadvancedsession.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service("postSecurityService")
public class PostSecurityService {

  private final PostRepository postRepository;

  public PostSecurityService(PostRepository postRepository) {
    this.postRepository = postRepository;
  }

  public boolean isAuthor(
      Long postId,
      String username
  ) {

    Post post =
        postRepository.findById(postId);

    if (post == null) {
      return false;
    }

    return username.equals(
        post.getAuthor()
    );
  }



}
