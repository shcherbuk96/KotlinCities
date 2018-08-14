package com.example.yauheni_shcharbuk.kotlinepamexample.presentation.activity_main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.yauheni_shcharbuk.kotlinepamexample.R
import com.example.yauheni_shcharbuk.kotlinepamexample.di.GlideApp
import com.example.yauheni_shcharbuk.kotlinepamexample.pojo.Photo
import kotlinx.android.synthetic.main.item_recyclerview.view.*

class RecyclerAdapter(private val items: MutableList<Photo>, val context:Context, val listener: RecyclerAdapter.Listener) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {



    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val photo = items[position]
        holder.name.text = photo.title

        GlideApp
                .with(holder.photo.context)
                .load(items[position].url)
                .error(R.mipmap.error_ic)
                .into(holder.photo)

        holder.cardView.setOnClickListener(object : View.OnClickListener {
            override fun onClick(p0: View?) {
                listener.click(photo.title, photo.url)
            }

        })
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {
        val itemView = LayoutInflater.from(p0.context).inflate(R.layout.item_recyclerview, p0, false)

        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    interface Listener {
        fun click(title: String, url: String)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val photo = itemView.item_photo_image_view!!
        val name = itemView.item_name_text_view!!
        val cardView = itemView.item_card_view!!


    }

    fun updateList(list: List<Photo>?) {
        if (list != null) {
            items.addAll(list)
        }
        notifyDataSetChanged()
    }
}