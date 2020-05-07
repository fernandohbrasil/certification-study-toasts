package com.fernando.googlecertificationstudytoast

import android.os.Bundle
import android.view.Gravity
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.fernando.googlecertificationstudytoast.databinding.ActivityMainBinding
import com.fernando.googlecertificationstudytoast.databinding.CustomToastBinding


const val msg = "This is your Toast"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toastBinding: CustomToastBinding

    private lateinit var toast: Toast

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        toast = Toast.makeText(this, msg, Toast.LENGTH_LONG)

        spinnerBind()

        binding.btnShow.setOnClickListener {
            showClick()
        }

        binding.btnCancel.setOnClickListener {
            cancelClick()
        }
    }

    private fun cancelClick() {
        toast.cancel()
    }

    private fun showClick() {
        toast.setGravity(getGravity(), xOffset(), yOffset())
        toast.setMargin(getHorizontalMargin(), getVerticalMargin())
        toast.duration = getDuration()

        showToast()
    }

    private fun showToast() {
        if (binding.rbCustom.isChecked) {
            customToast()
        } else {
            toast.show()
        }
    }

    private fun customToast() {
        toastBinding = CustomToastBinding.inflate(layoutInflater)
        toastBinding.text.text = msg
        toast.view = toastBinding.root
        toast.show()
    }

    private fun getDuration(): Int {
        if (binding.rbLong.isChecked) {
            return Toast.LENGTH_LONG
        }
        return Toast.LENGTH_SHORT
    }

    private fun getVerticalMargin(): Float {
        return try {
            binding.edtVerticalMargin.text.toString().toFloat()
        } catch (e: NumberFormatException) {
            binding.edtVerticalMargin.setText("Invalid value! 0.0 was used")
            0.0F
        }
    }

    private fun getHorizontalMargin(): Float {
        return try {
            binding.edtHorizontalMargin.text.toString().toFloat()
        } catch (e: NumberFormatException) {
            binding.edtHorizontalMargin.setText("Invalid value! 0.0 was used")
            0.0F
        }
    }

    private fun yOffset(): Int {
        return try {
            binding.edtYOffset.text.toString().toInt()
        } catch (e: NumberFormatException) {
            binding.edtYOffset.setText("Invalid value! 0 was used")
            0
        }
    }

    private fun xOffset(): Int {
        return try {
            binding.edtXOffset.text.toString().toInt()
        } catch (e: NumberFormatException) {
            binding.edtXOffset.setText("Invalid value! 0 was used")
            0
        }
    }

    private fun getGravity(): Int {
        return when (binding.spGravity.selectedItem) {
            "Gravity.START" -> Gravity.START
            "Gravity.CENTER" -> Gravity.CENTER
            "Gravity.BOTTOM" -> Gravity.BOTTOM
            "Gravity.CENTER_HORIZONTAL" -> Gravity.CENTER_HORIZONTAL
            "Gravity.CENTER_VERTICAL" -> Gravity.CENTER_VERTICAL
            "Gravity.CLIP_HORIZONTAL" -> Gravity.CLIP_HORIZONTAL
            "Gravity.CLIP_VERTICAL" -> Gravity.CLIP_VERTICAL
            "Gravity.END" -> Gravity.END
            "Gravity.FILL" -> Gravity.FILL
            "Gravity.FILL_HORIZONTAL" -> Gravity.FILL_HORIZONTAL
            "Gravity.FILL_VERTICAL" -> Gravity.FILL_VERTICAL
            "Gravity.TOP" -> Gravity.TOP
            else -> 0
        }
    }

    private fun spinnerBind() {
        ArrayAdapter.createFromResource(
            this,
            R.array.gravity_values,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spGravity.adapter = adapter
        }
    }

}
