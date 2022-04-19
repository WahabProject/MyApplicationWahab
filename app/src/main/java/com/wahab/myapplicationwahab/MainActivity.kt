package com.wahab.myapplicationwahab

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveForResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveForResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPindah: Button = findViewById(R.id.btn_pindah)
        btnPindah.setOnClickListener(this)

        val btnpindahdata: Button = findViewById(R.id.btn_pindah_data)
        btnpindahdata.setOnClickListener(this)

        val btnMoveWithObject: Button =
            findViewById(R.id.btn_move_activity_object)
        btnMoveWithObject.setOnClickListener(this)

        val btnDialPhone: Button = findViewById(R.id.btn_dial_number)
        btnDialPhone.setOnClickListener(this)

        val btnMoveForResult: Button = findViewById(R.id.btn_move_for_result)
        btnMoveForResult.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)

        val btnBiodata: Button = findViewById(R.id.btn_Biodata)
        btnBiodata.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_pindah -> {
                val intentPindah = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(intentPindah)
            }

            R.id.btn_pindah_data -> {
                val moveWithDataIntent = Intent(this@MainActivity, MoveWithDataActivity::class.java)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_NAME, "Wahab dull")
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_AGE, 20)
                moveWithDataIntent.putExtra(MoveWithDataActivity.EXTRA_ADDRESS, "Pekanbaru")
                startActivity(moveWithDataIntent)
            }

            R.id.btn_move_activity_object -> {
                val data = Data(
                    "Wahab Dulloh",
                    20,
                    "Wahabdulloh536@gmail.com",
                    "Pekanbaru"
                )

                val moveWithObjectIntent =
                    Intent(this@MainActivity, MoveWithObjectActivity::class.java)
                moveWithObjectIntent.putExtra(MoveWithObjectActivity.EXTRA_DATA, data)
                startActivity(moveWithObjectIntent)
            }
            R.id.btn_dial_number -> {
                val phoneNumber = "082285283333"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
            R.id.btn_move_for_result -> {
                val moveForResultIntent =
                    Intent(this@MainActivity, MoveForResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
            R.id.btn_Biodata -> {
                val intentBiodata = Intent(this@MainActivity, Biodata::class.java)
                startActivity(intentBiodata)
            }
        }
    }
}