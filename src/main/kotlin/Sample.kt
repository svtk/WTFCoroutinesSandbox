import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val aFuture = async {
        delay(3000)
        print("1")
        "a"
    }
    val bFuture = async {
        delay(2000)
        print("2")
        print(aFuture.await())
        "b"
    }
    val cFuture = async {
        delay(1000)
        print("3")
        print(bFuture.await())
        "c"
    }
    print(cFuture.await())
}