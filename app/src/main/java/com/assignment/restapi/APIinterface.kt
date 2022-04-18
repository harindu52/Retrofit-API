package com.assignment.restapi

import retrofit2.Call
import retrofit2.http.GET

interface APIinterface {
    @get:GET(value="posts")
    val posts: Call<List<PostModel?>?>?
    @get:GET(value="comments")
    val comments: Call<List<CommentModel?>?>?
    companion object{
        const val BASE_URL="https://jsonplaceholder.typicode.com"
    }

}