package com.wonderland.apps.g.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import com.wonderland.apps.g.domain.GraphqlForm
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.TestConstructor
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers


@AutoConfigureMockMvc
@ActiveProfiles("dev")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
class PostServiceTest(private val mockMvc: MockMvc){
    private var graphqlUrl: String = "http://localhost:8081/graphql"

    companion object {
        protected val objectMapper: ObjectMapper = jacksonObjectMapper()
    }

    @Test
    @DisplayName("[GRAPHQL OVER HTTP|MUTATION] 포스트 생성 테스트")
    fun createPost() {
        /* GIVEN */
        val requestBody = GraphqlForm.Request(
            query = "mutation {\n" +
                    "  createPost(\n" +
                    "      title:\"제목 생성 테스트4\",\n" +
                    "      category:\"카테고리 생성 테스트4\",\n" +
                    "      authorId:\"lydia\"\n" +
                    "  ){\n" +
                    "      postId\n" +
                    "      title\n" +
                    "      category\n" +
                    "      authorId\n" +
                    "  }\n" +
                    "}"
        )

        /* WHEN */
        val response = postGraphql(requestBody)
        // val post = getGraphqlResponseBody("createPost", response.response.contentAsString, Post::class.java)

        /* THEN */
        // MatcherAssert (post?.postId, null)
    }


    fun postGraphql(requestBody: GraphqlForm.Request): MvcResult {
        return mockMvc
            .perform(
                MockMvcRequestBuilders.post(graphqlUrl)
                    .content(objectMapper.writeValueAsBytes(requestBody))
                    //  .contentType(MediaType.APPLICATION_GRAPHQL)
                    .contentType("application/graphql+json")
                    .characterEncoding("UTF-8")
            ).andExpect {
                MockMvcResultMatchers.status().isOk
//                MockMvcResultMatchers.request().asyncStarted()
//                MockMvcResultMatchers.request().asyncResult(CoreMatchers.notNullValue())
            }.andReturn()
    }

    fun <T> getGraphqlResponseBody(name: String, response: String, clazz: Class<T>): T? =
        getResponseBody(name, response)?.let {
            objectMapper.readValue(objectMapper.writeValueAsString(it), clazz)
        }

    fun getResponseBody(name: String, response: String): Any? {
        val graphqlResponse: GraphqlForm.Response = objectMapper.readValue(response)
        return graphqlResponse.data[name]
    }



//    @Test
//    fun getPosts() {
//    }
//
//    @Test
//    fun getPost() {
//    }



}