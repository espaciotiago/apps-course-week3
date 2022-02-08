package tech.yeswecode.week3

import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

interface OnDeleteContact {
    fun onDelete(contact: Contact?)
}

class ContactView(itemView: View): RecyclerView.ViewHolder(itemView) {

    var listener: OnDeleteContact? = null
    var contact: Contact? = null

    val nameView: TextView = itemView.findViewById(R.id.nameTxt)
    val phoneView: TextView = itemView.findViewById(R.id.phoneTxt)
    val deletePhone: Button = itemView.findViewById(R.id.deleteBtn)

    init {
        deletePhone.setOnClickListener {
            listener?.onDelete(contact)
        }
    }
}