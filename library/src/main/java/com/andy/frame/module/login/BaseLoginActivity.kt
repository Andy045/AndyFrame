package com.andy.frame.module.login

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.LayoutRes
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.R
import com.andy.frame.base.FrameActivity
import com.andy.titlebar.Titlebar
import com.google.android.material.button.MaterialButton
import com.google.android.material.checkbox.MaterialCheckBox
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

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
    lateinit var tvHintAccount: TextView
    lateinit var tilLayoutAccount: TextInputLayout
    lateinit var tieAccount: TextInputEditText
    lateinit var tvHintPassword: TextView
    lateinit var tilPassword: TextInputLayout
    lateinit var tiePassword: TextInputEditText
    lateinit var chkRemember: MaterialCheckBox
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
        tvHintAccount = findViewById(R.id.tvHintAccount)
        tilLayoutAccount = findViewById(R.id.tilLayoutAccount)
        tieAccount = findViewById(R.id.tieAccount)
        tvHintPassword = findViewById(R.id.tvHintPassword)
        tilPassword = findViewById(R.id.tilPassword)
        tiePassword = findViewById(R.id.tiePassword)
        chkRemember = findViewById(R.id.chkRemember)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener {
            onLogin(tieAccount.text.toString(), tiePassword.text.toString(), chkRemember.isChecked)
        }
    }

    open fun setLogo(@DrawableRes res: Int) {
        setLogo(resources.getDrawable(res, null))
    }

    open fun setLogo(res: Drawable) {
        ivLogo.setImageDrawable(res)
    }

    abstract fun onLogin(account: String, password: String, isRemember: Boolean)
}