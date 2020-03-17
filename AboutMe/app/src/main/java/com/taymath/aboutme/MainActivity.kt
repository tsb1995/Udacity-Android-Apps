package com.taymath.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.taymath.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("TayMath")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        //findViewById<Button>(R.id.done).setOnClickListener {
        //    addNickname(it)
        //}

        binding.done.setOnClickListener {
            addNickname(it)
        }

    }

    private fun addNickname(view: View) {
//        // Grab view for editing the nickname
//        val editText = findViewById<EditText>(R.id.nickname_edit)
//        // Grab the view for displaying the nickname
//        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)
//
//        //  Bring our edited text into our TextView
//        nicknameTextView.text = editText.text
//        // Hide our unnecessary views
//        editText.visibility = View.GONE
//        view.visibility = View.GONE
//
//        // Display our TextView
//        nicknameTextView.visibility = View.VISIBLE

        binding.apply {
//            nicknameText.text = binding.nicknameEdit.text
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            nicknameEdit.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
            done.visibility = View.GONE
        }

        // Hide the keyboard.
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}
