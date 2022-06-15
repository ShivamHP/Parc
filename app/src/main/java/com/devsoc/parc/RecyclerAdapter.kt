package com.devsoc.parc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.devsoc.parc.data.CarEntry

class RecyclerAdapter(private val mList: List<CarEntry>, private val context: Context, private val viewLifecycleOwner: LifecycleOwner) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.car_entry, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val currentCarEntry = mList[position]

        val imageView: ImageView = holder.itemView.findViewById(R.id.itemImageView)
        val carNumber: TextView = holder.itemView.findViewById(R.id.itemCarNumberText)
        val phoneNumber: TextView = holder.itemView.findViewById(R.id.itemPhoneNumber)
        val arrivalTime: TextView = holder.itemView.findViewById(R.id.itemArrivalTime)
        val departureTime: TextView = holder.itemView.findViewById(R.id.itemDepartureTime)

        //TODO: Add proper image to imageView
        imageView.setImageResource(R.color.purple_200)
        carNumber.setText(currentCarEntry.carNumber)
        phoneNumber.setText(currentCarEntry.phoneNumber)
        arrivalTime.setText("${currentCarEntry.arriveTime.hour} : ${currentCarEntry.arriveTime.min}")
        departureTime.setText("${currentCarEntry.departTime.hour} : ${currentCarEntry.departTime.min}")
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return mList.size
    }

    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
    }
}