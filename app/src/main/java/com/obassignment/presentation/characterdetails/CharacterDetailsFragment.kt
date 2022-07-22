package com.obassignment.presentation.characterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.obassignment.databinding.FragmentCharacterDetailsBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterDetailsFragment : Fragment() {
    private var _binding: FragmentCharacterDetailsBinding? = null
    private val binding: FragmentCharacterDetailsBinding
        get() = _binding!!

    private val characterDetailsViewModel: CharacterDetailsViewModel by viewModel()
    private val args: CharacterDetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterDetailsBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        args.charaterId.let {
            characterDetailsViewModel.getCharacterDetails(it)
        }
        getCharacterResponseById()
        setClickOnBackButton()
    }

    private fun getCharacterResponseById() {
        lifecycle.coroutineScope.launchWhenCreated {
            characterDetailsViewModel.characterDetails.collect {
                if (it.isLoading) {
                    binding.txtNodata.visibility = View.GONE
                    binding.txtprogressBar.visibility = View.VISIBLE
                }
                if (it.error.isNotBlank()) {
                    binding.txtNodata.visibility = View.GONE
                    binding.txtprogressBar.visibility = View.GONE
                }
                it.data?.let {
                    if (it.isEmpty()) {
                        binding.txtNodata.visibility = View.VISIBLE
                    }
                    binding.txtprogressBar.visibility = View.GONE
                    binding.result = it.get(0)
                }
            }
        }
    }

    private fun setClickOnBackButton() {
        binding.imageBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }
}