package com.example.stackoverflowandroidapplication;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HotFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HotFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HotFragment extends Fragment   {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    ArrayList<ItemObject> mPopulerTagsList;
    RecyclerView mYourHasRecyclerView;
    RecyclerView.LayoutManager mYourHasLayoutMa;
    private QuetiionViewModel quetiionViewModel;
    private String mTag;
    private int mTagCount=1;
    QusAddpter qusAddpter;
    QuestionListActivity questionListActivity;
    @SuppressLint("ValidFragment")
    public HotFragment(String tags, int tagCount) {
        mTag=tags;
        mTagCount=tagCount;    }
    public HotFragment() {
        // Required empty public constructor
    }
    public static HotFragment newInstance(){
        return new HotFragment();
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HotFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HotFragment newInstance(String param1, String param2) {
        HotFragment fragment = new HotFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_hot, container, false);
        mYourHasRecyclerView=view.findViewById(R.id.hot_qui_recycler);
        mYourHasLayoutMa=new LinearLayoutManager(getActivity());
        mYourHasRecyclerView.setLayoutManager(mYourHasLayoutMa);
          qusAddpter=new QusAddpter();
        mYourHasRecyclerView.setAdapter(qusAddpter);
        // Inflate the layout for this fragment
        quetiionViewModel= ViewModelProviders.of(this).get(QuetiionViewModel.class);
        questionListActivity=QuestionListActivity.getQuestionListActivity();

        setObserve(mTagCount );
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public void setObserve( int mTagCount ){
        switch (questionListActivity.mTagCount){
            case 1:
                quetiionViewModel.getAllTagFirstHot().observe(this, new Observer<List<TagFirst>>() {
                    @Override
                    public void onChanged(@Nullable List<TagFirst> tagFirsts) {
                        ArrayList<ItemObject> arrayList=new ArrayList<>();
                        for(int i=0;i<tagFirsts.size();i++){
                            ItemObject itemObject=new ItemObject(tagFirsts.get(i).getQutionTitle(),tagFirsts.get(i).getQutionLink()
                                    ,tagFirsts.get(i).getAnswered(),tagFirsts.get(i).getAnswerCount(),tagFirsts.get(i).getTypesActivit());
                            arrayList.add(itemObject);

                        }
                        qusAddpter.setmPopulerTagsList(arrayList);

                    }
                });
                break;
            case 2:
                quetiionViewModel.getAllTagsecondHot().observe(this, new Observer<List<TagSecond>>() {
                    @Override
                    public void onChanged(@Nullable List<TagSecond> tagSeconds) {
                        ArrayList<ItemObject> arrayList=new ArrayList<>();
                        for(int i=0;i<tagSeconds.size();i++){
                            ItemObject itemObject=new ItemObject(tagSeconds.get(i).getQutionTitle(),tagSeconds.get(i).getQutionLink()
                                    ,tagSeconds.get(i).getAnswered(),tagSeconds.get(i).getAnswerCount(),tagSeconds.get(i).getTypesActivit());
                            arrayList.add(itemObject);

                        }
                        qusAddpter.setmPopulerTagsList(arrayList);
                    }
                });
                break;
            case 3:
                quetiionViewModel.getAllTagThridHot().observe(this, new Observer<List<TagThrid>>() {
                    @Override
                    public void onChanged(@Nullable List<TagThrid> tagThrids) {
                        ArrayList<ItemObject> arrayList=new ArrayList<>();
                        for(int i=0;i<tagThrids.size();i++){
                            ItemObject itemObject=new ItemObject(tagThrids.get(i).getQutionTitle(),tagThrids.get(i).getQutionLink()
                                    ,tagThrids.get(i).getAnswered(),tagThrids.get(i).getAnswerCount(),tagThrids.get(i).getTypesActivit());
                            arrayList.add(itemObject);

                        }
                        qusAddpter.setmPopulerTagsList(arrayList);
                    }
                });
                break;
            case 4:
                quetiionViewModel.getmAllTagForthHot().observe(this, new Observer<List<TagForth>>() {
                    @Override
                    public void onChanged(@Nullable List<TagForth> tagForths) {
                        ArrayList<ItemObject> arrayList=new ArrayList<>();
                        for(int i=0;i<tagForths.size();i++){
                            ItemObject itemObject=new ItemObject(tagForths.get(i).getQutionTitle(),tagForths.get(i).getQutionLink()
                                    ,tagForths.get(i).getAnswered(),tagForths.get(i).getAnswerCount(),tagForths.get(i).getTypesActivit());
                            arrayList.add(itemObject);

                        }
                        qusAddpter.setmPopulerTagsList(arrayList);
                    }
                });
                break;
        }

    }



    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
    private   class QusAddpter extends RecyclerView.Adapter<QusAddpter.ViewHolder> {
        //public ArrayList<StackActiveTags> mPopulerTagsList;
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(getActivity()).inflate(R.layout.qui_jtems,null);
            ViewHolder viewHolder=new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
            viewHolder.showTagTextView.setText(mPopulerTagsList.get(i).getQutionTitle());

        }
        void setmPopulerTagsList(ArrayList<ItemObject> mTagsListt){
            mPopulerTagsList=  mTagsListt;
            notifyDataSetChanged();
        }
        @Override
        public int getItemCount() {
            if(mPopulerTagsList!=null) return mPopulerTagsList.size();
            return 0;
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            TextView showTagTextView;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                showTagTextView=itemView.findViewById(R.id.qui_item_text);
                itemView.setOnClickListener(this);
            }

            @Override
            public void onClick(View v) {
                final int ind = getAdapterPosition();


            }
        }
    }
}
