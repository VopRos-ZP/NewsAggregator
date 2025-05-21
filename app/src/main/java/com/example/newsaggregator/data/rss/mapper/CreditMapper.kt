package com.example.newsaggregator.data.rss.mapper

import com.example.newsaggregator.data.rss.dto.CreditDto
import com.example.newsaggregator.domain.model.Credit

fun CreditDto.fromDto() = Credit(
    scheme = scheme,
    value = value,
)