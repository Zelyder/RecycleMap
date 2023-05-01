package com.zelyder.recyclemap.presentation.ui.learn

import android.os.Bundle
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.zelyder.recyclemap.R
import com.zelyder.recyclemap.presentation.navigation.NavConst
import com.zelyder.recyclemap.presentation.navigation.NavScreen
import com.zelyder.recyclemap.presentation.navigation.Router
import com.zelyder.recyclemap.presentation.ui.learn.models.LItem
import com.zelyder.recyclemap.presentation.ui.learn.components.LearnItem

val learnList = listOf(
    LItem(id = 0, R.string.plastic, R.drawable.plastic, R.string.plastic_description),
    LItem(id = 1, R.string.paper, R.drawable.paper, R.string.paper_description),
    LItem(id = 2, R.string.metal, R.drawable.metal, R.string.metal_description),
    LItem(
        id = 3,
        R.string.organic_materials,
        R.drawable.organic_materials,
        R.string.cloth_description
    ),
    LItem(id = 4, R.string.glass, R.drawable.glass, R.string.glass_description),
    LItem(
        id = 5,
        R.string.composite_materials,
        R.drawable.composite_materials,
        R.string.hazardous_waste_description
    ),
    LItem(id = 6, R.string.batteries, R.drawable.batteries, R.string.batteries_description),
    LItem(
        id = 7,
        R.string.hazardous_waste,
        R.drawable.hazardous_waste,
        R.string.hazardous_waste_description
    ),
    LItem(id = 8, R.string.cloth, R.drawable.clothes, R.string.cloth_description),
    LItem(id = 9, R.string.light_bulbs, R.drawable.light_bulbs, R.string.light_bulbs_description),
    LItem(id = 10, R.string.appliances, R.drawable.appliances, R.string.appliances_description),
    LItem(id = 11, R.string.tetra_pack, R.drawable.tetra_pack, R.string.tetra_pack_description),
    LItem(id = 12, R.string.caps, R.drawable.caps, R.string.caps_description),
)

@Composable
fun LearnScreen(externalRouter: Router) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(learnList) { item ->
            LearnItem(
                title = stringResource(id = item.title),
                imageId = item.image,
                modifier = Modifier.clickable {
                    val bundle = Bundle().apply {
                        putInt(NavConst.LEARN_DETAILS_SCREEN_ID, item.id)
                    }
                    externalRouter.routeTo(
                        NavScreen.NavLearnDetailsScreen(item.id.toString()).route,
                        bundle
                    )
                })
        }
    }
    Spacer(modifier = Modifier.height(16.dp))
}