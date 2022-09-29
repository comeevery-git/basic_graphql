package com.wonderland.apps.g.resolver.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.wonderland.apps.g.domain.Post
import com.wonderland.apps.g.repository.PostRepository
import lombok.RequiredArgsConstructor
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

/**
 * 등록, 수정, 삭제
 */
@Component
@RequiredArgsConstructor
class PostMutation:GraphQLMutationResolver {
    @Autowired
    private lateinit var postRepository: PostRepository


    /**
     * 단일 Post 등록
     * @param post: Post
     * @return
     */
    fun createPost(title: String, category: String, authorId: String): Post {
        val post = Post(
            title = title,
            category = category,
            authorId = authorId
        )
        return postRepository!!.save(post);
    }


}