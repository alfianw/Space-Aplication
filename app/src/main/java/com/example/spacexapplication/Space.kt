import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Space(
    val name: String?,
    val descriptor: String?,
    val photo:Int?,
    val averange: String?,
    val character: String?
): Parcelable