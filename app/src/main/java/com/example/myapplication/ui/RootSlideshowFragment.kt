package com.example.myapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.myapplication.R

class RootSlideshowFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_root_slideshow, container, false)
    }

    override fun onResume() {
        super.onResume()
        val navHostFragment = childFragmentManager.findFragmentById(R.id.root) as NavHostFragment
        val navController = navHostFragment.navController
        val appCompatActivity = activity as AppCompatActivity
        NavigationUI.setupActionBarWithNavController(appCompatActivity, navController)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.onBackPressedDispatcher?.addCallback {
            findNavController().popBackStack()
        }
    }

}