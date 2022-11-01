package com.example.tabtoolbarapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var vpViewPager:ViewPager2;
    private lateinit var tlViewTab:TabLayout;

    //creamos el adaptador que se inicie solamente cuando se necesite
    private val adapterFragment by lazy {
        //clase que tiene el adaptador
        //con dis le decimos que se ejecutará aqui (un fragment activity)
        vpAdapterCustom(this);
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vpViewPager = findViewById(R.id.main_vp_viewPager);
        tlViewTab = findViewById(R.id.main_tl_viewTab);

        vpViewPager.adapter = adapterFragment;

        val mediatorTable = TabLayoutMediator(tlViewTab,vpViewPager,
            TabLayoutMediator.TabConfigurationStrategy({
                tab, position ->
                when(position){
                    0 -> {
                        tab.text = "opción 1"
                        tab.setIcon(R.drawable.icon_home);
                        val badge:BadgeDrawable = tab.orCreateBadge;
                        badge.backgroundColor = ContextCompat.getColor(applicationContext,R.color.red);
                        badge.number = 17;
                        badge.isVisible;
                    }
                    1 -> {
                        tab.text = "opcion 2"
                        tab.setIcon(R.drawable.icon_tab);
                        val badge:BadgeDrawable = tab.orCreateBadge;
                        badge.backgroundColor = ContextCompat.getColor(applicationContext,R.color.red);
                        badge.isVisible;
                    }
                    2 -> {
                        tab.text = "opción 3"
                        tab.setIcon(R.drawable.icon_message);
                        //definir color del circulo de notificacion
                        val badge:BadgeDrawable = tab.orCreateBadge;
                        badge.backgroundColor = ContextCompat.getColor(applicationContext,R.color.red);
                        //numero que aparecerá en la notificacion
                        badge.number = 100;
                        //numero maximo de notificaciones si >100 aparece +99
                        badge.maxCharacterCount = 3;
                        //hacer visible
                        badge.isVisible;
                    }
                }
            }))
        mediatorTable.attach();

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu,menu);
        return true;
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_home ->{
                Toast.makeText(this,"Has seleccionado home",Toast.LENGTH_SHORT).show();
            }
            R.id.menu_dashboard ->{
                Toast.makeText(this,"Has seleccionado dashboard",Toast.LENGTH_SHORT).show();
            }
            R.id.menu_Pagos ->{
                Toast.makeText(this,"Has seleccionado pagos",Toast.LENGTH_SHORT).show();
            }
            R.id.menu_newActivity ->{
                Toast.makeText(this,"Has decidico crear una nueva actividad",Toast.LENGTH_SHORT).show();
                val newWindow:Intent = Intent(applicationContext,ScroolViewApp::class.java);
                startActivity(newWindow);
            }
            R.id.menu_cerrar ->{
                finish();
            }
        }
        return true;
    }
}