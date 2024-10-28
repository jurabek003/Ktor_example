package uz.turgunboyevjurabek.ktorexample.presentation.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.turgunboyevjurabek.ktorexample.domain.madels.MyModelItem

@Composable
fun MyTextLists(modifier: Modifier = Modifier, posts: List<MyModelItem>?) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    ) {
        items(posts?.size ?: 0) {
            Spacer(modifier = modifier.height(10.dp))
            Text(
                text = posts?.get(it)?.title.toString(),
                fontSize = 20.sp,
                modifier = modifier.padding(start = 10.dp)
            )
            Spacer(modifier = modifier.height(20.dp))
        }
    }

}