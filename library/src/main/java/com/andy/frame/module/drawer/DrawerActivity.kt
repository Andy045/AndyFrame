package com.andy.frame.module.drawer

import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import androidx.drawerlayout.widget.DrawerLayout
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.R
import com.andy.frame.base.FrameActivity
import kotlinx.android.synthetic.main.hd_activity_drawer.*

/**
 * @title: DrawerActivity
 * @projectName HandyFrame
 * @description: 抽屉界面
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-10 08:50
 */
open class DrawerActivity<P : BasePresenter> : FrameActivity<P>() {

    var mDrawerLeft: View? = null
    var mDrawerRight: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.hd_activity_drawer)

        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, drawerLeft)
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, drawerRight)
    }

    //==================================================
    // Content
    //==================================================
    fun getFrameLayoutCenter(): FrameLayout {
        return frameLayoutCenter
    }

    fun setCenterFrameLayout(view: View) {
        frameLayoutCenter.addView(view)
    }

    //==================================================
    // DrawerLeft
    //==================================================
    fun openDrawerLeft() {
        if (drawerLeft != null) {
            drawerLayout.openDrawer(drawerLeft!!)
        }
    }

    fun closeDrawerLeft() {
        if (drawerLeft != null) {
            drawerLayout.closeDrawer(drawerLeft!!)
        }
    }

    fun setFrameLayoutLeftView(view: View) {
        mDrawerLeft = view
        drawerLeft.visibility = View.VISIBLE
        frameLayoutLeft.addView(view)
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, drawerLeft)
    }

    fun removeFrameLayoutLeftView() {
        mDrawerLeft = null
        drawerLeft.visibility = View.GONE
        frameLayoutLeft.removeAllViews()
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, drawerLeft)
    }

    //==================================================
    // DrawerRight
    //==================================================
    fun openDrawerRight() {
        if (drawerRight != null) {
            drawerLayout.openDrawer(drawerRight!!)
        }
    }

    fun closeDrawerRight() {
        if (drawerRight != null) {
            drawerLayout.closeDrawer(drawerRight!!)
        }
    }

    fun setFrameLayoutRightView(view: View) {
        mDrawerRight = view
        drawerRight.visibility = View.VISIBLE
        frameLayoutRight.addView(view)
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, drawerRight)
    }

    fun removeFrameLayoutRightView() {
        mDrawerRight = null
        drawerRight.visibility = View.GONE
        frameLayoutRight.removeAllViews()
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, drawerRight)
    }
}