package cavazos.gerardo.calculadora1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var txtNumero: TextView? = null
    var txtOperacion: TextView? = null
    var btn1: Button? = null
    var btn2: Button? = null
    var btn3: Button? = null
    var btn4: Button? = null
    var btn5: Button? = null
    var btn6: Button? = null
    var btn7: Button? = null
    var btn8: Button? = null
    var btn9: Button? = null
    var btn0: Button? = null
    var btnSuma: Button? = null
    var btnResta: Button? = null
    var btnMulti: Button? = null
    var btnDividir: Button? = null
    var btnBorrar: Button? = null
    var btnResultado: Button? = null
    var txtTemp: String = ""
    var txtOpTemp: String = ""
    var oper: String = ""
    var num1: Float = 0.0F
    var num2: Float = 0.0F

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtNumero = findViewById(R.id.txt1)
        txtOperacion = findViewById(R.id.txtresult)
        btn1 = findViewById(R.id.b1)
        btn2 = findViewById(R.id.b2)
        btn3 = findViewById(R.id.b3)
        btn4 = findViewById(R.id.b4)
        btn5 = findViewById(R.id.b5)
        btn6 = findViewById(R.id.b6)
        btn7 = findViewById(R.id.b7)
        btn8 = findViewById(R.id.b8)
        btn9 = findViewById(R.id.b9)
        btn0 = findViewById(R.id.b0)
        btnSuma = findViewById(R.id.bmas)
        btnResta = findViewById(R.id.bmenos)
        btnMulti = findViewById(R.id.bpor)
        btnDividir = findViewById(R.id.bdiv)
        btnBorrar = findViewById(R.id.bborrar)
        btnResultado = findViewById(R.id.bborrar)
    }

    fun bot1(v: View){
        txtTemp = "$txtTemp" + "1"
        txtNumero?.text = txtTemp
    }

    fun bot2(v: View){
        txtTemp = "$txtTemp" + "2"
        txtNumero?.text = txtTemp
    }

    fun bot3(v: View){
        txtTemp = "$txtTemp" + "3"
        txtNumero?.text = txtTemp
    }

    fun bot4(v: View){
        txtTemp = "$txtTemp" + "4"
        txtNumero?.text = txtTemp
    }

    fun bot5(v: View){
        txtTemp = "$txtTemp" + "5"
        txtNumero?.text = txtTemp
    }

    fun bot6(v: View){
        txtTemp = "$txtTemp" + "6"
        txtNumero?.text = txtTemp
    }

    fun bot7(v: View){
        txtTemp = "$txtTemp" + "7"
        txtNumero?.text = txtTemp
    }

    fun bot8(v: View){
        txtTemp = "$txtTemp" + "8"
        txtNumero?.text = txtTemp
    }

    fun bot9(v: View){
        txtTemp = "$txtTemp" + "9"
        txtNumero?.text = txtTemp
    }

    fun bot0(v: View){
        txtTemp = "$txtTemp" + "0"
        txtNumero?.text = txtTemp
    }

    fun botResta(v: View){
        if(txtNumero?.text == "" && txtOperacion?.text == ""){
            Toast.makeText( this, "Ingrese un número", Toast.LENGTH_SHORT).show()
            return
        }
        realizarOperacion()
        oper = "resta"
        if(txtOpTemp == ""){
            txtOpTemp = "$txtTemp -"
            txtOperacion?.text = txtOpTemp
        }else{
            txtOpTemp = " $txtOpTemp $txtTemp -"
            txtOperacion?.text = txtOpTemp
        }
        txtTemp = ""
    }

    fun botMulti(v: View){
        if(txtNumero?.text == "" && txtOperacion?.text == ""){
            Toast.makeText( this, "Ingrese un número", Toast.LENGTH_SHORT).show()
            return
        }
        realizarOperacion()
        oper = "multi"
        if(txtOpTemp == ""){
            txtOpTemp = "$txtTemp *"
            txtOperacion?.text = txtOpTemp
        }else{
            txtOpTemp = " $txtOpTemp $txtTemp *"
            txtOperacion?.text = txtOpTemp
        }
        txtTemp = ""
    }

    fun botDividir(v: View){
        if(txtNumero?.text == "" && txtOperacion?.text == ""){
            Toast.makeText( this, "Ingrese un número", Toast.LENGTH_SHORT).show()
            return
        }
        realizarOperacion()
        if(txtOperacion?.text.toString().equals("No se puede dividir entre cero.")){
            return
        }
        oper = "dividir"
        if(txtOpTemp == ""){
            txtOpTemp = "$txtTemp /"
            txtOperacion?.text = txtOpTemp
        }else{
            txtOpTemp = " $txtOpTemp $txtTemp /"
            txtOperacion?.text = txtOpTemp
        }
        txtTemp = ""
    }

    fun botSuma(v: View){
        if(txtNumero?.text == "" && txtOperacion?.text == ""){
            Toast.makeText( this, "Favor de ingresar un número", Toast.LENGTH_SHORT).show()
            return
        }
        realizarOperacion()
        oper = "suma"
        if(txtOpTemp == "" || txtOpTemp.toFloat() == num1){
            if(txtOpTemp?.equals("")){
                txtOpTemp = "$txtTemp +"
                txtOperacion?.text = txtOpTemp
            }else if(txtOpTemp.toFloat() == num1 && num1 > 0){
                txtOpTemp = "$num1 +"
                txtOperacion?.text = txtOpTemp
            }

        }else{
            txtOpTemp = " $txtOpTemp $txtTemp +"
            txtOperacion?.text = txtOpTemp
        }
        txtTemp = ""
    }

    fun realizarOperacion(){
        if(txtNumero?.text == ""){
            num1 = num1
        }else{
            if(oper == ""){
                num1 = txtNumero?.text.toString().toFloat()
            }else if(oper == "suma"){
                num2 = txtNumero?.text.toString().toFloat()
                num1 += num2
            }else if(oper == "resta"){
                num2 = txtNumero?.text.toString().toFloat()
                num1 -= num2
            }else if(oper == "multi"){
                num2 = txtNumero?.text.toString().toFloat()
                num1 *= num2
            }else{
                if(txtNumero?.text.toString() == "0"){
                    //txtOperacion?.text = "No se puede dividir entre cero."
                    Toast.makeText( this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show()
                }else{
                    num2 = txtNumero?.text.toString().toFloat()
                    num1 /= num2
                }
            }
        }
        txtNumero?.text = ""
    }

    fun botResultado(v: View){
        realizarOperacion()
        if(txtOperacion?.text.toString().equals("No se puede dividir entre cero.")){
            return
        }
        txtOperacion?.text = num1.toString()
        txtOpTemp = num1.toString()
        txtTemp = ""
    }

    fun botBorrar(v: View){
        oper = ""
        txtTemp = ""
        txtOpTemp = ""
        txtOperacion?.text = ""
        txtNumero?.text = ""
        num1 = 0.0F
        num2 = 0.0F
    }
}
