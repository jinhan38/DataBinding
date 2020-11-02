package com.databinding

data class UserProfile(
    var name: String = "",
    var phone: String = "",
    var address: String = "",
    var gender: Int = 0,
    var profileImage: String = "",
) {
    companion object {
        const val GENDER_MALE = 0
        const val GENDER_FEMALE = 1
    }

    fun getGenderAsText(): String {

        return if (gender == GENDER_MALE) "남성" else "여성"


//        return when (gender) {
//            0 -> "남성"
//            else -> "여성"
//        }

    }
}