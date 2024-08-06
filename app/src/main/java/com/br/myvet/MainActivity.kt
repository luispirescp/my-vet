package com.br.myvet

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.br.myvet.network.RetrofitClient


import com.br.retrofity.entity.produto.Produto
import com.br.retrofity.entity.produto.ProdutoApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val etName: EditText = findViewById(R.id.etNameProd)
        val etQtd: EditText = findViewById(R.id.etQtd)
        val etPeso: EditText = findViewById(R.id.etPeso)
        val etFornecedor: EditText = findViewById(R.id.etFornecedor)
        val etPrice: EditText = findViewById(R.id.etPrice)
        val etGrup: EditText = findViewById(R.id.etGrup)
        val btnSalvar: Button = findViewById(R.id.btnSalvar)

        btnSalvar.setOnClickListener {
            println("===     Clicou       ")
            val name = etName.text.toString()
            val qtdStr = etQtd.text.toString()
            val pesoStr = etPeso.text.toString()
            val fornecedor = etFornecedor.text.toString()
            val precoStr = etPrice.text.toString()
            val grupStr = etGrup.text.toString()
            // Converter strings para inteiros
            val qtdInt = qtdStr.toIntOrNull() ?: 0
            val pesoInt = pesoStr.toIntOrNull() ?: 0

            val produto = Produto(
                id = 1, // Supondo que o ID será gerado pelo servidor
                name = name,
                qtd = qtdInt,
                peso = pesoInt,
                fornecedor = fornecedor,
                preci = precoStr,
                grupo = grupStr
            )
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    val retrofit = RetrofitClient.getCliente()
                    val produtoApi = retrofit.create(ProdutoApi::class.java)
                    val response = produtoApi.createProduto(produto)
                    withContext(Dispatchers.Main) {
                        if (response.isSuccessful) {
                            Toast.makeText(this@MainActivity, "Dados criados", Toast.LENGTH_LONG)
                                .show()
                            val intent =
                                Intent(this@MainActivity, Ativity2RecebendoActivity::class.java)
                            startActivity(intent)

                        } else {
                            Toast.makeText(
                                this@MainActivity,
                                "Erro ao criar produto",
                                Toast.LENGTH_LONG
                            ).show()
                            val intent = Intent(this@MainActivity, MainActivity::class.java)
                            startActivity(intent)
                        }
                    }
                } catch (e: Exception) {
                    println(e.message)
                }
            }
        }
    }
}
