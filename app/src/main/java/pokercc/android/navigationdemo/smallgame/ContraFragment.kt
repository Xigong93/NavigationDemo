package pokercc.android.navigationdemo.smallgame


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_contra.*

import pokercc.android.navigationdemo.R

/**
 * 魂斗罗主页
 */
class ContraFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contra, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        选择关卡button.setOnClickListener {
            findNavController().navigate(R.id.action_contraFragment_to_gameStageFragment)
        }
    }


}
