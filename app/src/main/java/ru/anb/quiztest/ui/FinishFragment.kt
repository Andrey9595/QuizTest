package ru.anb.quiztest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import ru.anb.quiztest.R

class FinishFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_finish, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toStartGame()
    }

    private fun toStartGame() {
        val action = FinishFragmentDirections.actionFinishFragmentToStartFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}