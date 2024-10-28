package uz.turgunboyevjurabek.ktorexample.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyPostModel

@Composable
fun PostsList(modifier: Modifier = Modifier,posts: List<MyPostModel>?) {
    LazyColumn(
        modifier = modifier
            .background(color = Color.Cyan)
            .fillMaxWidth()
    ) {
        items(posts?.size ?: 0) {
            Spacer(modifier = modifier.height(10.dp))
            Surface(
                onClick = { /*TODO*/ },
                shadowElevation = 3.dp,
                tonalElevation = 1.dp,
                shape = Shapes().small,
                modifier = modifier
                    .padding(5.dp)
            ) {
                Column {
                    Text(
                        text = posts?.get(it)?.id.toString(),
                        fontSize = 20.sp,
                        modifier = modifier.padding(start = 10.dp)
                    )
                    Text(
                        text = posts?.get(it)?.title.toString(),
                        fontSize = 22.sp,
                        modifier = modifier.padding(start = 10.dp),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        softWrap = true,
                        fontWeight = FontWeight.Black,

                    )
                    HorizontalDivider()
                    Text(
                        text = posts?.get(it)?.body.toString(),
                        fontSize = 18.sp,
                        modifier = modifier.padding(start = 10.dp),
                        fontWeight = FontWeight.ExtraLight,
                        softWrap = true
                    )
                }
            }
            Spacer(modifier = modifier.height(20.dp))
        }
    }

}