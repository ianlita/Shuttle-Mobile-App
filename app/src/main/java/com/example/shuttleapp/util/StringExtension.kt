package com.example.shuttleapp.util

fun String.containsNumber(): Boolean {
    val regex = Regex(".*\\d+.*")
    return regex.matches(this)
}

fun String.containsUpperCase() : Boolean {
    val regex = Regex(".*[A-Z]+.*")
    return regex.matches(this)
}

fun String.containsSpecialChar() : Boolean {
    val regex = Regex(".*[^A-Za-z\\d]+.*")
    return regex.matches(this)
}

fun String.containsLowerCase() : Boolean {
    val regex = Regex(".*[a-z]+.*")
    return regex.matches(this)
}

fun String.numberOnly(): Boolean {
    val regex = Regex("^[0-9]+$")
    return regex.matches(this)
}

fun String.upperAndLowerCaseOnly(): Boolean {
    val regex = Regex("^[a-zA-Z]+$")
    return regex.matches(this)
}