package com.wonderland.apps.g.resolver.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.wonderland.apps.g.domain.Post
import com.wonderland.apps.g.repository.PostRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component

/**
 * 등록, 수정, 삭제
 */
@Component
@RequiredArgsConstructor
class PostMutation:GraphQLMutationResolver {
    private val postRepository: PostRepository? = null


    /**
     * 단일 Post 등록
     * GraphQL Schema Query: post(count: Int!, offset: Int!): List<Post>
     * @param count: Int, offset: Int
     * @return
     */
    fun createPost(post:Post): Post {
        return postRepository!!.save(post);
    }


}