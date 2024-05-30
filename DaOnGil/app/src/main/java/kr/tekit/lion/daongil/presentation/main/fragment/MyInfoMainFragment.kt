package kr.tekit.lion.daongil.presentation.main.fragment

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import kr.tekit.lion.daongil.R
import kr.tekit.lion.daongil.databinding.FragmentMyInfoMainBinding
import kr.tekit.lion.daongil.presentation.main.ConfirmDialog
import kr.tekit.lion.daongil.presentation.main.ConfirmDialogInterface

class MyInfoMainFragment : Fragment(R.layout.fragment_my_info_main), ConfirmDialogInterface {

    private var originalStatusBarColor: Int? = null
    private lateinit var binding: FragmentMyInfoMainBinding
    private var isUser = true

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMyInfoMainBinding.bind(view)

        changeStatusBarColor()
        initView()
        logoutDialog()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        restoreStatusBarColor()
    }

    fun initView() {
        if(isUser) {
            with(binding) {
                textViewMyInfoUserNickname.text = "김사자"
            }
        } else {
            with(binding) {
                textViewMyInfoUserNickname.text = "아직 정보가 없어요!"
                textViewMyInfoUserTitle.isVisible = false
                textViewMyInfoReview.text = "로그인을 진행해주세요"
                textViewMyInfoReviewCnt.isVisible = false
            }
        }
    }

    fun changeStatusBarColor() {
        activity?.let {
            originalStatusBarColor = it.window.statusBarColor

            it.window.statusBarColor = ContextCompat.getColor(requireContext(), R.color.profile_background_endColor)
        }
    }

    fun restoreStatusBarColor() {
        activity?.let {
            originalStatusBarColor?.let { color ->
                it.window.statusBarColor = color
            }
        }
    }

    private fun logoutDialog() {
        // 삭제 버튼 클릭
        binding.layoutLogout.setOnClickListener {
            val dialog = ConfirmDialog(this, "로그아웃", "해당 기기에서 로그아웃 됩니다.", "로그아웃")
            // 알림창이 띄워져있는 동안 배경 클릭 막기
            dialog.isCancelable = false
            dialog.show(activity?.supportFragmentManager!!, "MyPageDialog")
        }
    }

    override fun onYesButtonClick() {
        logout()
    }

    private fun logout() {
        Snackbar.make(requireView(), "로그아웃", Snackbar.LENGTH_SHORT).show()
    }
}