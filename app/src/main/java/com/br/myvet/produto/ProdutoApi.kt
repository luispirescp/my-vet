package com.br.retrofity.entity.produto


import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface ProdutoApi {
    @GET("/produtos")
    fun getAllProductos(): Call<List<Produto>>

    @GET("/v1/produto")
    fun getProduto(): Call<Produto>

    @Headers("Content-Type: application/json")
    @POST("/produto")  // Substitua "produtos" pelo caminho correto da sua API
    suspend fun createProduto(@Body produto: Produto): Response<Produto>

    @DELETE("/delete-produto/{id}")
    fun deleteProduto(@Path("id") id: Int): Call<Unit?>

    @PUT("/update-produto/{id}")
    fun updateProduto(
        @Path("id") id: Int,
        @Body produto: Produto
    )
    :Call<Produto>
}