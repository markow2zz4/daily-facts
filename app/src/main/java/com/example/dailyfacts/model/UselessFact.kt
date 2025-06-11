package com.example.dailyfacts.model

data class UselessFact (
    val id: String,
    val text: String,
    val source: String,
    val sourceUrl: String,
    val language: String,
    val permalink: String
)