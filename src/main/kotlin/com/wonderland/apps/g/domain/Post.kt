package com.wonderland.apps.g.domain

import lombok.*
import javax.persistence.*

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
class Post() {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    val postId: Long? = null

    @Column(name = "title")
    val title: String? = null
    @Column(name = "category")
    val category: String? = null
    @Column(name = "author_id")
    val authorId: String? = null

}