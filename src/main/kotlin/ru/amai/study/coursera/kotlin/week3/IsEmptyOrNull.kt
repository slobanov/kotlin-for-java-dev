package ru.amai.study.coursera.kotlin.week3

fun String?.isEmptyOrNull(): Boolean = (this?:"").isEmpty()