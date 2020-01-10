package com.andy.frame.module.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.annotation.LayoutRes
import androidx.drawerlayout.widget.DrawerLayout
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.R
import com.andy.frame.base.FrameActivity
import com.andy.titlebar.Titlebar
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
    fun setCenterFrameLayout(view: View) {
        frameLayoutCenter.addView(view)
    }

    //==================================================
    // DrawerLeft
    //==================================================
    fun openDrawerLeft() {
        drawerLayout.openDrawer(drawerLeft)
    }

    fun closeDrawerLeft() {
        drawerLayout.closeDrawer(drawerLeft)
    }

    fun setFrameLayoutLeftView(@LayoutRes viewId: Int) {
        val view =
            LayoutInflater.from(mContext).inflate(viewId, null)
        if (view != null) {
            setFrameLayoutLeftView(view)
        }
    }

    fun setFrameLayoutLeftView(view: View) {
        mDrawerLeft = view
        drawerLeft.visibility = View.VISIBLE
        frameLayoutLeft.addView(view)
    }

    fun removeFrameLayoutLeftView() {
        mDrawerLeft = null
        drawerLeft.visibility = View.GONE
        frameLayoutLeft.removeAllViews()
    }

    //==================================================
    // DrawerRight
    //==================================================
    fun openDrawerRight() {
        drawerLayout.openDrawer(drawerRight)
    }

    fun closeDrawerRight() {
        drawerLayout.closeDrawer(drawerRight)
    }

    fun setFrameLayoutRightView(@LayoutRes viewId: Int) {
        val view =
            LayoutInflater.from(mContext).inflate(viewId, null)
        if (view != null) {
            setFrameLayoutRightView(view)
        }
    }

    fun setFrameLayoutRightView(view: View) {
        mDrawerRight = view
        drawerRight.visibility = View.VISIBLE
        frameLayoutRight.addView(view)
    }

    fun removeFrameLayoutRightView() {
        mDrawerRight = null
        drawerRight.visibility = View.GONE
        frameLayoutRight.removeAllViews()
    }

    //==================================================
    // OtherWidgets
    //==================================================
    fun getTitlebar(): Titlebar {
        return titlebar
    }

    fun getDrawerLayout(): DrawerLayout {
        return drawerLayout
    }

    fun getFrameLayoutCenter(): FrameLayout {
        return frameLayoutCenter
    }

    fun getDrawerLeft(): RelativeLayout {
        return drawerLeft
    }

    fun getDrawerRight(): RelativeLayout {
        return drawerRight
    }

    fun getFrameLayoutLeft(): FrameLayout {
        return frameLayoutLeft
    }

    fun getFrameLayoutRight(): FrameLayout {
        return frameLayoutRight
    }
}