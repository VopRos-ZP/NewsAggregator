package com.example.newsaggregator.data.rss.mapper

import com.example.newsaggregator.data.rss.dto.CategoryDto
import com.example.newsaggregator.data.rss.dto.ItemDto
import com.example.newsaggregator.domain.model.Item

fun ItemDto.fromDto() = Item(
    title = title,
    link = link,
    description = description,
    guid = guid,
    categories = categories.map(CategoryDto::fromDto),
    pubDate = pubDate,
)