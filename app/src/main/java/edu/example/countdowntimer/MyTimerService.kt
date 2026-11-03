package edu.example.countdowntimer

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class MyTimerService : Service() {

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        intent?.run{
            getIntExtra(TIMER_KEY, 10).let{ startValue ->
                CoroutineScope(Dispatchers.Default).launch{
                    for (i in startValue downTo 0)
                        Log.d("CountDown", "$i")
                        delay(1.seconds)
                }
            }
        }

        return super.onStartCommand(intent, flags, startId)
    }
}