package kr.tekit.lion.daongil.data.dto.remote.request

import android.graphics.BitmapFactory
import kr.tekit.lion.daongil.data.dto.remote.base.AdapterProvider
import kr.tekit.lion.daongil.domain.model.ProfileImg
import kr.tekit.lion.daongil.presentation.ext.compressBitmap
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

data class MyProfileImgRequest (
    val profileImage: ByteArray
)

fun ProfileImg.toMultiPartBody(): MultipartBody.Part {
    val file = File(this.path)
    val bitmap = BitmapFactory.decodeFile(file.path).compressBitmap(60)
    val requestFile = bitmap.toRequestBody("image/*".toMediaTypeOrNull())
    return MultipartBody.Part.createFormData("profileImage", file.name, requestFile)
}