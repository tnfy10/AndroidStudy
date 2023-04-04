package xyz.myeoru.androidstudy.paging.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.setContentView
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.myeoru.androidstudy.R
import xyz.myeoru.androidstudy.databinding.ActivityPagingBinding

@AndroidEntryPoint
class PagingActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPagingBinding
    private val viewModel: PagingViewModel by viewModels()
    private val imageListAdapter: LoremPicsumListAdapter = LoremPicsumListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPagingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(
                this@PagingActivity,
                RecyclerView.VERTICAL,
                false
            )
            adapter = imageListAdapter
        }

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collectLatest {
                    when (it) {
                        PagingState.Init -> {
                            binding.loading.visibility = View.VISIBLE
                        }
                        is PagingState.Loaded -> {
                            binding.loading.visibility = View.INVISIBLE
                            imageListAdapter.submitData(it.imagePagingData)
                        }
                    }
                }
            }
        }
    }
}