package com.wonderland.apps.g.config

import com.coxautodev.graphql.tools.GraphQLResolver
import com.wonderland.apps.g.domain.Post
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Component

@Component
@RequiredArgsConstructor
class PostResolver:GraphQLResolver<Post> {


}