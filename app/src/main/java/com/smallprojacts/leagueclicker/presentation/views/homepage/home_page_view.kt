import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.smallprojacts.leagueclicker.data.api.HomeApi
import com.smallprojacts.leagueclicker.data.api.SearchImpl
import com.smallprojacts.leagueclicker.domain.models.AllChamp
import com.smallprojacts.leagueclicker.domain.models.Region
import com.smallprojacts.leagueclicker.presentation.components.ChampionGrid
import com.smallprojacts.leagueclicker.presentation.components.RandomChampSpotLight
import com.smallprojacts.leagueclicker.presentation.components.SpotlightCard
import kotlinx.coroutines.launch

@Composable
fun HomePage(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    innerPadding: PaddingValues
) {
    // Define state for the list of champions
    var champs by remember { mutableStateOf<List<AllChamp>>(emptyList()) }

    val coroutineScope = rememberCoroutineScope()

    // Fetch champions when the composable is first launched
    LaunchedEffect(Unit) {
        coroutineScope.launch {
            // Fetch the list of champions and update the state
            champs = HomeApi().getChamps()
            Log.d("Champs", champs.toString())
        }
    }

    // The UI part
    ChampionGrid(
        modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 20.dp),
        champs = champs,  // Pass the fetched list of champions
        header = {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Spotlight",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            SpotlightCard(champs = champs)

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Recent Champion",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            RandomChampSpotLight(modifier = Modifier , champs = champs)

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Popular Champions",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(15.dp))
        }
    )
}
