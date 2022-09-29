package com.wonderland.apps.g.resolver.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.wonderland.apps.g.domain.Post
import com.wonderland.apps.g.repository.PostRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import java.util.*

/**
 * 조회
 */
@Component
@RequiredArgsConstructor
class PostQuery:GraphQLQueryResolver {
    @Autowired
    private lateinit var postRepository: PostRepository

    /**
     * 모든 Post 조회
     * @param count: Int, offset: Int
     * @return
     */
    fun getPosts(count: Int, offset: Int): List<Post> {
        return postRepository!!.findAll()
    }

    /**
     * 단일 Post 조회
     * @param postId: Long
     * @return
     */
    fun getPost(postId: Long): Post {
        val post: Optional<Post> = postRepository!!.findById(postId);
        return post.get()
    }


}