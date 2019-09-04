package pokercc.android.navigationdemo

import android.content.Context
import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object UserManager {
    private val isLoginLiveData: MutableLiveData<Boolean> = MutableLiveData()

    fun getLoginLiveData(context: Context): LiveData<Boolean> {
        if (isLoginLiveData.value == null) {
            isLoginLiveData.value = getConfig(context).getBoolean("is_login", false)
        }
        return isLoginLiveData
    }

    private fun getConfig(context: Context): SharedPreferences {
        return context.getSharedPreferences("user_config", Context.MODE_PRIVATE)
    }

    fun login(context: Context) {
        isLoginLiveData.value = true
        getConfig(context).edit()
            .putBoolean("is_login", true)
            .apply()
    }


    fun isLogin(context: Context): Boolean {
        return getLoginLiveData(context).value!!
    }

    fun logout(context: Context) {
        isLoginLiveData.value = false
        getConfig(context).edit()
            .putBoolean("is_login", false)
            .apply()
    }
}