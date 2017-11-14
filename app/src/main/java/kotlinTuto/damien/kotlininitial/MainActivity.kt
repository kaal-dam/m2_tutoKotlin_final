package kotlinTuto.damien.kotlininitial

import android.app.Fragment
import android.app.FragmentManager
import android.app.FragmentTransaction
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction, name:String) {
    beginTransaction().func().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE).addToBackStack(name).commit()
}

fun Context.toastLong(text: String) = Toast.makeText(this,text,Toast.LENGTH_LONG).show()

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        /*
        BookRepository br = BookRepository.getInstance();
        br.initialize();
         */
        BookRepository.initialize()
        replaceFragment(MainFragment(),R.id.fragment_container)

        fab.setOnClickListener { theBillionDollarMistake() }
    }

    //TODO : the billion dollar mistake
    fun theBillionDollarMistake(){
        var a = "abc"
        var b: String? = "abc"

//        a = null
        val t1 = a.length

        b = null
//        val t2 = b.length
        val t2 = b?.length
        val t3 = b?.length ?: -1
//
//        var c: Book = BookRepository.getByTitle("LÉGENDE")
        toastLong("a=$a b=$b t1=$t1 t2=$t2 t3=$t3")
    }

    /*
     private void replaceFragment (Fragment fragment){
        String backStateName =  fragment.getClass().getName();

        FragmentManager manager = getFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate (backStateName, 0);

        if (!fragmentPopped && manager.findFragmentByTag(backStateName) == null){ //fragment not in back stack, create it.
            FragmentTransaction ft = manager.beginTransaction();
            ft.replace(R.id.fragment, fragment, backStateName);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }
     */
    fun replaceFragment(fragment: Fragment, frameId: Int) {
        val backStateName = fragment::class.java.getName()
        val fragmentPopped = fragmentManager.popBackStackImmediate(backStateName, 0)
        if (!fragmentPopped && fragmentManager.findFragmentByTag(backStateName) == null) {
            fragmentManager.inTransaction({replace(frameId, fragment)},backStateName)
        }
    }


}


