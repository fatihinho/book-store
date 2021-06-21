package com.fcinar.bookstore.model

import javax.persistence.*

@Entity
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val name: String,
    val author: String,
    val price: Double,
    val stock: Int
)
