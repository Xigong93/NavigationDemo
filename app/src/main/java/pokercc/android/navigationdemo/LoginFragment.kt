package pokercc.android.navigationdemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_login.*

/**
 * A simple [Fragment] subclass.
 */
class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginButton.setOnClickListener {
            UserManager.login(it.context)
            Toast.makeText(requireContext(), "登录成功", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()
        }
        logoutButton.setOnClickListener {
            UserManager.logout(it.context)
            Toast.makeText(requireContext(), "退出登录成功", Toast.LENGTH_SHORT).show()
            findNavController().popBackStack()

        }
        UserManager.getLoginLiveData(requireContext()).observe(this, Observer {
            loginButton.visibility = if (it) View.GONE else View.VISIBLE
            logoutButton.visibility = if (!it) View.GONE else View.VISIBLE
        })
    }


}
