package kr.tekit.lion.daongil.presentation.myreview.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import kr.tekit.lion.daongil.R
import kr.tekit.lion.daongil.databinding.FragmentMyReviewDetailBinding
import kr.tekit.lion.daongil.presentation.myreview.adapter.MyReviewDetailVPAdapter
import kr.tekit.lion.daongil.presentation.myreview.customview.MyReviewDetailBottomSheet

class MyReviewDetailFragment : Fragment(R.layout.fragment_my_review_detail) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentMyReviewDetailBinding.bind(view)

        initView(binding)
        initReviewDetail(binding)
        settingVPAdapter(binding)
    }

    private fun initView(binding: FragmentMyReviewDetailBinding) {
        binding.toolbarMyReviewDetail.setNavigationIcon(R.drawable.back_icon)
        binding.toolbarMyReviewDetail.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_myReviewDetailFragment_to_myReviewFragment, null)
        }
        binding.toolbarMyReviewDetail.inflateMenu(R.menu.menu_my_review_detail)
        binding.toolbarMyReviewDetail.setOnMenuItemClickListener {
            showBottomSheet()
            true
        }
    }

    private fun initReviewDetail(binding: FragmentMyReviewDetailBinding) {
        val reviewDetail = mapOf(
            "location" to "망상해변",
            "rating" to 3.5,
            "date" to "2024.05.24 금",
            "review" to "풍경도 좋고 너무 좋아요!!!!\n시설도 잘 되어있어서 만족스러웠습니다"
        )

        val stars = listOf(
            binding.myReviewDetailRating1,
            binding.myReviewDetailRating2,
            binding.myReviewDetailRating3,
            binding.myReviewDetailRating4,
            binding.myReviewDetailRating5
        )

        binding.textViewMyReviewDetailLocation.text = reviewDetail["location"].toString()
        binding.textViewMyReviewDetailDate.text = "${reviewDetail["date"]} 방문"
        binding.textViewMyReviewDetailReviewContent.text = reviewDetail["review"].toString()
        settingRating(reviewDetail["rating"] as Double, stars)
    }

    private fun settingVPAdapter(binding: FragmentMyReviewDetailBinding) {
        val reviewImages = listOfNotNull(
            ContextCompat.getDrawable(requireContext(), R.drawable.img_2455),
            ContextCompat.getDrawable(requireContext(), R.drawable.img_2859),
            ContextCompat.getDrawable(requireContext(), R.drawable.img_8272)
        )

        val myReviewDetailVPAdapter = MyReviewDetailVPAdapter(reviewImages)
        binding.viewPagerMyReviewDetail.adapter = myReviewDetailVPAdapter
        binding.viewPagerMyReviewDetail.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.MyReviewDetailindicator.setViewPager(binding.viewPagerMyReviewDetail)
    }

    private fun settingRating(rating: Double, Ratings: List<ImageView>) {
        for (i in 0 until 5) {
            val imageView = Ratings[i]
            when {
                rating >= (i + 1) -> {
                    imageView.setImageResource(R.drawable.star_filled_icon)
                    imageView.setColorFilter(ContextCompat.getColor(imageView.context, R.color.primary))
                }
                rating >= (i + 0.5) -> {
                    imageView.setImageResource(R.drawable.star_half_filled_icon)
                    imageView.setColorFilter(ContextCompat.getColor(imageView.context, R.color.primary))
                }
                else -> {
                    imageView.setImageResource(R.drawable.star_icon)
                    imageView.setColorFilter(ContextCompat.getColor(imageView.context, R.color.primary_disabled))
                }
            }
        }
    }

    private fun showBottomSheet() {
        MyReviewDetailBottomSheet().show(parentFragmentManager, "myReviewDetailBottomSheet")
    }
}