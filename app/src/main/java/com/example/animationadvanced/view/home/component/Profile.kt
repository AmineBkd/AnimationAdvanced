package com.example.animationadvanced.view.home.component

import androidx.compose.animation.animateColor
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.TargetBasedAnimation
import androidx.compose.animation.core.TwoWayConverter
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.animateIntAsState
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.animationadvanced.R
import com.example.animationadvanced.model.home.User
import com.example.animationadvanced.view.theme.MetalicBackground
import com.example.animationadvanced.view.theme.MetalicGray
import com.example.animationadvanced.view.theme.MetalicGrayAlpha10
import com.example.animationadvanced.view.theme.MetalicGrayAlpha50
import com.example.animationadvanced.view.theme.Typography
import java.util.Date

@Composable
@Preview
fun Profile(
    user: User? = User(0, "Amine", "Boukaddous", "Mohamed Amine", Date()),
    isProfileFetching: Boolean = true
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (isProfileFetching) {
            true -> {
                AnimatedProfileSkeleton()
            }
            false -> {
                if (user == null) {
                    Text(
                        text = stringResource(R.string.welcome_user, "Guest"),
                        style = Typography.titleLarge
                    )
                } else {
                    Text(
                        text = stringResource(R.string.welcome_user, user.userName),
                        style = Typography.titleLarge
                    )
                }
            }
        }
    }
}

@Composable
@Preview
private fun AnimatedProfileSkeleton() {
    //Color Animation
    val infiniteTransitionColor = rememberInfiniteTransition(label = "animateShininess")
    val color by infiniteTransitionColor.animateColor(
        initialValue = MetalicGrayAlpha10,
        targetValue = MetalicGray,
        animationSpec = infiniteRepeatable(
            animation = tween(1000, easing = LinearOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "animateShininess"
    )

    //Alignement Animation
    val infiniteTransitionWidth = rememberInfiniteTransition(label = "animateWidth")
    val width by infiniteTransitionWidth.animateFloat(
        initialValue = 0f,
        targetValue = 200f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "animateWidth"
    )



    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(MetalicBackground, shape = RoundedCornerShape(20.dp))
                .padding(1.dp),
            contentAlignment = Alignment.TopEnd,
        ) {

            Box(
                modifier = Modifier
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                MetalicGrayAlpha10,
                                color,
                                MetalicGrayAlpha10,
                            )
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
                    .size(400.dp, 10.dp)
                    .offset(x=(width).dp, y= (0).dp)
            )
        }
    }
}