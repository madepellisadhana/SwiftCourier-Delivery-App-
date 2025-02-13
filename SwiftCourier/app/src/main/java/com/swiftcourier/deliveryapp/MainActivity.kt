package com.swiftcourier.deliveryapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val orderIdTextView: TextView = findViewById(R.id.order_id)
        val addressTextView: TextView = findViewById(R.id.address)
        val statusTextView: TextView = findViewById(R.id.status)
        val buttonUpdateStatus: Button = findViewById(R.id.update_status_button)
        val buttonViewDetails: Button = findViewById(R.id.view_details_button)
        val inputOrderId: EditText = findViewById(R.id.input_order_id)
        val buttonFetchOrder: Button = findViewById(R.id.fetch_order_button)

        val sharedPreferences = getSharedPreferences("DeliveryPrefs", Context.MODE_PRIVATE)

        val orderId = sharedPreferences.getString("orderId", "12345")
        val address = sharedPreferences.getString("address", "123 Main Street")
        val status = sharedPreferences.getString("status", "Pending")

        orderIdTextView.text = "Order ID: $orderId"
        addressTextView.text = "Delivery Address: $address"
        statusTextView.text = "Status: $status"

        buttonUpdateStatus.setOnClickListener {
            val editor = sharedPreferences.edit()
            editor.putString("status", "Delivered")
            editor.apply()
            statusTextView.text = "Status: Delivered"
            Toast.makeText(this, "Order Marked as Delivered", Toast.LENGTH_SHORT).show()
        }

        buttonViewDetails.setOnClickListener {
            val intent = Intent(this, DeliveryDetailsActivity::class.java)
            intent.putExtra("orderId", orderId)
            intent.putExtra("address", address)
            intent.putExtra("status", statusTextView.text.toString()) // Send the updated status
            startActivity(intent)
        }




        buttonFetchOrder.setOnClickListener {
            val enteredOrderId = inputOrderId.text.toString()
            if (enteredOrderId == orderId) {
                Toast.makeText(this, "Order Found!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Order Not Found!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
