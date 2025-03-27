package com.magui.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
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
    private lateinit var logoutButton: Button

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
        logoutButton = findViewById(R.id.logoutButton)

        // Set up profile information
        nameText.text = "Magali Gallardo"
        emailText.text = "gallardomagui19@gmail.com"
        phoneText.text = "3764657089"
        interestsText.text = "• Desarrollo de Software\n• Diseño UI/UX\n• Inteligencia Artificial\n• Desarrollo Móvil"

        // Set up projects RecyclerView
        projectsRecyclerView.layoutManager = LinearLayoutManager(this)
        val projects = listOf(
            Project(
                "Agenda de eventos municipal",
                "Una página web en donde los usuarios pueden visualizar los eventos pudiendo hacer la búsqueda según el tipo de evento (artístico, deportivo, educativo, etc), según la fecha o el lugar dentro de la ciudad de Posadas.",
                "WordPress, React, Firebase"
            ),
            Project(
                "Sistema de Gestión de Alumnos",
                "Un sistema en donde los alumnos pueden ser inscriptos a diferentes materias con un CRUD tanto para alumnos como para materias",
                "PHP, SQL, Bootstrap"
            ),
            Project(
                "Agenda personal",
                "Un sistema para anotar tareas con checklist",
                "Java"
            )
        )
        projectsRecyclerView.adapter = ProjectAdapter(projects)

        // Set up logout button
        logoutButton.setOnClickListener {
            // Navigate back to login screen
            val intent = Intent(this, LoginActivity::class.java)
            // Clear activity stack so user can't go back
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
} 