package com.magui.myapplication

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class PortfolioActivity : AppCompatActivity() {
    private lateinit var profileImage: ImageView
    private lateinit var nameText: TextView
    private lateinit var emailText: TextView
    private lateinit var phoneText: TextView
    private lateinit var interestsText: TextView
    private lateinit var projectsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portfolio)

        // Initialize views
        profileImage = findViewById(R.id.profileImage)
        nameText = findViewById(R.id.nameText)
        emailText = findViewById(R.id.emailText)
        phoneText = findViewById(R.id.phoneText)
        interestsText = findViewById(R.id.interestsText)
        projectsRecyclerView = findViewById(R.id.projectsRecyclerView)

        // Set up profile information
        nameText.text = "Tu Nombre"
        emailText.text = "tu@email.com"
        phoneText.text = "+1234567890"
        interestsText.text = "• Desarrollo de Software\n• Diseño UI/UX\n• Inteligencia Artificial\n• Desarrollo Móvil"

        // Set up projects RecyclerView
        projectsRecyclerView.layoutManager = LinearLayoutManager(this)
        val projects = listOf(
            Project(
                "Proyecto 1",
                "Descripción del proyecto 1",
                "Kotlin, Android, Firebase"
            ),
            Project(
                "Proyecto 2",
                "Descripción del proyecto 2",
                "Java, Spring Boot, MySQL"
            ),
            Project(
                "Proyecto 3",
                "Descripción del proyecto 3",
                "React, Node.js, MongoDB"
            )
        )
        projectsRecyclerView.adapter = ProjectAdapter(projects)
    }
} 