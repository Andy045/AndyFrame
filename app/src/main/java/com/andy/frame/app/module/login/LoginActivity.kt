package com.andy.frame.app.module.login

import android.os.Bundle
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.app.R
import com.andy.frame.module.login.BaseLoginActivity

/**
 * @title: LoginActivity
 * @projectName HandyFrame
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-15 14:08
 */
class LoginActivity : BaseLoginActivity<BasePresenter>() {
    override fun initViewHD(savedInstanceState: Bundle?) {
        super.initViewHD(savedInstanceState)
        setLogo(R.mipmap.ic_launcher)
    }

    override fun onLogin(account: String, password: String, isRemember: Boolean) {

    }
}