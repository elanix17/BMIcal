package com.example.bmical.title

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.bmical.R
import com.example.bmical.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private lateinit var titleViewModel: TitleViewModel
    private lateinit var binding: FragmentTitleBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        titleViewModel = ViewModelProvider(this).get(TitleViewModel::class.java)

        binding= DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false
        )
        binding.lifecycleOwner = this

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.calbutton.setOnClickListener {
            titleViewModel.BMIcalculator(
                weight = binding.weightVal.text.toString().toInt(),
                height = binding.heightVal.text.toString().toInt()
            )
            val bundle = Bundle()
            bundle.putString("key", titleViewModel.result.value)
            findNavController().navigate(R.id.action_titleFragment_to_resultFragment2, bundle)
        }
    }
}