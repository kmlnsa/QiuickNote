package com.example.homework_6.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.homework_6.NoteAdapter
import com.example.homework_6.R
import com.example.homework_6.databinding.FragmentHomeBinding
import com.example.homework_6.ui.addSwipeListener

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val noteAdapter = NoteAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.grid.apply {
            layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
            adapter = noteAdapter
        }

        binding.toolbarHome.setOnMenuItemClickListener {
            when(it.itemId){
                R.id.search ->{
                    findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
                    true
                }
                else -> false
            }
        }

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_createNoteFragment)
        }

        viewModel.liveData.observe(viewLifecycleOwner) {
            noteAdapter.submitList(it)
        }

        binding.grid.addSwipeListener(
            swipeDirs = ItemTouchHelper.END,
            frontLayerId = R.id.front_card,
        ) {
            viewModel.deleteNote(it)
        }
    }
}
