package com.wonderland.apps.g.service

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.wonderland.apps.g.domain.Post
import com.wonderland.apps.g.repository.PostRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PostService:GraphQLQueryResolver, GraphQLMutationResolver {

    @Autowired
    private lateinit var postRepository: PostRepository

    /**
     * 모든 Post 조회
     * @param count: Int, offset: Int
     * @return
     */
    fun getPosts(count: Int, offset: Int): List<Post> {
        return postRepository.findAll()
    }

    /**
     * 단일 Post 조회
     * @param postId: Long
     * @return
     */
    fun getPost(postId: Long): Post {
        val post: Optional<Post> = postRepository.findById(postId);
        return post.get()
    }

    /**
     * 단일 Post 등록
     * @param post: Post
     * @return
     */
    fun createPost(title: String, category: String, authorId: String): Post {
        val post = Post(
            title = title, category = category, authorId = authorId
        )
        return postRepository.save(post);
    }


}