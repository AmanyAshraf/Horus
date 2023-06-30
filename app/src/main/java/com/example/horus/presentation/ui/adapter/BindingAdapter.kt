package com.example.horus.presentation.ui.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.example.horus.data.model.*


@BindingAdapter("img")
fun bindImgHotel(imageView: ImageView, data: HotelBody?) {

    data?.let {
        Glide.with(imageView.context)
            .load(it.image)
            .into(imageView)
    }
}
@BindingAdapter("img")
fun bindImgBank(imageView: ImageView, data: BankBody?) {

    data?.let {
        Glide.with(imageView.context)
            .load(it.image)
            .into(imageView)
    }
}
@BindingAdapter("img")
fun bindImgRestaurant(imageView: ImageView, data: RestaurantBody?) {

    data?.let {
        Glide.with(imageView.context)
            .load(it.image)
            .into(imageView)
    }
}
@BindingAdapter("img")
fun bindImgSearch(imageView: ImageView, data: SearchBody) {

    data?.let {
        Glide.with(imageView.context)
            .load(it.image)
            .into(imageView)
    }
}
@BindingAdapter("img")
fun bindImgMuseum(imageView: ImageView, data: MuseumBody) {

    data?.let {
        Glide.with(imageView.context)
            .load(it.image)
            .into(imageView)
    }
}