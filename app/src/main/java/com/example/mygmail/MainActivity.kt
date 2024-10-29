package com.example.mygmail

import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.mygmail.ui.theme.MyGmailTheme

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // Lớp dữ liệu cho Email
    data class Email(
        val sender: String,
        val message: String,
        val time: String,
        val initial: Char
    )

    // Adapter cho RecyclerView
    class EmailAdapter(private val emailList: List<Email>) :
        RecyclerView.Adapter<EmailAdapter.EmailViewHolder>() {

        // ViewHolder cho từng item của RecyclerView
        class EmailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val senderTextView: TextView = itemView.findViewById(R.id.senderTextView)
            val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
            val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
            val initialTextView: TextView = itemView.findViewById(R.id.initialTextView)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmailViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.item_email, parent, false)
            return EmailViewHolder(view)
        }

        override fun onBindViewHolder(holder: EmailViewHolder, position: Int) {
            val email = emailList[position]
            holder.senderTextView.text = email.sender
            holder.messageTextView.text = email.message
            holder.timeTextView.text = email.time
            holder.initialTextView.text = email.initial.toString()
        }

        override fun getItemCount() = emailList.size
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Dữ liệu mẫu cho danh sách email
        val emailList = listOf(
            Email("Hungngtran04@gmail.com", "Learn Web Designing", "12:34 PM", 'H'),
            Email("Sun Asterisk", "Submitting Internship", "11:22 AM", 'S'),
            Email("HR Kiaisoft", "Offer for submission", "11:04 AM", 'K'),
            Email("X Support", "New services", "10:26 AM", 'X'),
            Email("Gau", "Add some new tasks here", "9:11 AM", 'G')
        )

        // Thiết lập RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EmailAdapter(emailList)
    }
}
