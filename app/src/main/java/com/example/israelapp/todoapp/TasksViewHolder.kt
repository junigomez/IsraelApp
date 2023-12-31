package com.example.israelapp.todoapp
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Paint
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.israelapp.R


class TasksViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val tvTask:TextView = view.findViewById(R.id.tvTask)
        private  val cbTask:CheckBox = view.findViewById(R.id.cbTask)

    fun render(task: Task){

        if(task.isSelected){
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }else{
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
        tvTask.text = task.name
        cbTask.isChecked = task.isSelected

        when(task.category){
            TaskCategory.Business -> {
                cbTask.buttonTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(cbTask.context, R.color.business_category)
                )
            }
            TaskCategory.Other -> {
                cbTask.buttonTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(cbTask.context, R.color.other_category)
                )
            }
            TaskCategory.Personal -> {
                cbTask.buttonTintList = ColorStateList.valueOf(
                    ContextCompat.getColor(cbTask.context, R.color.personal_category)
                )
            }

        }



    }

}