package com.example.bmical.result

import androidx.fragment.app.viewModels
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.bmical.R
import com.example.bmical.databinding.FragmentResultBinding
import com.example.bmical.title.TitleViewModel

class resultFragment : Fragment() {
    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_result, container, false
        )
//        binding.lifecycleOwner=this
        val args = arguments?.getString("key")
        Log.i("got", args?:"noting")
        binding.resulttext.text=args?:"nothing"
        binding.doneButton.setOnClickListener {
            findNavController().popBackStack()
        }
        return binding.root
    }
}