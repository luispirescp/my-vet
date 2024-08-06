package com.br.retrofity.entity.produto

import com.fasterxml.jackson.annotation.JsonProperty

data class Produto(
    @JsonProperty("id") val id:Long,
    @JsonProperty("name") val name: String,
    @JsonProperty("qtd") val qtd: Int,
    @JsonProperty("peso") val peso: Int,
    @JsonProperty("fornecedor") val fornecedor: String,
    @JsonProperty("preci") val preci: String,
    @JsonProperty("grupo") val grupo: String,
)


