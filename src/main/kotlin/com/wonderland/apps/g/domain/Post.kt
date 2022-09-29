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
class Post(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    var postId: Long? = null,
    @Column(name = "title")
    var title: String? = null,
    @Column(name = "category")
    var category: String? = null,
    @Column(name = "author_id")
    var authorId: String? = null
)
