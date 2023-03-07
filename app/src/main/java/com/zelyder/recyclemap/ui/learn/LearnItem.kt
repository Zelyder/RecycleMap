package com.zelyder.recyclemap.ui.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zelyder.recyclemap.R


@Composable
fun LearnItem(title: String, imageId: Int, modifier: Modifier = Modifier) {
    Box(modifier = modifier.fillMaxWidth().clip(shape = RoundedCornerShape(20.dp))) {
        Image(painter = painterResource(id = imageId),
            contentDescription = "",
            Modifier.fillMaxWidth().clipToBounds()
        )
        Text(
            text = title,
            modifier = Modifier.align(Alignment.Center),
            color = Color.White,
            fontSize = 35.sp
        )
    }
}
@Preview
@Composable
fun prev() {
    LearnItem(title = "Пластик", imageId = R.drawable.plastic)

}