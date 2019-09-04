package pokercc.android.navigationdemo


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController

/**
 * A simple [Fragment] subclass.
 */
class NewsListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (view as ViewGroup).apply {
            (0 until childCount).forEach { index ->
                getChildAt(index).setOnClickListener {
                    findNavController().navigate(
                        R.id.action_newsListFragment_to_newDetailFragment,
                        Bundle().apply {
                            putString("id", index.toString())
                        })
                }
            }
        }

    }

}
