package com.zelyder.recyclemap.presentation.ui.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zelyder.recyclemap.R
import androidx.hilt.navigation.compose.hiltViewModel
import com.zelyder.recyclemap.presentation.ui.learn.components.RecycleCodeItem

@Composable
fun LearnDetailsScreen(
    id: Int?,
    viewModel: LearnViewModel = hiltViewModel(),
    state: LearnState = viewModel.state.value
) {
    val details = remember {
        id?.let { learnList[it] }
    }
    val list =
        id?.let {
            viewModel.getCodesList(id)
            state.recycleCodes
        }

    Column {
        LazyColumn {
            item {
                Box {
                    details?.let { item ->
                        Image(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(260.dp),
                            painter = painterResource(id = item.image),
                            contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                        Text(
                            modifier = Modifier
                                .fillMaxSize()
                                .align(Alignment.Center)
                                .padding(8.dp),
                            text = stringResource(id = item.title),
                            style = MaterialTheme.typography.h3,
                            textAlign = TextAlign.Center,
                            color = MaterialTheme.colors.onPrimary,
                        )
                    }
                }

            }
            item {
                details?.description?.let { description ->
                    Text(
                        modifier = Modifier.padding(8.dp),
                        text = stringResource(id = R.string.common_description) + "\n\n" +
                                stringResource(id = description),
                        style = MaterialTheme.typography.body1
                    )
                }
            }
            list?.let { list ->
                items(list) { code ->
                    RecycleCodeItem(code)
                }
            }
        }
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun LearnDetailsScreenPreview() {
//    LearnDetailsScreen(id = 0)
//}