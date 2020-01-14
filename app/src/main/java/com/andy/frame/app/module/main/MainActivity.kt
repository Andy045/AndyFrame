package com.andy.frame.app.module.main

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.app.R
import com.andy.frame.module.drawer.DrawerActivity
import kotlinx.android.synthetic.main.hd_include_main_drawer_left.*

/**
 * @title: StartActivity
 * @projectName HandyFrame
 * @description: 首页界面
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-08 17:31
 */
class MainActivity : DrawerActivity<BasePresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getTitlebar().setTitleText("首页")
    }

    override fun initViewHD(savedInstanceState: Bundle?) {
        super.initViewHD(savedInstanceState)

        addDrawerLeftView(R.layout.hd_include_main_drawer_left)

        tvGithub.setOnClickListener {
            val uri = Uri.parse("https://github.com/Andy045")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
        tvWebSite.setOnClickListener {
            val uri = Uri.parse("https://handy045.com")
            val intent = Intent(Intent.ACTION_VIEW, uri)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
        }
        tvSetting.setOnClickListener { }
        tvExitApp.setOnClickListener { finish() }
        ivClose.setOnClickListener { getDrawerLayout().closeDrawer(getDrawerLeft()) }
    }
}
