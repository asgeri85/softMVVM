package net.asgeri.soft31may.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.asgeri.soft31may.databinding.ItemImageBinding

class ImagePagerAdapter : RecyclerView.Adapter<ImagePagerAdapter.ImageViewHolder>() {

    private val imageList = arrayListOf<String>()

    inner class ImageViewHolder(val itemImageBinding: ItemImageBinding) :
        RecyclerView.ViewHolder(itemImageBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ImageViewHolder(view)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        val item = imageList[position]

        holder.itemImageBinding.image = item
    }

    fun updateList(newList: List<String>) {
        imageList.clear()
        imageList.addAll(newList)
        notifyDataSetChanged()
    }

}