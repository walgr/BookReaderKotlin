package com.wpf.bookreaderkotlin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.wpf.bookreaderkotlin.adapters.BookAdapter
import com.wpf.bookreaderkotlin.data.BookInfo
import com.wpf.bookreaderkotlin.databinding.FragmentHomeBinding
import com.wpf.bookreaderkotlin.mvp.viewmodels.HomeViewModel
import com.wpf.bookreaderkotlin.utilities.HOME_BOOK_LINE
import com.wpf.bookreaderkotlin.utilities.InjectorUtils

class HomeFragment : BaseFragment() {

    private val viewModel: HomeViewModel by viewModels {
        InjectorUtils.provideHomeViewModelFactory(InjectorUtils.getBookInfoRepository(requireContext()))
    }

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val adapter = BookAdapter()
        binding.bookList.layoutManager = GridLayoutManager(
            requireContext(), HOME_BOOK_LINE,
            RecyclerView.VERTICAL, false
        )
        binding.bookList.adapter = adapter
        subscribeUi(adapter)
        return binding.root
    }

    private fun subscribeUi(adapter: BookAdapter) {
        viewModel.bookList.observe(viewLifecycleOwner, Observer<List<BookInfo>> { result ->
            if (!result.isNullOrEmpty()) {
                adapter.submitList(result)
            }
        })
    }
}