package platzi.gnarbaiz.testapp.domain.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class CharacterEntity(
    val id: String,
    val name: String,

    @SerializedName("alternate_names")
    val alternateNames: List<String>,

    val species: String,
    val gender: String,
    val house: String,
    val dateOfBirth: String?,
    val yearOfBirth: Long,
    val wizard: Boolean,
    val ancestry: String,
    val eyeColour: String,
    val hairColour: String,
    val wand: WandEntity,
    val patronus: String,
    val hogwartsStudent: Boolean,
    val hogwartsStaff: Boolean,
    val actor: String,

    @SerializedName("alternate_actors")
    val alternateActors: List<String>,

    val alive: Boolean,
    val image: String
) : Parcelable
