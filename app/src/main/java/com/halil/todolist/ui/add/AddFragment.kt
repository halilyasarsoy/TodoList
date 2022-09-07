package com.halil.todolist.ui.add

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.halil.todolist.R
import com.halil.todolist.database.TaskEntry
import com.halil.todolist.databinding.FragmentAddBinding
import com.halil.todolist.viewmodel.TaskViewModel


@Suppress("UNREACHABLE_CODE")
class AddFragment : Fragment() {


    private val viewModel: TaskViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentAddBinding.inflate(inflater)


        val myAdapter = ArrayAdapter<String>(
            requireActivity(),
            android.R.layout.simple_spinner_dropdown_item,
            resources.getStringArray(R.array.priorities)
        )
        binding.apply {
            spinner.adapter = myAdapter
            buttonAdd.setOnClickListener {
                if (TextUtils.isEmpty((editText.text))) {
                    Toast.makeText(requireContext(), "Please Enter Text !! ", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }

                val title = editText.text.toString()
                val priority = spinner.selectedItemPosition
                val taskEntry = TaskEntry(
                    0,
                    title,
                    priority,
                    System.currentTimeMillis()
                )
                viewModel.insert(taskEntry)
                Toast.makeText(requireContext(), "Successfully Added! ", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_addFragment_to_taskFragment)
            }
        }
        return binding.root

    }
}

//var id: Int,
//var title: String,
//var priority: Int,
//var timestamp: Long,



