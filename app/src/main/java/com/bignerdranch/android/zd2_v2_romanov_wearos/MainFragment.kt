package com.bignerdranch.android.zd2_v2_romanov_wearos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import androidx.fragment.app.FragmentTransaction

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private lateinit var buttonDiscussions1: View
    private lateinit var buttonDiscussions2: View
    private lateinit var buttonFavorite: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonDiscussions1 = view.findViewById(R.id.buttonDiscussion)
        buttonDiscussions2 = view.findViewById(R.id.buttonDiscussion1)

        buttonFavorite = view.findViewById(R.id.buttonFavorites)

        buttonDiscussions1.setOnClickListener {
            btnDisc(view)
        }

        buttonDiscussions2.setOnClickListener {
            btnDisc(view)
        }

        buttonFavorite.setOnClickListener {
            btnFav(view)
        }
    }

    fun btnDisc(view: View)
    {
        val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragment_container_view, DiscussionFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    fun btnFav(view: View)
    {
        val fragmentTransaction: FragmentTransaction = parentFragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.fragment_container_view, FavoritesFragment())
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MainFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}