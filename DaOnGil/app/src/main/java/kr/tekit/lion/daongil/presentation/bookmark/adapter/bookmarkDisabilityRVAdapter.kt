package kr.tekit.lion.daongil.presentation.bookmark.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kr.tekit.lion.daongil.R
import kr.tekit.lion.daongil.databinding.ItemBookmarkDisabiltiyTypeBinding
import kr.tekit.lion.daongil.databinding.ItemDisabilityTypeBinding

class bookmarkDisabilityRVAdapter(var typeList : List<Int>) : RecyclerView.Adapter<bookmarkDisabilityRVAdapter.bookmarkDisabilityViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bookmarkDisabilityViewHolder {
        val binding : ItemBookmarkDisabiltiyTypeBinding = ItemBookmarkDisabiltiyTypeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false)

        return bookmarkDisabilityViewHolder(binding)
    }

    override fun getItemCount(): Int = typeList.size

    override fun onBindViewHolder(holder: bookmarkDisabilityViewHolder, position: Int) {
        holder.bind(typeList[position])
    }

    class bookmarkDisabilityViewHolder(val binding: ItemBookmarkDisabiltiyTypeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item : Int) {
            val typeId = when(item) {
                1 -> R.drawable.physical_disability_radius_icon
                2 -> R.drawable.visual_impairment_radius_icon
                3 -> R.drawable.hearing_impairment_radius_icon
                4 -> R.drawable.infant_familly_radius_icon
                else -> R.drawable.elderly_people_radius_icon
            }
            binding.itemDisabilityTypeIv.setImageResource(typeId)
        }
    }

}