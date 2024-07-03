package ir.ehsannarmani.compose_charts.models

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import ir.ehsannarmani.compose_charts.extensions.format

sealed class IndicatorProperties(
    open val enabled:Boolean,
    open val textStyle: TextStyle,
    open val count: Int,
    open val position: IndicatorPosition,
    open val contentBuilder: (Double) -> String
)


data class VerticalIndicatorProperties(
    override val enabled: Boolean = true,
    override val textStyle: TextStyle = TextStyle.Default.copy(fontSize = 12.sp),
    override val count: Int = 5,
    override val position: IndicatorPosition.Vertical = IndicatorPosition.Vertical.Bottom,
    override val contentBuilder: (Double) -> String = {
        it.format(1)
    }
) : IndicatorProperties(
    enabled = enabled,
    textStyle = textStyle,
    count = count,
    position = position,
    contentBuilder = contentBuilder
)

data class HorizontalIndicatorProperties(
    override val enabled: Boolean = true,
    override val textStyle: TextStyle = TextStyle.Default.copy(fontSize = 12.sp),
    override val count: Int = 5,
    override val position: IndicatorPosition.Horizontal = IndicatorPosition.Horizontal.Start,
    override val contentBuilder: (Double) -> String = {
        it.format(1)
    }
) : IndicatorProperties(
    enabled = enabled,
    textStyle = textStyle,
    count = count,
    position = position,
    contentBuilder = contentBuilder
)

sealed interface IndicatorPosition {
    enum class Vertical : IndicatorPosition {
        Top,
        Bottom
    }
    enum class Horizontal: IndicatorPosition {
        Start,
        End
    }
}