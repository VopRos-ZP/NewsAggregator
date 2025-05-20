package com.example.newsaggregator.data.rss.mapper

import com.example.newsaggregator.data.rss.dto.CategoryDto
import com.example.newsaggregator.domain.model.Category

fun CategoryDto.fromDto(): Category = Category(
    domain = domain,
    value = value,
)
