package kr.co.bullets.tmdbclientreview.data.model.artist


import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

// if we keep this in this way, room data base table name will be same as the data class name
// table name will be artist
// but if we want a different name, we can give it as the value of the table name property
@Entity(tableName = "popular_artists")
data class Artist(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,
//    @ColumnInfo(name = "artist_name")
    @SerializedName("name")
    val name: String?,
    @SerializedName("popularity")
    val popularity: Double?,
    @SerializedName("profile_path")
    val profilePath: String?
)