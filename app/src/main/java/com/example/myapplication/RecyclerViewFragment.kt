package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Toast
import android.util.Log

class RecyclerViewFragment : Fragment(R.layout.fragment_recycler_view) {

    private lateinit var recyclerView: RecyclerView
    private lateinit var recipeAdapter: RecipeAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Sample data for recipes with descriptions
        val recipes = listOf(
            RecipeItem(
                id = 1,
                title = "Margherita Pizza",
                imageResId = R.drawable.sample_recipe_image,
                description = "A classic Margherita pizza with a crispy crust, fresh tomato sauce, melted mozzarella, and fragrant basil."
            ),
            RecipeItem(
                id = 2,
                title = "Cheeseburger",
                imageResId = R.drawable.sample_recipe_image,
                description = "A juicy cheeseburger with a grilled beef patty, melted cheddar, lettuce, tomato, and a soft sesame seed bun."
            ),
            RecipeItem(
                id = 3,
                title = "Spaghetti Carbonara",
                imageResId = R.drawable.sample_recipe_image,
                description = "Creamy spaghetti carbonara with crispy pancetta, parmesan, and a velvety egg-based sauce."
            )
        )

        recyclerView = view.findViewById(R.id.recycler_view)

        // Initialize the adapter and set up click listeners
        recipeAdapter = RecipeAdapter(recipes, object : RecipeAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val item = recipes[position]
                Toast.makeText(context, "Clicked on: ${item.title}", Toast.LENGTH_SHORT).show()
                Log.d("RecyclerViewFragment", "Clicked: ${item.title}")
            }

            override fun onLikeClick(position: Int) {
                val item = recipes[position]
                Toast.makeText(context, "Liked: ${item.title}", Toast.LENGTH_SHORT).show()
                Log.d("RecyclerViewFragment", "Liked: ${item.title}")
            }

            override fun onShareClick(position: Int) {
                val item = recipes[position]
                Toast.makeText(context, "Shared: ${item.title}", Toast.LENGTH_SHORT).show()
                Log.d("RecyclerViewFragment", "Shared: ${item.title}")
            }
        })

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = recipeAdapter
    }
}
