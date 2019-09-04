package pokercc.android.navigationdemo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_new_detail.*

/**
 * A simple [Fragment] subclass.
 */
class NewDetailFragment : Fragment() {

    private lateinit var articleId: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleId = arguments?.getString("id") ?: ""
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // 参数检查
        if (articleId.isEmpty()) {
            AlertDialog.Builder(requireContext())
                .setCancelable(false)
                .setMessage("文章id不能为null")
                .setPositiveButton(android.R.string.ok) { _, _ ->
                    // 弹出当前页面
                    findNavController().popBackStack()
                }
                .show()
        }
        titleTextView.text = "文章id:$articleId"
        requireActivity().onBackPressedDispatcher.addCallback(this,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
//                    - 监听返回键
                    AlertDialog.Builder(requireContext())
                        .setCancelable(true)
                        .setMessage("确定退出吗？您的阅读记录将不会记录")
                        .setPositiveButton(android.R.string.ok) { _, _ ->
                            // 弹出当前页面
                            findNavController().popBackStack()
                        }
                        .setNegativeButton(android.R.string.cancel, null)

                        .show()

                }
            })
    }

}
