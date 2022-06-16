package com.devsoc.parc.data

data class CarEntry(
    val carNumber: String = "",
    val phoneNumber: Long = 0,
    val parkingSpaceAllotted: String = "",
    val imgPath: String = "",
    var arriveTime: Time = Time(-1,0,),
    val departTime: Time = Time(-1,0,),
)