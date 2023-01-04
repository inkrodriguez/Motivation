package com.example.motivation.fragments
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.motivation.R
import com.example.motivation.SecurityPreferences
import org.w3c.dom.Text


class BodyFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_body, container, false)

        val name = this.context?.let { SecurityPreferences(it.applicationContext).getString("USER_NAME" ) }
        val txt = view.findViewById<TextView>(R.id.textViewSaudacao)

        txt.text = "Olá, $name"

        return view
    }
}

