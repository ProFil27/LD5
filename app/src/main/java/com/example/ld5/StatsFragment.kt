package com.example.ld5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

// 3 fragmentas: rodomas, kai tekste nėra A/a raidžių.
// Parodo ilgį, balsių skaičių ir didžiųjų bei mažųjų raidžių skaičių.
class StatsFragment : Fragment() {

    private val vowels = "aąeęėiįyouųū"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_stats, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val text = requireArguments().getString(ARG_TEXT, "")

        val length = text.length
        val vowelCount = text.count { it.lowercaseChar() in vowels }
        val upperCount = text.count { it.isUpperCase() }
        val lowerCount = text.count { it.isLowerCase() }

        view.findViewById<TextView>(R.id.stats_text).text = listOf(
            getString(R.string.stats_length, length),
            getString(R.string.stats_vowels, vowelCount),
            getString(R.string.stats_upper, upperCount),
            getString(R.string.stats_lower, lowerCount)
        ).joinToString("\n")
    }

    companion object {
        const val ARG_TEXT = "text"

        fun newInstance(text: String) = StatsFragment().apply {
            arguments = Bundle().apply { putString(ARG_TEXT, text) }
        }
    }
}
