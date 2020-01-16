package com.andy.frame.module.login

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.R
import com.andy.frame.base.FrameActivity
import com.andy.titlebar.Titlebar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

/**
 * @title: LoginActivity
 * @projectName HandyFrame
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-14 16:50
 */
abstract class BaseLoginActivity<P : BasePresenter> : FrameActivity<P>() {

    lateinit var ivBackground: ImageView
    lateinit var titlebar: Titlebar
    lateinit var ivLogo: ImageView
    lateinit var edtAccount: TextInputEditText
    lateinit var edtPassword: TextInputEditText
    lateinit var btnLogin: MaterialButton

    @LayoutRes
    fun setRootLayoutRes(): Int {
        return R.layout.hd_activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setRootLayoutRes())

        ivBackground = findViewById(R.id.ivBackground)
        titlebar = findViewById(R.id.titlebar)
        ivLogo = findViewById(R.id.ivLogo)
        edtAccount = findViewById(R.id.edtAccount)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogin = findViewById(R.id.btnLogin)
    }

    open fun setLogo(@DrawableRes res: Int) {
        setLogo(resources.getDrawable(res, null))
    }

    open fun setLogo(res: Drawable) {
        ivLogo.setImageDrawable(res)
    }
}