package pokercc.android.navigationdemo


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 */
class NewDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_new_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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
