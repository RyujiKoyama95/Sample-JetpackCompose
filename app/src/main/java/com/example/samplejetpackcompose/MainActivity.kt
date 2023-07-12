package com.example.samplejetpackcompose

import android.annotation.SuppressLint
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.samplejetpackcompose.MainActivity.Companion.TAG
import com.example.samplejetpackcompose.ui.theme.SampleJetpackComposeTheme

class MainActivity : ComponentActivity() {
    companion object {
        const val TAG = "MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SampleJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    Counter()
                }
            }
        }
    }
}

// mutableStateをrememberのラムダ内で呼ばないと、状態を保持しなくなるため、
// 以下のコードでは再コンポーズ毎に初期値0になると考えられるが、実際は、再コンポーズされるのはButton{}内だけなので、
// 初期値0にはならず、インクリメントされる
@SuppressLint("UnrememberedMutableState")
@Composable
fun Counter() {
//    val count = remember { mutableStateOf(0) }
    Log.d(TAG, "call Counter step1")
    val count = mutableStateOf(0)
    Button(
        modifier = Modifier.padding(vertical = 50.dp),
        onClick = { count.value++ }
    ) {
        Log.d(TAG, "call Counter step2")
        Text(text = "Count:${count.value}")
    }
}