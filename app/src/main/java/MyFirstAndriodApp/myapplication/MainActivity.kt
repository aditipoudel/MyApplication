package MyFirstAndriodApp.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.*

class MainActivity : AppCompatActivity(){

// lateinit variables
private lateinit var etFirst: EditText
private lateinit var etSecond: EditText
private lateinit var tvResult: TextView
private lateinit var btnCalculate: Button
private lateinit var rdoSum: RadioButton
private lateinit var rdoSub: RadioButton
// onCreate
override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    // Binding
    etFirst = findViewById(R.id.etFirst)
    etSecond = findViewById(R.id.etSecond)
    tvResult = findViewById(R.id.tvResult)
    btnCalculate = findViewById(R.id.btnCalculate)
    rdoSum = findViewById(R.id.rdoSum)
    rdoSub = findViewById(R.id.rdoSub)
    // Add Click Listener
    btnCalculate.setOnClickListener {
        if(rdoSum.isChecked)
            addNumber()
        else
            subtractNumber()
    }
}
private fun addNumber(){
    val first: Int = etFirst.text.toString().toInt()
    val second = etSecond.text.toString().toInt()
    val result = first + second
    tvResult.text = result.toString()
    Toast.makeText(this@MainActivity, "Sum is $result", Toast.LENGTH_LONG).show()
}
private fun subtractNumber() {
    val first: Int = etFirst.text.toString().toInt()
    val second = etSecond.text.toString().toInt()
    val result = first - second
    tvResult.text = result.toString()
}

private fun validateEdittext(): Boolean{
    var isEmpty:Boolean = false
    if(TextUtils.isEmpty(etFirst.text)) {
        etFirst.requestFocus();
        etFirst.error = "FIELD CANNOT BE EMPTY";
        isEmpty = true
    }
    if(TextUtils.isEmpty(etSecond.text)) {
        etSecond.requestFocus();
        etSecond.error = "FIELD CANNOT BE EMPTY";
        isEmpty = true
    }
    return isEmpty
}
}



