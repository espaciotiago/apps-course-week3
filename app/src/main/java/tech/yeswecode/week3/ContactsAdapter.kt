package tech.yeswecode.week3

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ContactsAdapter: RecyclerView.Adapter<ContactView>(), OnDeleteContact {

    private val contacts = ArrayList<Contact>()

    init {
        contacts.add(Contact("1","N1", "301"))
        contacts.add(Contact("2","N2", "302"))
        contacts.add(Contact("3","N3", "303"))
        contacts.add(Contact("4","N4", "304"))
    }

    fun addContact(contact: Contact) {
        this.contacts.add(contact)
        notifyItemInserted(contacts.size - 1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactView {
        val inflater = LayoutInflater.from(parent.context)
        val row = inflater.inflate(R.layout.item_contact, parent, false)
        val contactView = ContactView(row)
        return contactView
    }

    override fun onBindViewHolder(holder: ContactView, position: Int) {
        val contact = contacts[position]
        holder.listener = this
        holder.contact = contact
        holder.nameView.setText(contact.name)
        holder.phoneView.setText(contact.phone)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    override fun onDelete(contact: Contact?) {
        Log.d("onDelete", contact?.name.toString())
    }

}