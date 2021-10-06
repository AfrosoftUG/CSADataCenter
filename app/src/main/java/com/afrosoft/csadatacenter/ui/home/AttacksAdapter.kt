package com.afrosoft.csadatacenter.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.afrosoft.csadatacenter.databinding.SingleAttackLayoutBinding
import com.afrosoft.csadatacenter.models.Attack

class AttacksAdapter(val context: Context, val list: MutableList<Attack>): RecyclerView.Adapter<AttacksAdapter.AttackHolder>() {

    inner class AttackHolder(val binding: SingleAttackLayoutBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(attack: Attack) {

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttackHolder {
        return AttackHolder(SingleAttackLayoutBinding.inflate(LayoutInflater.from(context),parent,false))
    }

    override fun onBindViewHolder(holder: AttackHolder, position: Int) {
        holder.setData(list[position])
    }

    override fun getItemCount(): Int = list.size
}