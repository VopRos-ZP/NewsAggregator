package com.example.newsaggregator.data.rss.mapper

import com.example.newsaggregator.data.rss.dto.ImageDto
import com.example.newsaggregator.domain.model.Image

fun ImageDto.fromDto() = Image(
    title = title,
    url = url,
    link = link,
)