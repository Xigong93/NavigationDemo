package pokercc.android.navigationdemo


import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 */
class NoViewFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return null
    }

    private var dialog: AlertDialog? = null
    private fun dismissDialog() = dialog?.dismiss()

    override fun onStart() {
        dismissDialog()
        super.onStart()
        dialog = AlertDialog.Builder(requireContext())
            .setMessage("这个是一个没有UI的Fragment")
            .setCancelable(false)
            .setPositiveButton(android.R.string.ok) { _, _ ->
                findNavController().popBackStack()
            }
            .show()
    }

    override fun onStop() {
        super.onStop()
        dismissDialog()
    }


}
