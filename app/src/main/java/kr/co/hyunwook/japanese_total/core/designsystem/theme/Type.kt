package kr.co.hyunwook.japanese_total.core.designsystem.theme

import kr.co.hyunwook.japanese_total.R
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp



val notosansBold = FontFamily(Font(R.font.notosans_bold, FontWeight.Bold))
val notosansLight = FontFamily(Font(R.font.notosans_light, FontWeight.Light))
val notosansMedium = FontFamily(Font(R.font.notosans_medium, FontWeight.Medium))
val notosansRegular = FontFamily(Font(R.font.notosans_regular, FontWeight.Normal))


@Stable
class JapaneseTotalTypography internal constructor(
    bold: TextStyle,
    light: TextStyle,
    medium: TextStyle,
    regular: TextStyle

) {
    var bold: TextStyle by mutableStateOf(bold)
        private set

    var light: TextStyle by mutableStateOf(bold)
        private set

    var medium: TextStyle by mutableStateOf(bold)
        private set

    var regular: TextStyle by mutableStateOf(bold)
        private set

    fun copy(
        bold: TextStyle = this.bold,
        light: TextStyle = this.light,
        medium: TextStyle = this.medium,
        regular: TextStyle = this.regular
    ): JapaneseTotalTypography = JapaneseTotalTypography(bold, light, medium, regular)

    fun update(other: JapaneseTotalTypography) {
        bold = other.bold
        light = other.light
        medium = other.medium
        regular = other.regular
    }
}

    fun japaneseTotalTextStyle(
        fontFamily: FontFamily,
        fontWeight: FontWeight,
        fontSize: TextUnit,
        lineHeight: TextUnit,
    ): TextStyle = TextStyle(
        fontFamily = fontFamily,
        fontWeight = fontWeight,
        fontSize = fontSize,
        lineHeight = lineHeight,
        lineHeightStyle = LineHeightStyle(
            alignment = LineHeightStyle.Alignment.Center,
            trim = LineHeightStyle.Trim.None
        )
    )


    @Composable
    fun japaneseTotalTypography(): JapaneseTotalTypography {
        return JapaneseTotalTypography(
            bold = japaneseTotalTextStyle(
                fontFamily = notosansBold,
                fontWeight = FontWeight.Bold,
                fontSize = 21.sp,
                lineHeight = 30.sp
            ),
            light = japaneseTotalTextStyle(
                fontFamily = notosansLight,
                fontWeight = FontWeight.Light,
                fontSize = 17.sp,
                lineHeight = 25.sp
            ),
            medium = japaneseTotalTextStyle(
                fontFamily = notosansMedium,
                fontWeight = FontWeight.Medium,
                fontSize = 17.sp,
                lineHeight = 25.sp,
            ),
            regular = japaneseTotalTextStyle(
                fontFamily = notosansRegular,
                fontWeight = FontWeight.Normal,
                fontSize = 17.sp,
                lineHeight = 25.sp

            )
        )
    }
