package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(
    private val recipeList: List<RecipeItem>,
    private val itemClickListener: OnItemClickListener
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    // ViewHolder class to bind the data
    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.recipe_image)
        val titleTextView: TextView = itemView.findViewById(R.id.recipe_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.recipe_description) // New
        val likeButton: Button = itemView.findViewById(R.id.like_button)
        val shareButton: Button = itemView.findViewById(R.id.share_button)

        init {
            itemView.setOnClickListener {
                itemClickListener.onItemClick(adapterPosition)
            }
            likeButton.setOnClickListener {
                itemClickListener.onLikeClick(adapterPosition)
            }
            shareButton.setOnClickListener {
                itemClickListener.onShareClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.imageView.setImageResource(recipe.imageResId)
        holder.titleTextView.text = recipe.title
        holder.descriptionTextView.text = recipe.description // Set description
    }

    override fun getItemCount(): Int {
        return recipeList.size
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
        fun onLikeClick(position: Int)
        fun onShareClick(position: Int)
    }
}
