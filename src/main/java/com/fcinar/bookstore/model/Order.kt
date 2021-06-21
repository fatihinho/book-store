package com.fcinar.bookstore.model

import javax.persistence.*

@Entity(name = "bookOrder")
data class Order(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private val id: Long?,
    private val userName: String,
    @Column
    @ElementCollection
    private val bookIdList: List<Long>,
    private val totalPrice: Double
)
