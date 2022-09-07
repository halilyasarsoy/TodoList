package com.halil.todolist.ui.update

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.halil.todolist.R
import com.halil.todolist.database.TaskEntry
import com.halil.todolist.databinding.FragmentUpdateBinding
import com.halil.todolist.viewmodel.TaskViewModel


class UpdateFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentUpdateBinding.inflate(inflater)

        val args = UpdateFragmentArgs.fromBundle(requireArguments())

        binding.apply {
            updateEdtTask.setText(args.taskEntry.title)
            spinner.setSelection(args.taskEntry.priority)


            btnUpdate.setOnClickListener {
                if (TextUtils.isEmpty(updateEdtTask.text)) {
                    Toast.makeText(requireContext(), "Please Enter Text !!", Toast.LENGTH_SHORT)
                        .show()
                    return@setOnClickListener
                }
                val taskStr = updateEdtTask.text
                val priority = spinner.selectedItemPosition

                val taskEntry = TaskEntry(
                    args.taskEntry.id,
                    taskStr.toString(),
                    priority,
                    args.taskEntry.timestamp,
                )

                viewModel.update(taskEntry)
                Toast.makeText(requireContext(), "Updated", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_updateFragment_to_taskFragment)

            }


        }
        return binding.root

    }
}