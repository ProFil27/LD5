package com.example.ld5

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment

// 1 fragmentas: rodo ListView ir praneša Activity, kuris įrašas pasirinktas
class ListFragment : Fragment() {

    interface OnItemSelectedListener {
        fun onItemSelected(text: String)
    }

    private val items = listOf(
        "Tekstas su A raidėmis",
        "Be ieškomo simbolio",
        "Čia yra ieškomas simbolis",
        "Nieko nebus",
        "Rasi ko ieškai",
        "Šiandien graži diena",
        "Keliautojas Ona",
        "Muzika groja"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val listView = view.findViewById<ListView>(R.id.list_view)
        listView.adapter = ArrayAdapter(requireContext(), R.layout.item_text, items)
        listView.setOnItemClickListener { _, _, position, _ ->
            (activity as OnItemSelectedListener).onItemSelected(items[position])
        }
    }
}
