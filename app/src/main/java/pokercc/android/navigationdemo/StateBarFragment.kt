package pokercc.android.navigationdemo


import android.graphics.Color
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window

/**
 * A simple [Fragment] subclass.
 */
class StateBarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_state_bar, container, false)
    }

    private var defaultStateBarColor: Int = 0
    private var defaultSystemUiVisibility: Int = 0
    override fun onResume() {
        super.onResume()
        //设置系统状态栏的背景色
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            defaultStateBarColor = requireActivity().window.statusBarColor
            requireActivity().window.statusBarColor = Color.YELLOW

        }
        // 设置亮色状态栏文字
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val rootView = requireActivity().findViewById<View>(Window.ID_ANDROID_CONTENT)
            var flags = rootView.systemUiVisibility
            defaultSystemUiVisibility = flags
            flags = flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
            rootView.systemUiVisibility = flags
        }


    }

    override fun onPause() {
        super.onPause()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            requireActivity().window.statusBarColor = defaultStateBarColor
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val rootView = requireActivity().findViewById<View>(Window.ID_ANDROID_CONTENT)
            rootView.systemUiVisibility = defaultSystemUiVisibility
        }
    }


}
