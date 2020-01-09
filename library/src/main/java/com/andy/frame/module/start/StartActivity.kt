package com.andy.frame.module.start

import android.content.DialogInterface
import android.content.Intent
import android.net.Uri
import android.os.Bundle
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

    val permissionsRequestCode = 100

    var isFinishCurrent: Boolean = true

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

        val intent = setIntentTargetActivity()
        if (intent != null) {
            startActivity(intent)
            if (isFinishCurrent) {
                finish()
            }
        }
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