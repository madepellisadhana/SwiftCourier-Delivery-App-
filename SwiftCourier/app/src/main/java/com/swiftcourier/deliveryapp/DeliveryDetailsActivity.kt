package com.swiftcourier.deliveryapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DeliveryDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delivery_details)

        // Retrieve data from Intent
        val orderId = intent.getStringExtra("orderId")
        val address = intent.getStringExtra("address")
        val status = intent.getStringExtra("status")

        // Update the UI
        val orderIdTextView: TextView = findViewById(R.id.detail_order_id)
        val addressTextView: TextView = findViewById(R.id.detail_address)
        val statusTextView: TextView = findViewById(R.id.detail_status)

        orderIdTextView.text = "Order ID: $orderId"
        addressTextView.text = "Delivery Address: $address"
        statusTextView.text = "Status: $status"
    }
}
