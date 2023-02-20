package platzi.gnarbaiz.testapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WandEntity(
    val wood: String,
    val core: String,
    val length: Float
) : Parcelable
