package com.example.androids.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androids.R
import com.example.androids.ui.theme.Blue01
import com.example.androids.ui.theme.BlueDark01
import com.example.androids.ui.theme.lightBlue
import com.example.androids.utils.Screen

@Composable
fun LoginScreen(nav: NavController) {
    var phoneNumber by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueDark01)
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Text(
                text = "Q",
                modifier = Modifier.padding(start = 20.dp, top = 20.dp),
                fontSize = 100.sp,
                color = Color.White,
                fontFamily = FontFamily.Cursive
            )
            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Welcome!",
                modifier = Modifier.padding(start = 20.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Please enter your phone",
                modifier = Modifier.padding(start = 20.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = "number to continue",
                modifier = Modifier.padding(start = 20.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Spacer(modifier = Modifier.weight(1f))

            Box(
                modifier = Modifier
                    .background(BlueDark01)
                    .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.background(Color.White)) {
                    TextField(
                        value = phoneNumber,
                        onValueChange = {
                            phoneNumber = it
                        },
                        label = { Text(text = "Phone Number", color = Gray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                            .alpha(0.5f),
                        shape = RoundedCornerShape(8.dp),
                        trailingIcon = {
                            Icon(Icons.Filled.Add, "Add", tint = Blue)
                        },
                        leadingIcon = { Text(text = "+10", color = Gray) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Blue01,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                    )
                    Button(
                        onClick = {  nav.navigate(Screen.Register.route) },
                        shape = RoundedCornerShape(20),
                        colors = ButtonDefaults.buttonColors(lightBlue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 25.dp, horizontal = 20.dp),
                    ) {
                        Text(
                            text = "Log In",
                            modifier = Modifier.padding(vertical = 15.dp),
                            fontSize = 20.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = {
                                nav.navigate(Screen.Register.route)
                            }),
                        horizontalArrangement = Arrangement.Center,

                        ) {
                        Text(text = "Still have no account?", color = Gray)
                        Text(text = "Register", color = lightBlue)
                    }

                    Spacer(modifier = Modifier.height(120.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen(nav = rememberNavController())
}
