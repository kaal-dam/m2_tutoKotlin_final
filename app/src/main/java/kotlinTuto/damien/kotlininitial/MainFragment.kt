package kotlinTuto.damien.kotlininitial

import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment: Fragment(){
    /*
        MainActivity mActivity;
     */
    lateinit var mActivity: MainActivity

    /*
        public static int numberStatic = 0;
    */
    companion object {
        @JvmField
        var numberStatic: Int =0

        var number: Int = 0
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val view = inflater!!.inflate(R.layout.fragment_main, container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        val adapter:ArrayAdapter<String> = ArrayAdapter(activity,android.R.layout.simple_list_item_1,BookRepository.getAllTitle())
        lv_main.adapter= adapter
        /*
        lv_main.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String value = (String) adapterView.getItemAtPosition(position)
                    Fragment f = new DetailFragment();
                    Bundle b = new Bundle();
                    b.putString("title", value);
                    MainActivity mActivity = (MainActivity) getActivity();
                    mActivity.replaceFragment(fragment,R.id.fragment_container)
                }
            });
         */
        lv_main.onItemClickListener = AdapterView.OnItemClickListener { adapterView, _view, position, l ->
            val value = adapterView.getItemAtPosition(position) as String
            val fragment = DetailFragment()
            val b = Bundle()
            b.putString("title", value)
            fragment.arguments = b
            mActivity= activity as MainActivity
            mActivity.replaceFragment(fragment,R.id.fragment_container)
        }
    }

    /*
    @override
    public void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"number=+"MainFragment.number+" numberStatic="+MainFragment.numberStatic,Toast.LENGTH_LONG).show()
    }
     */
    override fun onResume() {
        super.onResume()
        activity.toastLong("number=${MainFragment.number} numberStatic=${MainFragment.numberStatic}")
    }

}