package android.consultafrota.com.firebase_samples

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser


class MainActivity : AppCompatActivity() {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    private var txtCarregar: TextView? = null
    private var mAuth: FirebaseAuth? = null
    private var mAuthListener: FirebaseAuth.AuthStateListener? = null

    private var mTextEmail: EditText? = null
    private var mTextPassword: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextEmail = findViewById(R.id.emailTxt) as EditText?
        mTextPassword = findViewById(R.id.passwordTxt) as EditText?


        mAuth = FirebaseAuth.getInstance()



        mAuthListener = FirebaseAuth.AuthStateListener {

                var user: FirebaseUser? = mAuth?.currentUser
                if (user != null)
                {
                    Log.d("USER ID", "onAuthStateChanged:signed_in:" + user.getUid());
                }
                else
                {
                    Log.d("ERRO USUARIO", "onAuthStateChanged:signed_out");
                }
            }

        findViewById(R.id.btCarregar).setOnClickListener { CarregarTelaLista() }
        findViewById(R.id.btLogar).setOnClickListener { FazerLogin() }

    }

    override fun onStart() {
        super.onStart()
        mAuth?.addAuthStateListener(mAuthListener!!)
    }

    override fun onStop() {
        super.onStop()
        if(mAuthListener != null)
        {
            mAuth?.removeAuthStateListener(mAuthListener!!)
        }
    }

    override fun onResume() {
        super.onResume()
        FazerLogout()
    }

    fun FazerLogin()
    {
        //Toast.makeText(this,"Tentar logar",Toast.LENGTH_SHORT).show()
        mAuth?.signInWithEmailAndPassword(mTextEmail?.text.toString(),mTextPassword?.text.toString())?.addOnCompleteListener(this)
        {
           task: Task<AuthResult> -> if (!task.isSuccessful){
                Toast.makeText(this,"ERROR",Toast.LENGTH_SHORT).show()
            }else {
            CarregarTelaLista()
            }
        }
    }

    fun FazerLogout()
    {
        if(mAuth?.currentUser != null) {
            FirebaseAuth.getInstance().signOut();
            Toast.makeText(this,"Logout feito com sucesso!",Toast.LENGTH_SHORT).show()
        }

    }

    fun CarregarTelaLista()
    {
        val intent:Intent = Intent(Main2Activity.getStartActivityIntent(this))
        startActivity(intent);
    }
}
