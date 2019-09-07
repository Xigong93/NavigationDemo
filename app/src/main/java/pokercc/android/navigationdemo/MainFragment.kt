package pokercc.android.navigationdemo


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.shapes.RoundRectShape
import android.os.Bundle
import android.os.Handler
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.PopupWindow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.navigation.NavOptions
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.PopUpToBuilder
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.shape.RoundedCornerTreatment
import kotlinx.android.synthetic.main.fragment_main.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gotoNewListButton.setOnClickListener {
            findNavController(this).navigate(R.id.action_mainFragment_to_newsListFragment)
        }
        去新闻详情页面按钮.setOnClickListener {
            findNavController().navigate(
                R.id.action_global_newDetailFragment,
                Bundle().apply {
                    putString("id", "1")
                })
        }
        打开多个新闻详情页面按钮.setOnClickListener {
            for (i in 10 until 13) {
                findNavController().navigate(
                    R.id.action_global_newDetailFragment,
                    Bundle().apply {
                        putString("id", i.toString())
                    }/*,
                    NavOptions
                        .Builder()
                            // 禁止弹出多个相同的页面
                        .setLaunchSingleTop(false)
                        .build()*/
                )
            }

        }
        gotoUserDetailButton.setOnClickListener {
            // 需要先登录
            if (UserManager.isLogin(it.context)) {
                findNavController(this).navigate(R.id.action_mainFragment_to_userDetailFragment)
            } else {
                gotoLoginPage()

            }
        }
        UserManager.getLoginLiveData(requireContext())
            .observe(this, Observer {
                loginStateButton.text = if (it) "登出" else "登录"
            })
        loginStateButton.setOnClickListener {
            gotoLoginPage()

        }
        gotoNewsCollectionButton.setOnClickListener {
            // 需要先登录
            if (UserManager.isLogin(it.context)) {
                findNavController(this).navigate(R.id.action_mainFragment_to_newsCollectionFragment)

            } else {
                gotoLoginPage()

            }
        }
        gotoNoViewFragmentButton.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_noViewFragment)
        }

        非栈顶fragment弹出dialogButton.setOnClickListener {
            Handler().postDelayed({
                AlertDialog.Builder(requireContext())
                    .setMessage("这是MainFragment弹出来的")
                    .setCancelable(false)
                    .setPositiveButton(android.R.string.ok, null)
                    .show()
                PopupWindow(TextView(requireContext()).apply {
                    text = "这是MainFragment弹出来的PopupWindow"
                    setTextColor(Color.WHITE)
                    background = ColorDrawable(Color.BLACK)
                }, 300, 300, true)
                    .showAtLocation(
                        requireActivity().findViewById(Window.ID_ANDROID_CONTENT),
                        Gravity.CENTER,
                        0,
                        0
                    )
            }, 1000)


            findNavController().navigate(R.id.action_mainFragment_to_loginFragment2)

        }

        去登录页面按钮.setOnClickListener {
            findNavController(this).navigate(R.id.action_mainFragment_to_loginFragment2)

        }
        去登录页面按钮2.setOnClickListener {
            findNavController(this).navigate(R.id.action_global_loginFragment)

        }
        视频播放横屏按钮.setOnClickListener {
            findNavController().navigate(R.id.action_global_fullScreenVideoFragment)
        }
        设置状态栏颜色的按钮.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_stateBarFragment)
        }
        跳转到其他activity按钮.setOnClickListener {
            findNavController().navigate(R.id.action_global_mainFragment)
        }

        打开魂斗罗按钮.setOnClickListener {
            findNavController().navigate(R.id.navigation_game)
        }
    }

    private fun gotoLoginPage() {
        findNavController(this).navigate(R.id.action_mainFragment_to_loginFragment2)
    }


}
