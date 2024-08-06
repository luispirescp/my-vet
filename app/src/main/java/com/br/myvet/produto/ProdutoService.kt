package com.br.retrofity.entity.produto



import com.br.myvet.produto.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProdutoService {

    private val retrofit = RetrofitClient.getCliente()
    private val produtoApi = retrofit.create(ProdutoApi::class.java)
     suspend fun successfulUsersResponse() {

        println(" Service ")
            val produto = Produto(2,"fsdf",45,8,"t", "4","8")
            produtoApi.createProduto(produto)
    }
    //
    //app de standup artista -- stilo do standup
    //
    //foodtruck na regiao (10)  - crud, (cardapio), (redes social), nicho, missao agenda.
    //

   //capturar som da voz (alexa API) -
// aplicativo eu falo como eu estou me sentido
// ele com o poder da IA vai me dar a musica certa......

// ===========================
// se possivel ser feito
// se é interessante



//capturar som da voz (alexa API) -
// aplicativo eu falo como eu estou me sentido
// ele com o poder da IA vai me dar a musica certa......

//psicoloco gpt
    //alexia
    // IA comportamental

    //com os inputs recebidos e passados para a ia comportamenal
    // que me entrega um direcionamento ou uma possivel resposta com base no teorico que escoli
    // com a voz do teorico



    private fun produtoUpdate(produto: Produto) {
        produtoApi.updateProduto(5,produto)
            .enqueue(object : Callback<Produto> {
                override fun onResponse(call: Call<Produto>, response: Response<Produto>) {
                    val updateProduto = response.body()
                    if (response.isSuccessful) {
                        println("Prodtuto update $updateProduto")
                    } else {
                        println("Update failed: ${response.errorBody()?.string()}")
                    }
                }

                override fun onFailure(call: Call<Produto>, t: Throwable) {
                    println("request failed : ${t.message}")
                }
            })
    }
}

