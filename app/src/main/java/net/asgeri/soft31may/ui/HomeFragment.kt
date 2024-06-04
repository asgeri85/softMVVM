package net.asgeri.soft31may.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import net.asgeri.soft31may.databinding.FragmentHomeBinding
import net.asgeri.soft31may.utils.gone
import net.asgeri.soft31may.utils.visible


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val productAdapter = ProductAdapter()
    private val viewModel by viewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        binding.rvHome.adapter = productAdapter
        viewModel.getHomeData()

        productAdapter.onClickItem = {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeFragmentToDetailFragment2(
                    it
                )
            )
        }

    }

    private fun observeData() {
        viewModel.productList.observe(viewLifecycleOwner) {
            productAdapter.updateList(it)
        }

        viewModel.loading.observe(viewLifecycleOwner) {
            if (it) binding.progressBar.visible() else binding.progressBar.gone()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}