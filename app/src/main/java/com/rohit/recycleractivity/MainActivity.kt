package com.rohit.recycleractivity

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.rohit.recycleractivity.databinding.ActivityLayoutBinding
import com.rohit.recycleractivity.databinding.ActivityMainBinding
import com.rohit.recycleractivity.databinding.EditlayoutBinding

class MainActivity : AppCompatActivity(),ClickInterface{
    lateinit var binding:ActivityMainBinding
    lateinit var studentAdapter: StudentAdapter
    var studentList = ArrayList<StudentModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        studentAdapter = StudentAdapter(studentList, this)
        binding.rview.layoutManager = LinearLayoutManager(this)
        binding.rview.adapter = studentAdapter

        binding.ftbtn.setOnClickListener {
            val dialogBinding = ActivityLayoutBinding.inflate(layoutInflater)
            val dialog = Dialog(this)
            dialog.setContentView(dialogBinding.root)
            dialogBinding.btnAdd.setOnClickListener {
                if (dialogBinding.etName.text.isEmpty()) {
                    dialogBinding.etName.error = "Enter Name"
                } else if (dialogBinding.etRollNo.text.isEmpty()) {
                    dialogBinding.etRollNo.error = "Enter RollNo."
                } else {
                    studentList.add(
                        StudentModel(
                            dialogBinding.etName.text.toString(),
                            dialogBinding.etRollNo.text.toString()
                        )
                    )
                    dialog.dismiss()
                    studentAdapter.notifyDataSetChanged()
                }
            }
            dialog.show()
        }
    }

   override fun editClick(position: Int) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_LONG).show()
        val dialogBinding = EditlayoutBinding.inflate(layoutInflater)
        val dialog = Dialog(this)
        dialog.setContentView(dialogBinding.root)
        dialogBinding.btnEdit.setOnClickListener {
            if (dialogBinding.etName.text.isEmpty()) {
                dialogBinding.etName.error = "Enter Name"
            } else if (dialogBinding.etRollNo.text.isEmpty()) {
                dialogBinding.etRollNo.error = "Enter RollNO."
            } else {
                studentList.set(
                    position,
                    StudentModel(
                        dialogBinding.etName.text.toString(),
                        dialogBinding.etRollNo.text.toString()
                    )
                )
                dialog.dismiss()
                studentAdapter.notifyDataSetChanged()
            }
        }
        dialogBinding.btnDelete.setOnClickListener {
            studentList.removeAt(position)
            dialog.dismiss()
            studentAdapter.notifyDataSetChanged()
        }
        dialog.show()
    }
    }
