import android.support.wearable.activity.WearableActivity

class MainActivity : WearableActivity() {
    // Declare any variables or views here

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize any views or variables here

        // Example of sending a message to the wearable
        val messageClient = Wearable.getMessageClient(this)
        messageClient.sendMessage(wearableNode.id, "/message_path", null)
    }

    override fun onStart() {
        super.onStart()

        // Example of registering a listener for data changes on the wearable
        val dataClient = Wearable.getDataClient(this)
        dataClient.addListener(this, Uri.parse("/data_path"), DataListener {
            // Handle data change here
        })
    }

    override fun onStop() {
        super.onStop()

        // Example of unregistering a listener for data changes on the wearable
        val dataClient = Wearable.getDataClient(this)
        dataClient.removeListener(this)
    }
}
