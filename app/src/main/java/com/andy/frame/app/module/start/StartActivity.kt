package com.andy.frame.app.module.start

import android.content.Intent
import com.andy.frame.app.R
import com.andy.frame.app.module.main.MainActivity
import com.andy.frame.module.start.StartActivity

/**
 * @title: StartActivity
 * @projectName HandyFrame
 * @description: 欢迎界面
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-08 17:31
 */
class StartActivity : StartActivity() {

    override fun setBackgroundImage(): Int? {
        return R.drawable.hd_img_start_bg
    }

    override fun setIntentTargetActivity(): Intent? {
        return Intent(this, MainActivity::class.java)
    }
}