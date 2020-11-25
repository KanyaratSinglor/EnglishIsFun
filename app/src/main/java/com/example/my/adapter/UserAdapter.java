//package com.example.my.adapter;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.my.R;
//import com.example.my.model.User;
//
//
//public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {
//
//  private Context mContext;
//  private User[] mUsers;
//
//  public UserAdapter(Context context, User[] users) {
//    this.mContext = context;
//    this.mUsers = users;
//  }
//
//  @NonNull
//  @Override
//  public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//    View v = LayoutInflater.from(parent.getContext())
//        .inflate(R.layout.item_user, parent, false);
//    return new MyViewHolder(v);
//  }
//
//  @Override
//  public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//    User user = mUsers[position];
//
//    holder.fullNameTextView.setText(user.firstName);
//    holder.birthDateTextView.setText(DateFormatter.formatDateForUi(user.birthDate));
//
//    holder.singleTextView.setBackgroundColor(user.single ? Color.RED : Color.WHITE);
//
//    holder.genderImageView.setImageResource(
//        user.gender == User.GENDER_MALE ? R.drawable.male : R.drawable.female
//    );
//  }
//
//  @Override
//  public int getItemCount() {
//    return mUsers.length;
//  }
//
//  static class MyViewHolder extends RecyclerView.ViewHolder {
//    TextView fullNameTextView;
//    TextView birthDateTextView;
//    ImageView genderImageView;
//    TextView singleTextView;
//
//    public MyViewHolder(@NonNull View itemView) {
//      super(itemView);
//
//      this.fullNameTextView = itemView.findViewById(R.id.full_name_text_view);
//      this.birthDateTextView = itemView.findViewById(R.id.birth_date_text_view);
//      this.genderImageView = itemView.findViewById(R.id.gender_image_view);
//      this.singleTextView = itemView.findViewById(R.id.single_text_view);
//    }
//  }
//}
