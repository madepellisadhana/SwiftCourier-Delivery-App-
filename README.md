# SwiftCourier-Delivery-App-

#Name: Madepelli Sadhana
#Student ID: N01651380

Project Overview 

SwiftCourier is an Android application designed to manage and track delivery orders efficiently. The app allows users to view delivery details, update order statuses, and fetch order information using an intuitive interface. The main screen (MainActivity) displays essential delivery details such as Order ID, Delivery Address, and Status using data stored in SharedPreferences. Users can manually enter an order ID and fetch order details, with a validation feature to check if the order exists. The "Update Status" button allows users to mark an order as "Delivered", which updates both the UI and stored data persistently. The "View Details" button navigates to DeliveryDetailsActivity, where users can view the latest order information, including the updated status. Data is passed between activities using Intents, ensuring that any status updates reflect accurately across the app. The project follows Android’s Material Design principles and utilizes AppCompatActivity for better compatibility. With a simple yet effective architecture, SwiftCourier streamlines the order tracking process for delivery personnel, enhancing efficiency and user experience.
