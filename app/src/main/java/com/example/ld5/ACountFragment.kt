package com.example.ld5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

// 2 fragmentas: rodomas, kai tekste yra A/a raidžių. Parodo, kiek jų yra.
class ACountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_a_count, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val text = requireArguments().getString(ARG_TEXT, "")
        val count = text.count { it.equals('a', ignoreCase = true) }
        view.findViewById<TextView>(R.id.a_count_text).text = getString(R.string.a_count, count)
    }

    companion object {
        const val ARG_TEXT = "text"

        fun newInstance(text: String) = ACountFragment().apply {
            arguments = Bundle().apply { putString(ARG_TEXT, text) }
        }
    }
}
