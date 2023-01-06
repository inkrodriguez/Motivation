package com.example.motivation.fragments
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.motivation.R
import com.example.motivation.databinding.FragmentBodyBinding


class BodyFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_body, container, false)

        var myPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context)

        val name = myPreferences.getString("USER_NAME", "")
        val txt = view.findViewById<TextView>(R.id.textViewSaudacao)

        txt.text = "Olá, $name"

        return view
    }
}

