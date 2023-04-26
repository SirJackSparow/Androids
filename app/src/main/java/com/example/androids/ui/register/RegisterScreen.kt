package com.example.androids.ui.register

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
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androids.ui.login.LoginScreen
import com.example.androids.ui.theme.Blue01
import com.example.androids.ui.theme.BlueDark01
import com.example.androids.ui.theme.lightBlue
import com.example.androids.utils.Screen

@Composable
fun RegisterScreen(nav: NavController) {
    var userName by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
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
                text = "Welcome to Quantum Wallet!",
                modifier = Modifier.padding(start = 20.dp),
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 25.sp
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Please register in our application to",
                modifier = Modifier.padding(start = 20.dp),
                color = Color.Gray,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )

            Text(
                text = "continue work with your wallet",
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
                        value = userName,
                        onValueChange = {
                            userName = it
                        },
                        label = { Text(text = "User name", color = Color.Gray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                            .alpha(0.5f),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Blue01,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                    )
                    TextField(
                        value = email,
                        onValueChange = {
                            email = it
                        },
                        label = { Text(text = "E-mail", color = Color.Gray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                            .alpha(0.5f),
                        shape = RoundedCornerShape(8.dp),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Blue01,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                    )
                    TextField(
                        value = phoneNumber,
                        onValueChange = {
                            phoneNumber = it
                        },
                        label = { Text(text = "Phone Number", color = Color.Gray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, start = 20.dp, end = 20.dp)
                            .alpha(0.5f),
                        shape = RoundedCornerShape(8.dp),
                        trailingIcon = {
                            Icon(Icons.Filled.Add, "Add", tint = Color.Blue)
                        },
                        leadingIcon = { Text(text = "+10", color = Color.Gray) },
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Blue01,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                    )
                    Button(
                        onClick = { },
                        shape = RoundedCornerShape(20), // = 50% percent
                        colors = ButtonDefaults.buttonColors(lightBlue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 25.dp, horizontal = 20.dp),
                    ) {
                        Text(
                            text = "Get Started",
                            modifier = Modifier.padding(vertical = 15.dp),
                            fontSize = 20.sp
                        )
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable(onClick = {
                                nav.navigate(Screen.Login.route)
                            }),
                        horizontalArrangement = Arrangement.Center,

                        ) {
                        Text(text = "Already have an account?", color = Color.Gray)
                        Text(text = "LogIn", color = lightBlue)
                    }

                    Spacer(modifier = Modifier.height(120.dp))
                }
            }
        }
    }
}

@Preview
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(nav = rememberNavController())
}
