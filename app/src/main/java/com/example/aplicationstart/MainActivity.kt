package com.example.aplicationstart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.aplicationstart.ui.theme.AplicationStartTheme
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.Collections.emptyList


class MyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState

    fun add(transaction: String) {
        val transactions = _uiState.value.transactions.toMutableStateList()
        transactions.add(transaction)
        _uiState.value = UiState(transactions = transactions)
    }

    data class UiState(
        val transactions: List<String> = emptyList()
    )

}

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
    fun Transactions(viewModel: MyViewModel = androidx.lifecycle.viewmodel.compose.viewModel()) {
        val uiState by viewModel.uiState.collectAsState()
       Column() {
           LazyColumn(
               modifier = Modifier
                   .padding(16.dp)
                   .weight(1f)
                   .fillMaxWidth(),
               contentPadding = PaddingValues(8.dp)

           ) {
               items(uiState.transactions.size) { index ->
                   Transaction(uiState.transactions[index])
               }
         }
           Button(onClick = {
               viewModel.add("Nova Transação")
           }) {
               Text(text = "Add Nova Transação")
           }
        }
    }

    @Composable
    private fun Transaction(transaction: String) {
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
                    text = transaction,
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