package com.example.tabtoolbarapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class ScroolViewApp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrool_view_app)
    }

    fun fruitSelection(vista:View){
        when(vista.id){
            R.id.ib_bananas -> Toast.makeText(this,"Has seleccionado las bananas",Toast.LENGTH_SHORT).show();
            R.id.ib_cerezas -> Toast.makeText(this,"Has seleccionado las cerezas",Toast.LENGTH_SHORT).show();
            R.id.ib_frambuesas -> Toast.makeText(this,"Has seleccionado las frambuesas",Toast.LENGTH_SHORT).show();
            R.id.ib_fresas -> Toast.makeText(this,"Has seleccionado las fresas",Toast.LENGTH_SHORT).show();
            R.id.ib_kiwis -> Toast.makeText(this,"Has seleccionado los kiwis",Toast.LENGTH_SHORT).show();
            R.id.ib_mangos -> Toast.makeText(this,"Has seleccionado los mangos",Toast.LENGTH_SHORT).show();
            R.id.ib_sandia -> Toast.makeText(this,"Has seleccionado las sandias",Toast.LENGTH_SHORT).show();
            R.id.ib_naranjas -> Toast.makeText(this,"Has seleccionado las naranjas",Toast.LENGTH_SHORT).show();

        }
    }
}