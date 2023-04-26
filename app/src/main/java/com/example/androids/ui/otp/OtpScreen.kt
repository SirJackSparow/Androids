package com.example.androids.ui.otp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.androids.ui.theme.BlueDark01
import com.example.androids.ui.theme.lightBlue


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OtpScreen(navController: NavHostController,number: String?) {
    val (item1, item2, item3, item4, item5, item6) = FocusRequester.createRefs()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueDark01)
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Icon(
                Icons.Filled.ArrowBack,
                "Back",
                tint = Color.Gray,
                modifier = Modifier
                    .padding(start = 20.dp, top = 20.dp)
                    .clickable {
                        navController.popBackStack()
                    }
                    .background(color = Color.White),
            )
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Phone Verification",
                modifier = Modifier.padding(start = 20.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "We sent verification number to",
                modifier = Modifier.padding(start = 20.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = "your number : $number",
                modifier = Modifier.padding(start = 20.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.height(50.dp))

            Row(
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                OtpChar(
                    modifier = Modifier
                        .focusRequester(item1)
                        .focusProperties {
                            next = item2
                            previous = item1
                        }
                )
                OtpChar(
                    modifier = Modifier
                        .focusRequester(item2)
                        .focusProperties {
                            next = item3
                            previous = item1
                        }
                )
                OtpChar(
                    modifier = Modifier
                        .focusRequester(item3)
                        .focusProperties {
                            next = item4
                            previous = item2
                        }
                )
                OtpChar(
                    modifier = Modifier
                        .focusRequester(item4)
                        .focusProperties {
                            previous = item3
                            next = item5
                        }
                )
                OtpChar(
                    modifier = Modifier
                        .focusRequester(item5)
                        .focusProperties {
                            previous = item4
                            next = item6
                        }
                )
                OtpChar(
                    modifier = Modifier
                        .focusRequester(item6)
                        .focusProperties {
                            previous = item5
                            next = item6
                        }
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .background(BlueDark01)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.background(Color.White)) {

                    Button(
                        onClick = {

                        },
                        shape = RoundedCornerShape(20),
                        colors = ButtonDefaults.buttonColors(lightBlue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 20.dp),
                    ) {
                        Text(
                            text = "Done",
                            modifier = Modifier.padding(vertical = 15.dp),
                            fontSize = 20.sp
                        )
                    }

                    OutlinedButton(
                        onClick = {},
                        shape = RoundedCornerShape(20),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 10.dp, horizontal = 20.dp),
                    ) {
                        Text(
                            text = "Resend Code",
                            modifier = Modifier.padding(vertical = 15.dp),
                            fontSize = 20.sp,
                            color = Color.Gray
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun OtpChar(
    modifier: Modifier = Modifier
) {
    val pattern = remember { Regex("^[^\\t]*\$") } //to not accept the tab key as value
    var (text, setText) = remember { mutableStateOf("") }
    val maxChar = 1
    val focusManager = LocalFocusManager.current

    LaunchedEffect(
        key1 = text,
    ) {
        if (text.isNotEmpty()) {
            focusManager.moveFocus(
                focusDirection = FocusDirection.Next,
            )
        }
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = {
                if (it.length <= maxChar &&
                    ((it.isEmpty() || it.matches(pattern)))
                )
                    setText(it)
            },
            modifier = modifier
                .width(50.dp)
                .onKeyEvent {
                    if (it.key == Key.Tab) {
                        focusManager.moveFocus(FocusDirection.Next)
                        true
                    }
                    if (text.isEmpty() && it.key == Key.Backspace) {
                        focusManager.moveFocus(FocusDirection.Previous)
                    }
                    false
                },
            textStyle = LocalTextStyle.current.copy(
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number
            ),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Transparent,
                unfocusedIndicatorColor = Transparent,
                focusedIndicatorColor = Transparent,
                textColor = Color.White
            ),

            )
        Divider(
            Modifier
                .width(28.dp)
                .padding(bottom = 2.dp)
                .offset(y = -10.dp),
            color = White,
            thickness = 1.dp
        )
    }
}