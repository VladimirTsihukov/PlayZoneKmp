package com.tishukoff.playzonekmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform