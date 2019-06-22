package ru.amai.study.coursera.kotlin.week2

/**
 A valid identifier is a non-empty string that starts with a letter or underscore
 and consists of only letters, digits and underscores.
 */
fun isValidIdentifier(s: String): Boolean = s.matches("(\\p{L}|_)(\\w|\\p{L})*".toRegex())
