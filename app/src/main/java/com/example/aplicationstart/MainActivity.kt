package com.example.aplicationstart

import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aplicationstart.ui.theme.AplicationStartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplicationStartTheme {
                Column() {
                    Welcome()
                    Transactions()
                }

                }
            }
        }




    @Composable
    fun Transactions() {
        LazyColumn(
            modifier = Modifier.padding(16.dp),
            contentPadding = PaddingValues(8.dp)

        ) {
            items(transactionsDummy.size) { index ->
                Transaction(index)
              }
        }
    }

    @Composable
    private fun Transaction(index: Int) {
        Card(
            elevation = CardDefaults.cardElevation(8.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row() {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = "Settings")
                Spacer(modifier = Modifier.padding(16.dp))
                Text(
                    text = transactionsDummy[index],
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth(),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }


    @Composable
    fun Welcome() {
        Row(modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
            ) {
            Text(
                text = "Seja bem vindo, \nDieferson Soares",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.weight(1f)
            )
            Icon(
                imageVector = Icons.Filled.Delete,
                contentDescription = "Limpar Transações",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}


private val transactionsDummy = listOf<String>(
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
    "Gasolina", "Mercado", "Energia", "Água",
)