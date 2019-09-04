package pokercc.android.navigationdemo

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.util.Log

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(ActivityLifeLogger())
    }
}

class ActivityLifeLogger : Application.ActivityLifecycleCallbacks {
    private fun log(event: String, activity: Activity) {
        Log.i("ActivityLifeLogger", "${activity.localClassName}.${event}")
    }

    override fun onActivityPaused(activity: Activity) {
        log("onActivityPaused", activity)
    }

    override fun onActivityResumed(activity: Activity) {
        log("onActivityResumed", activity)

    }

    override fun onActivityStarted(activity: Activity) {
        log("onActivityStarted", activity)

    }

    override fun onActivityDestroyed(activity: Activity) {
        log("onActivityDestroyed", activity)

    }

    override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {
        log("onActivitySaveInstanceState", activity)

    }

    override fun onActivityStopped(activity: Activity) {
        log("onActivityStopped", activity)

    }

    override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
        log("onActivityCreated", activity)

    }

}