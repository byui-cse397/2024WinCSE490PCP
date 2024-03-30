package byui.app.linkUp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import byui.app.linkUp.databinding.LoginBinding

class LoginActivity : AppCompatActivity() {

    // Using View Binding to access the layout's views
    private lateinit var binding: LoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = LoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup listeners for your buttons
        setupLoginButton()
//        setupSignUpButton()
    }

    private fun setupLoginButton() {
        binding.signinButton.setOnClickListener {
            // Implement your login logic here
            // For example, validate the username and password
            val username = binding.UserNEntry.text.toString().trim()
            val password = binding.passEntry.text.toString().trim()

//            // Assume a method validateCredentials exists and returns true if the credentials are valid
//            if (validateCredentials(username, password)) {
//                // Start MainActivity on successful login
//                val intent = Intent(this, MainActivity::class.java)
//                startActivity(intent)
//                finish() // Finish LoginActivity so it's removed from the back stack
//            } else {
//                // Show error message
//            }
        }
    }

//    private fun setupSignUpButton() {
//        binding.tosignup.setOnClickListener {
//            // Navigate to SignUpActivity
//            // Assume SignUpActivity is another activity you have for users to sign up
//            val intent = Intent(this, SignUpActivity::class.java)
//            startActivity(intent)
//        }
//    }

    private fun validateCredentials(username: String, password: String): Boolean {
        // Implement your validation logic here
        // This is just a placeholder for demonstration
        return true
    }
}