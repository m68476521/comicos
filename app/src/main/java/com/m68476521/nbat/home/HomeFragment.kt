package com.m68476521.nbat.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.m68476521.nbat.component.ApplicationComponent
import com.m68476521.nbat.component.HasComponent
import com.m68476521.nbat.databinding.FragmentHomeBinding
import com.m68476521.nbat.model.MyModel
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private val viewModel : MyModel by viewModels()
    private lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (requireActivity().application as? HasComponent<ApplicationComponent>)?.component?.run {
            inject(viewModel)
        }
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clicked.setOnClickListener {
            lifecycleScope.launch {
                val response = viewModel.getData()
            }
        }
    }
}