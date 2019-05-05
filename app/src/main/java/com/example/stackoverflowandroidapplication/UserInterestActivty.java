package com.example.stackoverflowandroidapplication;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

public class UserInterestActivty extends AppCompatActivity {

    private final String clientId = "14929";
    //client_secret:Bakwcs63AJoNoJSsYKw*0w((
    //key :KPGtGxBfWwU)nNVHxYpoFA((
    private final String apiKey = "Bakwcs63AJoNoJSsYKw*0w((";
    private final String key="KPGtGxBfWwU)nNVHxYpoFA((";
    private final String redirectUri = "https://stackexchange.com/oauth/login_success";
    public static final String API_BASE_URL = "https://stackexchange.com/oauth/dialog";
    RecyclerView tagsRecyclerView;
    RecyclerView selsectedTagsRecyclerView;
    RecyclerView.LayoutManager tagsLayoutMa;
    RecyclerView.LayoutManager selectedTagLayputMa;
    ArrayList<StackActiveTags> mPopulerTagsList;
    ArrayList<String> mSelectedArrayList;
    TagsAddpter tagsAddpter;
    SelectedTagAddpter selectedTagAddpter;
    Button mSubmit;
    private QuetiionViewModel quetiionViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interest_activty);
        mSubmit=findViewById(R.id.button_submit);
        mSelectedArrayList=new ArrayList<>();
        getAllPopulerTage();
        Drawable dDivider= ContextCompat.getDrawable(this,R.drawable.divider);
        DividerItemDecoration dividerItemDecoration=new DividerItemDecoration(this,VERTICAL);
        dividerItemDecoration.setDrawable(dDivider);
        tagsRecyclerView=findViewById(R.id.select_tag_recycler);
        tagsRecyclerView.addItemDecoration(dividerItemDecoration);
        tagsLayoutMa=new LinearLayoutManager(this);
        tagsRecyclerView.setLayoutManager(tagsLayoutMa);
        tagsAddpter=new   TagsAddpter();
        tagsRecyclerView.setAdapter(tagsAddpter);
        //Selected Tags Adapter
        selsectedTagsRecyclerView=findViewById(R.id.selected_tags_recycler);
        selectedTagLayputMa=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,true);
        selsectedTagsRecyclerView.setLayoutManager(selectedTagLayputMa);
        selectedTagAddpter=new SelectedTagAddpter();
        selsectedTagsRecyclerView.setAdapter(selectedTagAddpter);
        quetiionViewModel= ViewModelProviders.of(this).get(QuetiionViewModel.class);
        selsectedTagsRecyclerView.setVisibility(View.GONE);
        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mSelectedArrayList.size()==4){
                    for(int i=0;i<mSelectedArrayList.size();i++){
                        SelectedTags selectedTags=new  SelectedTags(mSelectedArrayList.get(i));
                        quetiionViewModel.insertAllTags(selectedTags);

                    }
                    Intent intent =new Intent(UserInterestActivty.this,QuestionListActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }
    public void getAllPopulerTage(){
       // Webservice webservice=  CanncetionController.getRetrofitInstance().create(Webservice.class);
        Retrofit retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl("https://api.stackexchange.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Webservice webservice = retrofit.create(Webservice.class);
        Call<StackOverTag.TagItems> call1= (Call<StackOverTag.TagItems>) webservice.getPopulerTags("desc","popular","stackoverflow");
        call1.enqueue(new Callback<StackOverTag.TagItems>() {
            @Override
            public void onResponse(Call<StackOverTag.TagItems> call, Response<StackOverTag.TagItems> response) {
                //finishActitv(response.body().getItems().get(0).getUserId())
                // ;
                StackOverTag.TagItems jsonResponse = response.body();
                ArrayList<StackActiveTags> stackActiveTags=jsonResponse.getItems();
                tagsAddpter.setmPopulerTagsList(stackActiveTags);
               //  Toast.makeText(UserInterestActivty.this, "Helow"+jsonResponse.getItems(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<StackOverTag.TagItems> call, Throwable t) {
                Log.e("Tag",t.getMessage());

            }
        });
    }


        private   class TagsAddpter extends RecyclerView.Adapter<ViewHolder> {
        //public ArrayList<StackActiveTags> mPopulerTagsList;
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view= LayoutInflater.from(UserInterestActivty.this).inflate(R.layout.select_tag_item,null);
                    ViewHolder viewHolder=new ViewHolder(view);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
             viewHolder.showTagTextView.setText(mPopulerTagsList.get(i).getName());

        }
        void setmPopulerTagsList(ArrayList<StackActiveTags> mTagsListt){
            mPopulerTagsList=mTagsListt;
            notifyDataSetChanged();
        }
        @Override
        public int getItemCount() {
           if(mPopulerTagsList!=null) return mPopulerTagsList.size();
        return 0;
        }
    }

    private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView showTagTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            showTagTextView=itemView.findViewById(R.id.text_tags);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            final int ind = getAdapterPosition();
            if(mSelectedArrayList.size()>=4){
                Toast.makeText(UserInterestActivty.this, "Maximum Four Tag Can Select", Toast.LENGTH_SHORT).show();
            } else {
                selsectedTagsRecyclerView.setVisibility(View.VISIBLE);
                mSelectedArrayList.add(mPopulerTagsList.get(ind).getName());
                selectedTagAddpter.setSelectTagList(mSelectedArrayList );

            }

        }
    }

    private class SelectedTagAddpter extends RecyclerView.Adapter<SelectedViewHolder> {

        @NonNull
        @Override
        public SelectedViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            View view=LayoutInflater.from(UserInterestActivty.this).inflate(R.layout.selected_item,null);
            SelectedViewHolder viewHolder=new SelectedViewHolder(view);

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(@NonNull SelectedViewHolder selectedViewHolder, int i) {
         selectedViewHolder.textView.setText(mSelectedArrayList.get(i));
        }
        void setSelectTagList(ArrayList<String>  s){
            mSelectedArrayList=s;
           // Toast.makeText(UserInterestActivty.this, "tagClick", Toast.LENGTH_SHORT).show();

            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {

            if(mSelectedArrayList!=null) return mSelectedArrayList.size();
             return 0;
        }
    }



    private class SelectedViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageButton imageButton;
        TextView textView;
        public SelectedViewHolder(@NonNull View itemView) {

            super(itemView);
            imageButton=itemView.findViewById(R.id.button_cancel_tag);
            imageButton.setTag(R.id.button_cancel_tag,itemView);
            textView=itemView.findViewById(R.id.text_selected_tag);
            itemView.setOnClickListener(this);
            imageButton.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if(v.getId()==imageButton.getId()){
                if(mSelectedArrayList.size()==1){
                    selsectedTagsRecyclerView.setVisibility(View.GONE);
                }
                mSelectedArrayList.remove(getAdapterPosition());
                selectedTagAddpter.notifyItemRemoved(getAdapterPosition());
            }
         }
    }
}
