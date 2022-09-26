package com.wonderland.apps.g.resolver.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import com.wonderland.apps.g.domain.Post
import com.wonderland.apps.g.repository.PostRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component

/**
 * 조회
 */
@Component
@RequiredArgsConstructor
class PostQuery:GraphQLQueryResolver {
    private val postRepository: PostRepository? = null

    /**
     * 모든 Post 조회
     * GraphQL Schema Query: post(count: Int!, offset: Int!): List<Post>
     * @param count: Int, offset: Int
     * @return
     */
    fun getPosts(count: Int, offset: Int): List<Post> {
        val posts: List<Post> = postRepository!!.findAll()
        return posts
    }


}