import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.m68476521.comicos.R

@Composable
fun FormattedPriceLabel(
    subtotal: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = stringResource(R.string.home, subtotal),
        modifier = modifier,
        style = MaterialTheme.typography.headlineSmall,
    )
}
