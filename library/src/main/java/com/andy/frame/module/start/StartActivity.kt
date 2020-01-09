package com.andy.frame.module.start

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.provider.Settings
import androidx.annotation.DrawableRes
import com.andy.basic.mvp.BasePresenter
import com.andy.frame.R
import com.andy.frame.base.FrameActivity
import com.andy.frame.util.MaterialDialogUtil
import kotlinx.android.synthetic.main.hd_activity_start.*

/**
 * @title: StartActivity
 * @projectName HandyFrame
 * @description: TODO
 * @author LiuJie https://github.com/Handy045
 * @date Created in 2020-01-08 17:20
 */
abstract class StartActivity : FrameActivity<BasePresenter>() {

    init {
        this.isCheckPermissions = true
    }

    private val permissionsRequestCode = 100

    /**
     * 跳转倒计时，默认1秒后执行跳转
     */
    var countTime = 1
    private val mHandler: Handler = Handler()
    private val countRunnable = object : Runnable {
        override fun run() {
            if (countTime > 0) {
                mHandler.postDelayed(this, 1000)
            } else if (countTime == 0) {
                mHandler.removeCallbacks(this)

                val intent = setIntentTargetActivity()
                if (intent != null) {
                    startActivity(intent)
                    finish()
                }
            }
            countTime--
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.hd_activity_start)

        val resId = setBackgroundImage()
        if (resId != null) {
            image.setImageResource(resId)
        }
    }

    override fun onPermissionSuccessHD() {
        super.onPermissionSuccessHD()

        mHandler.postDelayed(countRunnable, 0)
    }

    override fun onPermissionRejectionHD(permissions: Array<String>) {
        super.onPermissionRejectionHD(permissions)

        MaterialDialogUtil.instance.showNormal(
            "权限校验",
            "发现已禁用权限，请手动授予",
            "设置",
            DialogInterface.OnClickListener { _, _ ->
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                intent.data = Uri.parse("package:$packageName")
                startActivityForResult(intent, permissionsRequestCode)
            },
            "取消",
            DialogInterface.OnClickListener { _, _ -> finish() }
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == permissionsRequestCode) {
            checkPermissionsHD()
        }
    }

    @DrawableRes
    abstract fun setBackgroundImage(): Int?

    abstract fun setIntentTargetActivity(): Intent?
}