package com.karan.dailog_box

import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.CheckBox
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.karan.dailog_box.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val parts= arrayOf("SSD","Cabinet","HDD","AIO","SATA cables")
        val chkItems= booleanArrayOf(true,true,false,true,true,true)
        binding.btnsingle.setOnClickListener{

            AlertDialog.Builder(this@MainActivity).apply {

                setItems(parts)
                {
                    _,which->
                }
                setTitle("Components of the computer")

                setPositiveButton("yes")
                {
                    _,_->
                }
                setNegativeButton("NO")
                {
                _,_->
                }
                setCancelable(false)
                Toast.makeText(this@MainActivity, "it is single choice dialog box toast", Toast.LENGTH_SHORT).show()


            }.show()

        }
        binding.btnmultiple.setOnClickListener {
            AlertDialog.Builder(this@MainActivity).apply {
                setMultiChoiceItems(parts,chkItems)
                {
                    _,which,dialogbox->
                    val selectedItem=parts[which]
                    Toast.makeText(this@MainActivity, "selected :${selectedItem}",Toast.LENGTH_SHORT).show()
                }




            }.show()
        }
    }
}