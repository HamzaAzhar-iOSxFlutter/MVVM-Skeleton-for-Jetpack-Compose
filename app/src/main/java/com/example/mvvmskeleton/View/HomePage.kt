package com.example.mvvmskeleton.View

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.mvvmskeleton.ViewModel.SkeletonViewModel

@Composable
fun HomePage(modifier: Modifier = Modifier, viewModel: SkeletonViewModel) {

    val userData = viewModel.userData.observeAsState()
    val isLoading = viewModel.isLoading.observeAsState()

    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                viewModel.fetchUserDetails()
            }
        ) {
            Text("Get Data")
        }

        if (isLoading.value == true) {
            CircularProgressIndicator()
        } else {
            userData.value?.name?.let {
                Text("NAME: $it", fontWeight = FontWeight.Bold)
            }

            userData.value?.age?.let {
                Text("AGE: $it")
            }
        }

    }

}