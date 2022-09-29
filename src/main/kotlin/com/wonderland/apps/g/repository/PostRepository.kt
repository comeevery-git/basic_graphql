package com.wonderland.apps.g.repository

import com.wonderland.apps.g.domain.Post
import org.springframework.data.jpa.repository.JpaRepository

interface PostRepository: JpaRepository<Post, Long> {

}