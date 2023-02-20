package platzi.gnarbaiz.testapp.ui.widgets

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import platzi.gnarbaiz.testapp.ui.R

@BindingAdapter("show")
fun setVisibility(v: View, show: Boolean) {
    v.visibility = if (show) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl", "isSmallerImage", requireAll = false)
fun setImageUrl(imageView: ImageView, url: String?, isSmallerImage: Boolean) {
    if (url.isNullOrEmpty()) {
        imageView.setImageResource(R.drawable.ic_logo);
    } else {
        val builder = Picasso.with(imageView.context)
            .load(url)
            .error(R.drawable.ic_image_error)
        if (isSmallerImage) {
            builder.resize(256, 256)
            builder.placeholder(R.drawable.ic_logo)
            builder.centerCrop()
        } else {
            builder.fit()
        }
        builder.into(imageView)
    }
}