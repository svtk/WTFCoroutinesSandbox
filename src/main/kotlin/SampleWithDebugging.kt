package sampleDebugging

import kotlinx.coroutines.*

//-Dkotlinx.coroutines.debug

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() = runBlocking {
    val aFuture = async(Dispatchers.Default) {
        delay(3000)
        log("1")
        "a"
    }
    val bFuture = async(Dispatchers.Default) {
        delay(2000)
        log("2")
        log(aFuture.await())
        "b"
    }
    val cFuture = async(Dispatchers.Default) {
        delay(1000)
        log("3")
        log(bFuture.await())
        "c"
    }
    log(cFuture.await())
}