package com.obassignment.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.obassignment.databinding.FragmentCharacterListBinding
import com.obassignment.presentation.adapter.CharacterAdapter
import com.obassignment.presentation.characterList.CharacterListViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharacterListFragment : Fragment() {

    private val characterAdapter = CharacterAdapter()
    private val viewModel: CharacterListViewModel by viewModel()
    private var _binding: FragmentCharacterListBinding? = null

    val binding: FragmentCharacterListBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setAdapter()
        getCharacterListResponse()
        setOnItemClick()
    }
    private fun setAdapter(){
        binding.recyclerViewCharacters.apply {
            adapter = characterAdapter
        }
    }
    private fun getCharacterListResponse(){
        viewModel.getCharacterList()
        lifecycleScope.launchWhenCreated {
            viewModel.characterList.collect{
                if(it.isLoading){
                    binding.txtNodata.visibility = View.GONE
                    binding.txtprogressBar.visibility = View.VISIBLE
                }
                if(it.error.isNotBlank()){
                    binding.txtNodata.visibility = View.GONE
                    binding.txtprogressBar.visibility = View.GONE
                }
                it.data?.let {
                    if(it.isEmpty()){
                        binding.txtNodata.visibility = View.VISIBLE
                    }
                    binding.txtprogressBar.visibility = View.GONE
                    characterAdapter.setContent(it.toMutableList())
                }
            }
        }
    }
    private fun setOnItemClick(){
        characterAdapter.itemClickListener {
            findNavController().navigate(
                CharacterListFragmentDirections.actionCharaterListFragmentToCharaterDetailfragment(
                    it.id
                )
            )
        }
    }
}






