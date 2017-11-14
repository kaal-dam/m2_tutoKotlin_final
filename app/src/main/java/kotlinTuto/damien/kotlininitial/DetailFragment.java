package kotlinTuto.damien.kotlininitial;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


public class DetailFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_detail,container,false);
        Bundle b = getArguments();
        Book livre = BookRepository.INSTANCE.getByTitle(b.getString("title"));
        if(livre!=null) {
            TextView tv1 = v.findViewById(R.id.title_tv);
            TextView tv2 = v.findViewById(R.id.autor_tv);
            TextView tv3 = v.findViewById(R.id.resume_tv);
            tv1.setText(livre.getTitle());
            tv2.setText(livre.getAuteur());
            tv3.setText(livre.getResumer());
        }
        MainFragment.Companion.setNumber(MainFragment.Companion.getNumber()+1);
        MainFragment.numberStatic++;
        return v;
    }
}
