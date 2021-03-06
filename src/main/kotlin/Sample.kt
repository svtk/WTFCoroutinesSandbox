package sample

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

//-Dkotlinx.coroutines.debug

fun log(msg: String) = println("[${Thread.currentThread().name}] $msg")

fun main() = runBlocking {
    val aFuture = async {
        delay(3000)
        log("1")
        "a"
    }
    val bFuture = async {
        delay(2000)
        log("2")
        log(aFuture.await())
        "b"
    }
    val cFuture = async {
        delay(1000)
        log("3")
        log(bFuture.await())
        "c"
    }
    log(cFuture.await())
}