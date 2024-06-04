package net.asgeri.soft31may.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import net.asgeri.soft31may.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {
    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!
    private val imageAdapter = ImagePagerAdapter()
    private val args: DetailFragmentArgs by navArgs()
    private val viewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewPager.adapter = imageAdapter
        binding.dotsIndicatorl.attachTo(binding.viewPager)
        viewModel.getDataDetail(args.id)
        observeData()
    }

    private fun observeData(){
        viewModel.detailData.observe(viewLifecycleOwner){
            imageAdapter.updateList(it)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}