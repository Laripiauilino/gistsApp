package com.larissa.gistsapp.presentation

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.larissa.gistsapp.R
import com.larissa.gistsapp.data.model.Gist
import com.larissa.gistsapp.databinding.ItemGistBinding
import com.larissa.gistsapp.domain.ClickListener

    class GistsAdapter (private val context: Context, private val clickListener: ClickListener? = null, var dataSet: MutableList<Gist> ): RecyclerView.Adapter<GistsAdapter.GistsViewHolder>() {

        inner class GistsViewHolder(val binding: ItemGistBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GistsViewHolder {
        val binding = ItemGistBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GistsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GistsViewHolder, position: Int) {
        with(holder) {
            with(dataSet[position]) {
                Glide.with(context)
                    .load(dataSet[position].ownerPicture)
                    .into(binding.imgGistPicture)

                binding.crdGist.setOnClickListener {
                    val intent = Intent(context, GistUserDetailsActivity::class.java)
                    intent.putExtra(USER_PICTURE_ITEM,dataSet[position].ownerPicture)
                    intent.putExtra(LOGIN_ITEM, dataSet[position].ownerLogin)
                    context.startActivity(intent)
                }
                binding.txtUserName.text = ownerLogin
                binding.txtFileType.text = fileType

                if (dataSet[position].isFavorite) {
                    binding.btnFavorite.setImageResource(R.drawable.ic_favorite_filled)
                }else{
                    binding.btnFavorite.setImageResource(R.drawable.ic_favorite_outlined)}
                binding.btnFavorite.setOnClickListener {
                    clickListener?.onFavoriteClickListener(dataSet[position], true, position) }


                }
            }
        }

    override fun getItemCount(): Int = dataSet.size

    companion object {
        const val LOGIN_ITEM = "login"
        const val USER_PICTURE_ITEM = "avatar_url"
    }
}


