package pokercc.android.navigationdemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
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
        gotoUserDetailButton.setOnClickListener {
            // 需要先登录
            if (UserManager.isLogin(it.context)) {
                findNavController(this).navigate(R.id.action_mainFragment_to_userDetailFragment)
            } else {
                findNavController(this).navigate(R.id.action_mainFragment_to_loginFragment2)
            }
        }
        UserManager.getLoginLiveData(requireContext())
            .observe(this, Observer {
                loginStateButton.text = if (it) "登出" else "登录"
            })
        loginStateButton.setOnClickListener {
            findNavController(this).navigate(R.id.action_mainFragment_to_loginFragment2)
        }
        gotoNewsCollectionButton.setOnClickListener {
            // 需要先登录
            if (UserManager.isLogin(it.context)) {
                findNavController(this).navigate(R.id.action_mainFragment_to_newsCollectionFragment)
            } else {
                findNavController(this).navigate(R.id.action_mainFragment_to_loginFragment2)
            }
        }



    }


}
