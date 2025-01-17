package kr.tekit.lion.daongil.presentation.myinfo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kakao.sdk.user.UserApiClient
import kr.tekit.lion.daongil.databinding.ActivityDeleteUserBinding
import kr.tekit.lion.daongil.presentation.login.LoginActivity

class DeleteUserActivity : AppCompatActivity() {
    private val binding: ActivityDeleteUserBinding by lazy {
        ActivityDeleteUserBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding) {
            toolbar.setNavigationOnClickListener {
                finish()
            }

            btnDelete.setOnClickListener {
                val permissionDialog = ConfirmDialog(
                    "회원 탈퇴",
                    "정말 회원을 탈퇴 하시겠습니까?",
                    "탈퇴 하기"
                ) {
                    UserApiClient.instance.unlink {

                    }
                    startActivity(Intent(this@DeleteUserActivity, LoginActivity::class.java))
                    finish()
                }
                permissionDialog.isCancelable = false
                permissionDialog.show(supportFragmentManager, "PermissionDialog")
            }
        }
    }
}