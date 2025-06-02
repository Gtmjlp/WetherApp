package com.assignment.weather

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform