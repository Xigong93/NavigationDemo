package pokercc.android.navigationdemo.smallgame


import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.postDelayed
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_fight.*

import pokercc.android.navigationdemo.R
import kotlin.random.Random

/**
 * 战斗页面
 */
class FightFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fight, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        stageTextView.text = "当前是第${arguments?.getInt("id", 0)}关"
        fightButton.setOnClickListener { view ->
            view.postDelayed({
                findNavController().navigate(
                    if (Random.nextBoolean()) {
                        R.id.action_fightFragment_to_gamePassFragment
                    } else {
                        R.id.action_fightFragment_to_gameOverFragment
                    }
                )
            }, 1000)
            var count = 0
            val runnable = Runnable {
                Toast.makeText(requireContext(), "砍第${++count}刀", Toast.LENGTH_SHORT).show()
                if (count < 10) {
                    view.postDelayed(, 500)
                }
            }
            view.postDelayed(
                runnable
                , 500
            )
        }
    }

}
