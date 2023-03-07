package com.zelyder.recyclemap.ui.learn

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zelyder.recyclemap.R
import com.zelyder.recyclemap.ui.learn.models.RecycleCode

@Composable
fun RecycleCodeItem(
    code: RecycleCode,
    isNotRecyclable: Boolean = false
) {
    Row(modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
       Image(
           painter = painterResource(id = code.icon),
           contentDescription = null,
           modifier =
           if (isNotRecyclable) Modifier
               .border(width = 2.dp, Color.Red, shape = CircleShape)
               .padding(6.dp)
               .size(32.dp)
           else Modifier
               .padding(6.dp)
               .size(32.dp)
       )
       Column {
           Text(text = code.description)
           Spacer(modifier = Modifier.height(8.dp))
           Text(text = code.examples)
       }
    }
}

@Preview(showBackground = true)
@Composable
fun RecycleCodeItemPreview() {
    RecycleCodeItem(
        RecycleCode(icon = R.drawable.plastic_recyc_01,
            description = "Полиэтилентерефталат (лавсан)",
            examples = "Полиэстер, бутылки для напитков"),
        isNotRecyclable = false
    )
}