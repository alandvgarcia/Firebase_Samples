package android.consultafrota.com.firebase_samples

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

import com.google.firebase.analytics.FirebaseAnalytics


class MainActivity : AppCompatActivity() {

    private var mFirebaseAnalytics: FirebaseAnalytics? = null
    private var txtCarregar: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);

        Bundle bundle = new Bundle();
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1");
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "teste");
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "image");
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle);

        mFirebaseAnalytics.setUserProperty("favorite_food", "Steak");*/

        findViewById(R.id.btCarregar).setOnClickListener { CarregarTelaLista() }


    }

    fun CarregarTelaLista()
    {
        txtCarregar = findViewById(R.id.txtInicial) as TextView
        txtCarregar?.text = "Carregar List View"

        val intent:Intent = Intent(Main2Activity.getStartActivityIntent(this))
        startActivity(intent);
    }
}
