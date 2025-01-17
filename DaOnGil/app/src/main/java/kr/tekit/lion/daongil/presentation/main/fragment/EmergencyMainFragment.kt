package kr.tekit.lion.daongil.presentation.main.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import kr.tekit.lion.daongil.R
import kr.tekit.lion.daongil.databinding.FragmentEmergencyMainBinding
import kr.tekit.lion.daongil.presentation.emergency.EmergencyMapActivity
import kr.tekit.lion.daongil.presentation.emergency.PharmacyMapActivity

class EmergencyMainFragment : Fragment(R.layout.fragment_emergency_main) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val binding = FragmentEmergencyMainBinding.bind(view)

        binding.emrAedCard.setOnClickListener {
            val intent = Intent(requireActivity(), EmergencyMapActivity::class.java)
            startActivity(intent)
        }

        binding.pharmacyCard.setOnClickListener {
            val intent = Intent(requireActivity(), PharmacyMapActivity::class.java)
            startActivity(intent)
        }
    }
}