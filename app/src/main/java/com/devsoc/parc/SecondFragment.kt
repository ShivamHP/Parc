package com.devsoc.parc

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.findFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.devsoc.parc.data.CarEntry
import com.devsoc.parc.data.Time
import com.devsoc.parc.databinding.FragmentSecondBinding

class secondFragment : Fragment() {

    private lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        var dummy_data = mutableListOf<CarEntry>(
            CarEntry(
                carNumber = "GJ-05 6969",
                phoneNumber = 9377612136,
                parkingSpaceAllotted = "A1",
                imgPath = "",
                arriveTime = Time(10, 30),
                departTime = Time(12, 30),
            ),
            CarEntry(
                carNumber = "RJ-05 6999",
                phoneNumber = 9377652536,
                parkingSpaceAllotted = "A2",
                imgPath = "",
                arriveTime = Time(13, 30),
                departTime = Time(16, 36),
            ),
            CarEntry(
                carNumber = "DH-05 8009",
                phoneNumber = 9377525236,
                parkingSpaceAllotted = "A3",
                imgPath = "",
                arriveTime = Time(9, 30),
                departTime = Time(18, 56),
            ),
            CarEntry(
                carNumber = "GJ-05 6969",
                phoneNumber = 9377612136,
                parkingSpaceAllotted = "A4",
                imgPath = "",
                arriveTime = Time(10, 30),
                departTime = Time(12, 30),
            ),
            CarEntry(
                carNumber = "RJ-05 6999",
                phoneNumber = 9377652536,
                parkingSpaceAllotted = "A5",
                imgPath = "",
                arriveTime = Time(13, 30),
                departTime = Time(16, 36),
            ),
            CarEntry(
                carNumber = "DH-05 8009",
                phoneNumber = 9377525236,
                parkingSpaceAllotted = "A6",
                imgPath = "",
                arriveTime = Time(9, 30),
                departTime = Time(18, 56),
            ),
            CarEntry(
                carNumber = "GJ-05 6969",
                phoneNumber = 9377612136,
                parkingSpaceAllotted = "A7",
                imgPath = "",
                arriveTime = Time(10, 30),
                departTime = Time(12, 30),
            ),
            CarEntry(
                carNumber = "RJ-05 6999",
                phoneNumber = 9377652536,
                parkingSpaceAllotted = "A8",
                imgPath = "",
                arriveTime = Time(13, 30),
                departTime = Time(16, 36),
            ),
            CarEntry(
                carNumber = "DH-05 8009",
                phoneNumber = 9377525236,
                parkingSpaceAllotted = "A9",
                imgPath = "",
                arriveTime = Time(9, 30),
                departTime = Time(18, 56),
            ),
        )

        binding.recyclerViewSecondFragment.adapter = RecyclerAdapter(dummy_data, requireContext(), this)
        binding.recyclerViewSecondFragment.layoutManager = LinearLayoutManager(requireContext())

        binding.fabSecondFragment.setOnClickListener {
            val navAction = secondFragmentDirections.actionSecondFragmentToFirstFragment2()
            view.findNavController().navigate(navAction)
        }

        binding.textView.setText("Parking space available = 1")

        super.onViewCreated(view, savedInstanceState)
    }

}