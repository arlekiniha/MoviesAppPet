package com.arlekin.moviesapppet.util


sealed class Resource<T> {
    class Loading<T> : Resource<T>()
    data class Success<T>(val data: T) : Resource<T>()
    data class Failure<T>(val error: DomainError) : Resource<T>()
}

enum class DomainError{
    RemoteError,
    LocalError
}