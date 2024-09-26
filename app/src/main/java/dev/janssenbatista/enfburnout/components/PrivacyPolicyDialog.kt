package dev.janssenbatista.enfburnout.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import dev.janssenbatista.enfburnout.R

@Composable
fun PrivacyPolicyDialog(onDismissRequestClick: () -> Unit, onConfirmButtonClick: () -> Unit) {
    AlertDialog(
        title = { Text(text = stringResource(R.string.privacy_policy_title)) },
        text = {
            Text(text = stringResource(R.string.privacy_policy_text))
        },
        onDismissRequest = {}, dismissButton = {
            TextButton(onClick = onDismissRequestClick) {
                Text(text = "Não concordo")
            }
        },
        confirmButton = {
            TextButton(onClick = onConfirmButtonClick) {
                Text(text = "Concordo")
            }
        },
        properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
    )
}

@Preview
@Composable
fun PreviewPrivacyPolicyDialog() {
    PrivacyPolicyDialog({}, {})
}