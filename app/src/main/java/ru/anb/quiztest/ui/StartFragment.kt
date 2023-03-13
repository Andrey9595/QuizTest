package ru.anb.quiztest.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import ru.anb.quiztest.R

class StartFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_start, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val button: Button = getView()?.findViewById(R.id.button) as Button

        button.setOnClickListener {
            toStartGame()
        }
    }

    private fun toStartGame() {
        val action = StartFragmentDirections.actionStartFragmentToGameFragment()
        NavHostFragment.findNavController(this).navigate(action)
    }
}