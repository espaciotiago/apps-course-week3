package tech.yeswecode.week3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var layoutManager: LinearLayoutManager

    private lateinit var adapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layoutManager = LinearLayoutManager(this)
        contactsRecyclerView.layoutManager = layoutManager
        contactsRecyclerView.setHasFixedSize(true)

        adapter = ContactsAdapter()
        contactsRecyclerView.adapter = adapter

        saveBtn.setOnClickListener {
            val name = nameTV.text.toString()
            val phone = phoneTV.text.toString()
            val contact = Contact(UUID.randomUUID().toString(), name, phone)
            adapter.addContact(contact)
        }

    }
}