package xyz.myeoru.androidstudy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import dagger.hilt.android.AndroidEntryPoint
import xyz.myeoru.androidstudy.databinding.ActivityMainBinding
import xyz.myeoru.androidstudy.paging.presentation.PagingActivity

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            pagingBtn.setOnClickListener {
                startActivity(Intent(applicationContext, PagingActivity::class.java))
            }
        }
    }
}