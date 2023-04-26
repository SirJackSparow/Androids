package com.example.androids.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.androids.R
import com.example.androids.ui.theme.Blue01
import com.example.androids.ui.theme.BlueDark01
import com.example.androids.ui.theme.lightBlue

@Composable
fun LoginScreen(nav: NavHostController) {
    var phoneNumber by remember { mutableStateOf("") }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(BlueDark01)
    ) {
        Column(modifier = Modifier.fillMaxHeight()) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "Logo",
                modifier = Modifier.padding(start = 20.dp, top = 20.dp)
            )
            Spacer(modifier = Modifier.height(80.dp))

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
                        label = { Text(text = "Phone Number", color = DarkGray) },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 30.dp, start = 16.dp, end = 16.dp)
                            .alpha(0.2f),
                        shape = RoundedCornerShape(8.dp),
                        trailingIcon = {
                            Icon(Icons.Filled.Add, "", tint = Blue)
                        },
                        leadingIcon = { Text(text = "+10", color = DarkGray) },
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
                            text = "Log In",
                            modifier = Modifier.padding(vertical = 15.dp),
                            fontSize = 20.sp
                        )
                    }

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(text = "Still have no account?", color = Gray)
                        Text(text = "Register", color = Blue)
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
