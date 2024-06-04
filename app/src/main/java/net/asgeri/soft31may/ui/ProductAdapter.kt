package net.asgeri.soft31may.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.asgeri.soft31may.databinding.ItemProductBinding
import net.asgeri.soft31may.model.ProductResponse

class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    private val productList = arrayListOf<ProductResponse>()
    lateinit var onClickItem: (String) -> Unit

    inner class ProductViewHolder(val itemProductBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(itemProductBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = productList[position]

        holder.itemProductBinding.product = item

        holder.itemProductBinding.productLayout.setOnClickListener {
            onClickItem(item.id.toString())
        }

    }

    fun updateList(newList: List<ProductResponse>) {
        productList.clear()
        productList.addAll(newList)
        notifyDataSetChanged()
    }

}