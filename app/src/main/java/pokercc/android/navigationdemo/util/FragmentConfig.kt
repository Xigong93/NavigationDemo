package pokercc.android.navigationdemo.util

import android.app.Activity
import android.graphics.Color
import android.os.Build
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.MainThread
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.lifecycle.*

/**
 * fragment 配置
 */
@MainThread
class FragmentConfig(private val fragment: Fragment) {

    private val activity: Activity
        get() = fragment.requireActivity()
    private val window: Window
        get() = activity.window
    private val decorView: View
        get() = window.decorView


//    enum class WindowStyle {
//        FULL_SCREEN_HIDE_SYSTEM_BAR,
//        FULL_SCREEN_SHOW_SYSTEM_BAR,
//        NORMAL_
//    }

    sealed class WindowStyle {
        class FullScreenWindow(val showSystemBar: Boolean) : WindowStyle()
        class Normal(val statusBarColor: Int) : WindowStyle()
    }


    fun setWindowStyle(windowStyle: WindowStyle) {


    }

    private val orientationConfig = FragmentConfigItem(activity.requestedOrientation)
    /**
     * 设置屏幕的方向
     */
    fun setOrientation(orientation: Int) {
        orientationConfig.setConfig(orientation, fragment) {
            activity.requestedOrientation = it
        }


    }

    private val statusBarColorConfig = FragmentConfigItem(getStatusBarColor(window))
    /**
     * 设置状态栏颜色
     */
    fun setStatusBarColor(color: Int) {
        statusBarColorConfig.setConfig(color, fragment) {
            setStatusBarColor(window, it)
        }


    }

    private val lightSystemBarConfig = FragmentConfigItem(isLightSystemBar(activity))
    /**
     * 设置亮色系统状态栏
     */
    fun setLightSystemBar(light: Boolean) {
        // 6.0 以下不支持亮色状态栏
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            return
        }
        lightSystemBarConfig.setConfig(light, fragment) {
            setLightSystemBar(decorView, it)
        }


    }


}

fun setWindowStyle(window: Window, windowStyle: FragmentConfig.WindowStyle) {
    when (windowStyle) {
        is FragmentConfig.WindowStyle.FullScreenWindow -> {
            window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            if (!windowStyle.showSystemBar) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    addSystemUIVisibilityFlag(
                        window.decorView,
                        View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                    )
                }
            }
        }
        is FragmentConfig.WindowStyle.Normal -> {
            window.clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            }
            setStatusBarColor(window, windowStyle.statusBarColor)
        }
    }


}

private fun addSystemUIVisibilityFlag(view: View, flag: Int) {
    view.systemUiVisibility = view.systemUiVisibility or flag
}

private fun clearSystemUIVisibilityFlag(view: View, flag: Int) {
    view.systemUiVisibility = view.systemUiVisibility and flag.inv()
}

private fun setStatusBarColor(window: Window, color: Int) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor = color
    }
}

private fun getStatusBarColor(window: Window): Int {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.statusBarColor
    } else {
        Color.WHITE
    }

}

private fun isLightSystemBar(activity: Activity): Boolean =
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        activity.window.decorView.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR != 0
    } else {
        false
    }

@RequiresApi(Build.VERSION_CODES.M)
private fun setLightSystemBar(view: View, it: Boolean) {
    view.systemUiVisibility = if (it) {
        view.systemUiVisibility or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    } else {
        view.systemUiVisibility and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
    }
}


class FragmentConfigItem<T>(private val defaultConfig: T) {
    private val liveData = MutableLiveData<T>()
    fun setConfig(config: T, fragment: Fragment, observer: (T) -> Unit) {
        liveData.value = config
        liveData.observe(fragment, Observer {
            observer(it)
        })
        fragment.lifecycle.addObserver(LifecycleEventObserver { _: LifecycleOwner,
                                                                event: Lifecycle.Event ->
            if (event == Lifecycle.Event.ON_STOP) {
                observer(defaultConfig)
            }
        })
    }

}