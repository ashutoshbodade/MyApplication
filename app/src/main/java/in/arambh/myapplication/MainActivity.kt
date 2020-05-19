package `in`.arambh.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.firestore.FirebaseFirestore
import es.dmoral.toasty.Toasty
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var counter : Int = 0
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        btnSavetoDB.setOnClickListener {


            val firebasedb = FirebaseFirestore.getInstance()

            val product = hashMapOf(
                "name" to "abc",
                "price" to 549
            )

            firebasedb.collection("products")
                .add(product as Map<String, Any>)
                .addOnSuccessListener {
                    Toasty.success(this,"add to db sucess", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                    Toasty.error(this,"add to db failed", Toast.LENGTH_LONG).show()
                }
                .addOnCompleteListener {

                }



            // if you know document id then call set() method
            // if you don't know or want to store in random document call add() method

/*
            val users = hashMapOf(
                "name" to edtNameFirebase.text.toString(),
                "age" to 23
            )

            FirebaseFirestore.getInstance().collection("users")
                .add(users as Map<String, Any>)
                .addOnSuccessListener {
                    Toasty.success(this,"added sucessfully" + it.id, Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener {
                    Toasty.error(this,"You got error",Toast.LENGTH_LONG).show()
           }
*/
        }


    }

    fun count(view: View) {
        counter = counter + 1
        txtCount.text = counter.toString()
    }

    fun gotosecond(view: View) {
        val secondintent = Intent(this, SecondActivity::class.java)
        secondintent.putExtra("name",edtName.text.toString())
        startActivity(secondintent)
    }

    fun showtoast(view: View) {
        Toast.makeText(this,"This is default toast", Toast.LENGTH_LONG).show()
    }

    fun showerrortoast(view: View) {
        Toasty.error(this,"You got error",Toast.LENGTH_LONG).show()
    }

    fun showsucesstoast(view: View) {
        Toasty.success(this,"Log in sucessfully", Toast.LENGTH_SHORT).show()
    }

    fun showalert(view: View) {

        val builder = AlertDialog.Builder(this)
        //set title for alert dialog
        builder.setTitle("Log out")
        //set message for alert dialog
        builder.setMessage("Are you sure want to log out ?")

        //performing positive action
        builder.setPositiveButton("Yes"){dialogInterface, which ->
            Toasty.success(this,"Logged out sucessfully", Toast.LENGTH_SHORT).show()
        }

        //performing negative action
        builder.setNegativeButton("No"){dialogInterface, which ->
            Toast.makeText(applicationContext,"clicked No",Toast.LENGTH_LONG).show()
        }

        // Create the AlertDialog
        val alertDialog: AlertDialog = builder.create()
        // Set other dialog properties
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

    fun fetchdb(view: View) {

        db.collection("users").whereEqualTo("name", "nandini")
            .get()
            .addOnSuccessListener { documents ->
                txtFirebaseFetchName.text = documents.size().toString()
            }

    }

}