package com.zelyder.recyclemap.presentation.ui.learn.components

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zelyder.recyclemap.R
import com.zelyder.recyclemap.domain.model.RecycleCode

@Composable
fun RecycleCodeItem(
    code: RecycleCode
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier =
            if (code.isNotRecyclable) Modifier
                .border(width = 2.dp, Color.Red, shape = CircleShape)
                .padding(6.dp)
            else Modifier
                .padding(6.dp)
        ) {
            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.plastic_recyc_00),
                    contentDescription = null,
                )
                Text(
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(top = 2.dp),
                    text = code.code,
                    textAlign = TextAlign.Center,
                    fontSize = if (code.code.length <= 2) 9.sp else 6.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            if (code.iso.isNotBlank()) {
                Text(
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally),
                    text = code.iso,
                    textAlign = TextAlign.Center,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
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
        RecycleCode(
            description = "Полиэтилентерефталат (лавсан)",
            examples = "Полиэстер, бутылки для напитков",
            code = "01",
            iso = "PET",
            isNotRecyclable = false
        )
    )
}