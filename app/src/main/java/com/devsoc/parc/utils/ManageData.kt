package com.devsoc.parc.utils

import android.content.Context
import com.devsoc.parc.data.CarEntries
import com.devsoc.parc.data.CarEntry
import com.devsoc.parc.data.Time
import com.google.gson.Gson
import org.json.JSONArray
import org.json.JSONObject
import java.io.*
import java.util.*

class ManageData(context: Context) {

    private val file = File(context.filesDir, "data")

    fun readFileAsString(): String {
        val fileReader = FileReader(file)
        val bufferedReader = BufferedReader(fileReader)
        val stringBuilder = StringBuilder()
        var line: String = bufferedReader.readLine()
        while (line != null) {
            stringBuilder.append(line).append("\n")
            line = bufferedReader.readLine()
        }
        bufferedReader.close()
        return stringBuilder.toString()
    }

    fun writeFileAsString(data: MutableList<CarEntry>){
        var carEntryArray: JSONArray = JSONArray()
        for(carEntry in data){
            carEntryArray.put(carEntry)
        }
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)
        bufferedWriter.write(carEntryArray.toString())
        bufferedWriter.close()
    }

    fun getData() : MutableList<CarEntry> {
        val carEntries = Gson().fromJson(readFileAsString(), CarEntries::class.java)
        return carEntries.carEntryArray
    }

    fun addData(carEntry: CarEntry){
        val currentTime = Calendar.getInstance().getTime()
        carEntry.arriveTime = Time(currentTime.hours, currentTime.minutes)
        val dataTillNow : MutableList<CarEntry> = getData()
        dataTillNow.add(carEntry)
        writeFileAsString(dataTillNow)
        val jsonObject = CarEntryToJson(carEntry)
        val fileWriter = FileWriter(file)
        val bufferedWriter = BufferedWriter(fileWriter)
        bufferedWriter.write(jsonObject.toString())
        bufferedWriter.close()
    }

    fun JsonToCarEntry(jsonObject: JSONObject) : CarEntry{
        return CarEntry(
            carNumber = jsonObject.getString("carNumber"),
            phoneNumber = jsonObject.getLong("phoneNumber"),
            parkingSpaceAllotted = jsonObject.getString("parkingSpaceAllotted"),
            imgPath = jsonObject.getString("imagePath"),
            arriveTime = jsonObject.get("arriveTime") as Time,
            departTime = jsonObject.get("departTime") as Time,
        )
    }

    fun CarEntryToJson(carEntry: CarEntry) : JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("carNumber", carEntry.carNumber)
        jsonObject.put("phoneNumber", carEntry.phoneNumber)
        jsonObject.put("parkingSpaceAllotted", carEntry.parkingSpaceAllotted)
        jsonObject.put("imagePath", carEntry.imgPath)
        jsonObject.put("arriveTime", carEntry.arriveTime)
        jsonObject.put("departTime", carEntry.departTime)
        return jsonObject
    }
}