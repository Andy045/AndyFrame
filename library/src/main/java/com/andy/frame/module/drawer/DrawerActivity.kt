package com.andy.frame.module.drawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.RelativeLayout
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.drawerlayout.widget.DrawerLayout
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.R
import com.andy.frame.base.FrameActivity
import com.andy.titlebar.Titlebar
import com.andy.titlebar.entity.Action
import kotlinx.android.synthetic.main.hd_activity_drawer.*

/**
 * @title: DrawerActivity
 * @projectName HandyFrame
 * @description: 抽屉界面
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-10 08:50
 */
open class DrawerActivity<P : BasePresenter> : FrameActivity<P>() {

    @LayoutRes
    fun setRootLayoutRes(): Int {
        return R.layout.hd_activity_drawer
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setRootLayoutRes())

        titlebar.addLeftAction(object : Action() {
            init {
                this.setImageSrc(
                    R.drawable.hd_icon_titlebar_menu,
                    R.color.hd_titlebar_normal,
                    R.color.hd_titlebar_press
                )
            }

            override fun onClick() {
                openDrawerLeft()
            }
        })

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

    fun addDrawerLeftView(@LayoutRes viewId: Int) {
        val view =
            LayoutInflater.from(mContext).inflate(viewId, null)
        if (view != null) {
            addDrawerLeftView(view)
        }
    }

    fun addDrawerLeftView(view: View) {
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        drawerLeft.addView(view)
    }

    fun removeDrawerLeftView() {
        drawerLeft.removeAllViews()
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

    fun addDrawerRightView(@LayoutRes viewId: Int) {
        val view =
            LayoutInflater.from(mContext).inflate(viewId, null)
        if (view != null) {
            addDrawerRightView(view)
        }
    }

    fun addDrawerRightView(view: View) {
        view.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT
        )
        drawerRight.addView(view)
    }

    fun removeDrawerRightView() {
        drawerRight.removeAllViews()
    }

    //==================================================
    // OtherWidgets
    //==================================================
    /**
     * 设置侧边栏展开时的背景颜色（默认：0x99000000）
     */
    fun setDrawerScrimColor(@ColorInt color: Int) {
        drawerLayout.setScrimColor(color)
    }

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
}