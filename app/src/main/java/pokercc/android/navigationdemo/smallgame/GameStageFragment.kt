package pokercc.android.navigationdemo.smallgame


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_game_stage.*

import pokercc.android.navigationdemo.R

/**
 *  选择关卡
 */
class GameStageFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_stage, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button1.setOnClickListener {
            findNavController().navigate(
                R.id.action_gameStageFragment_to_fightFragment, bundleOf(
                    "id" to 0
                )
            )
        }
        button2.setOnClickListener {
            findNavController().navigate(
                R.id.action_gameStageFragment_to_fightFragment, bundleOf(
                    "id" to 1
                )
            )
        }
        button3.setOnClickListener {
            findNavController().navigate(
                R.id.action_gameStageFragment_to_fightFragment, bundleOf(
                    "id" to 2
                )
            )
        }
    }


}
