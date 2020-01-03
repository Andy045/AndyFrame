package com.andy.frame.base

import android.view.View
import androidx.annotation.IdRes
import com.andy.basic.base.BaseActivity
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.R
import com.andy.titlebar.Titlebar
import com.andy.titlebar.entity.Action

/**
 * @title: FrameActivity
 * @projectName HandyFrame
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2019-12-30 17:20
 */
open class FrameActivity<P : BasePresenter> : BaseActivity<P>() {

    fun initTitlebar(
        @IdRes resId: Int,
        mainTitle: String = "",
        subTitle: String = "",
        orientation: Titlebar.Orientation = Titlebar.Orientation.VERTICAL
    ) {
        val titlebar = findViewById<Titlebar>(resId)
        if (titlebar != null && titlebar is Titlebar) {
            initTitlebar(titlebar, mainTitle, subTitle, orientation)
        }
    }

    fun initTitlebar(
        titlebar: Titlebar,
        mainTitle: String = "",
        subTitle: String = "",
        orientation: Titlebar.Orientation = Titlebar.Orientation.VERTICAL
    ) {
        titlebar.visibility = View.VISIBLE
        titlebar.setTitleText(mainTitle, subTitle)
        titlebar.setContentLayoutOrientation(orientation)
        titlebar.addLeftAction(object : Action() {
            init {
                this.setImageSrc(
                    R.drawable.hd_icon_titlebar_back,
                    R.color.web_white,
                    R.color.google_grey300
                )
            }

            override fun onClick() {
                finish()
            }
        })
    }

}