package pokercc.android.navigationdemo


import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import pokercc.android.navigationdemo.util.FragmentConfig

/**
 * 横屏的页面
 */
class FullScreenVideoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_screen_video, container, false)
    }

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
//
//    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        FragmentConfig(this).setOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR_LANDSCAPE)

    }

    //    private var defaultOrientation: Int = 0
    private var defaultWindowFlags: Int = 0

    override fun onStart() {
        super.onStart()
//        // 设置方向
//        defaultOrientation = requireActivity().requestedOrientation
//        requireActivity().requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

        // 设置隐藏状态栏
        defaultWindowFlags = requireActivity().window.attributes.flags
        requireActivity().window.addFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        requireActivity().window.addFlags(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN)
    }

    override fun onStop() {
        super.onStop()
//        requireActivity().requestedOrientation = defaultOrientation
        requireActivity().window.attributes.flags = defaultWindowFlags
        requireActivity().window.attributes = requireActivity().window.attributes

    }


}
