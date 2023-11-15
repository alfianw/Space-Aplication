package com.example.spacexapplication

import Space
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListCardSpace : AppCompatActivity() {

    private lateinit var rvSpace: RecyclerView
    private val list = ArrayList<Space>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_card_space)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        rvSpace = findViewById(R.id.rv_space)
        rvSpace.setHasFixedSize(true)

        list.addAll(getListSpace())
        showRecyclerList()
    }

    private fun getListSpace(): ArrayList<Space>{
        val dataName = resources.getStringArray(R.array.nameSpace)
        val dataDescription = resources.getStringArray(R.array.desArray)
        val dataPhoto = resources.obtainTypedArray(R.array.photoSpace)
        val character = resources.getStringArray(R.array.charArray)
        val averange = resources.getStringArray(R.array.aveArray)
        val listSpace = ArrayList<Space>()
        for (i in dataName.indices){
            val space =Space(dataName[i], dataDescription[i], dataPhoto.getResourceId(i, -1), averange[i], character[i])
            listSpace.add(space)
        }
        return  listSpace
    }

    private fun showRecyclerList(){
        rvSpace.layoutManager = LinearLayoutManager(this)
        val listSpaceAdapter = ListSpaceAdapter(list)
        rvSpace.adapter = listSpaceAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}