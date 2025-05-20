package com.example.newsaggregator.ui.components.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import coil3.compose.AsyncImage
import com.example.newsaggregator.data.rss.dto.ItemDto
import com.example.newsaggregator.ui.compose.Loader

@Composable
fun MainScreen(component: MainComponent) {
    val state by component.model.collectAsState()

    if (state.rssDto == null) {
        Loader()
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(start = 10.dp, end = 10.dp, bottom = 20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(
                items = state.rssDto!!.channel.items,
            ) {
                ItemCard(it)
            }
        }
    }
}

@Composable
fun ItemCard(item: ItemDto) {
    Card(
        onClick = {}
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            AsyncImage(
                model = item.contents.first().url,
                contentDescription = item.contents.first().url,
                modifier = Modifier.fillMaxWidth()
            )
//            Text(
//                text = item.title,
//                fontSize = 16.sp
//            )
//            Text(
//                text = HtmlCompat.fromHtml(item.description, HtmlCompat.FROM_HTML_MODE_COMPACT).toString(),
//                maxLines = 2,
//                overflow = TextOverflow.Ellipsis,
//                fontSize = 12.sp
//            )
        }
    }
}