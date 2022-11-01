package com.example.tabtoolbarapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class vpAdapterCustom(fragment:FragmentActivity):FragmentStateAdapter(fragment) {

    companion object{
        private const val ARG_OBJECT = "object";
    }
    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    //cantidad de tabs que se van a visualizar
    override fun getItemCount(): Int =3;

    /**
     * Provide a new Fragment associated with the specified position.
     *
     *
     * The adapter will be responsible for the Fragment lifecycle:
     *
     *  * The Fragment will be used to display an item.
     *  * The Fragment will be destroyed when it gets too far from the viewport, and its state
     * will be saved. When the item is close to the viewport again, a new Fragment will be
     * requested, and a previously saved state will be used to initialize it.
     *
     * @see ViewPager2.setOffscreenPageLimit
     */
    override fun createFragment(_position: Int): Fragment {
        val fragment = ViewFragment();
        fragment.arguments = Bundle().apply {
            putInt(ARG_OBJECT,_position+1);
        }
        return fragment;
    }
}