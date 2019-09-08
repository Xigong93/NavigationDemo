package pokercc.android.navigationdemo.smallgame


import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.view.Gravity
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
            var count = 0
            view.postDelayed(
                object : Runnable {
                    override fun run() {

                        if (count < 10) {
                            showToast("砍第${++count}刀")
                            view.postDelayed(this, 500)
                        } else {
                            findNavController().navigate(
                                if (Random.nextBoolean()) {
                                    R.id.action_fightFragment_to_gamePassFragment
                                } else {
                                    R.id.action_fightFragment_to_gameOverFragment
                                }
                            )
                        }
                    }
                }
                , 500
            )
        }
    }

    private val toast: Toast by lazy {
        Toast.makeText(requireContext(), "", Toast.LENGTH_SHORT).apply {
            setGravity(Gravity.CENTER, 0, 0)
        }
    }

    fun showToast(message: String) {
        toast.apply {
            setText(message)
            show()
        }
    }

}
