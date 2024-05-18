// Generated by view binder compiler. Do not edit!
package com.example.myapplication.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.myapplication.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityMainBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ImageView burgerMenu;

  @NonNull
  public final AppCompatButton dogsButton;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final RelativeLayout loadingScreen;

  @NonNull
  public final ConstraintLayout main;

  @NonNull
  public final AppCompatButton randomButton;

  @NonNull
  public final RecyclerView recyclerDogs;

  @NonNull
  public final ImageView textView;

  @NonNull
  public final AppCompatButton usButton;

  private ActivityMainBinding(@NonNull ConstraintLayout rootView, @NonNull ImageView burgerMenu,
      @NonNull AppCompatButton dogsButton, @NonNull LinearLayout linearLayout,
      @NonNull RelativeLayout loadingScreen, @NonNull ConstraintLayout main,
      @NonNull AppCompatButton randomButton, @NonNull RecyclerView recyclerDogs,
      @NonNull ImageView textView, @NonNull AppCompatButton usButton) {
    this.rootView = rootView;
    this.burgerMenu = burgerMenu;
    this.dogsButton = dogsButton;
    this.linearLayout = linearLayout;
    this.loadingScreen = loadingScreen;
    this.main = main;
    this.randomButton = randomButton;
    this.recyclerDogs = recyclerDogs;
    this.textView = textView;
    this.usButton = usButton;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityMainBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_main, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityMainBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.burger_menu;
      ImageView burgerMenu = ViewBindings.findChildViewById(rootView, id);
      if (burgerMenu == null) {
        break missingId;
      }

      id = R.id.dogs_button;
      AppCompatButton dogsButton = ViewBindings.findChildViewById(rootView, id);
      if (dogsButton == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.loading_screen;
      RelativeLayout loadingScreen = ViewBindings.findChildViewById(rootView, id);
      if (loadingScreen == null) {
        break missingId;
      }

      ConstraintLayout main = (ConstraintLayout) rootView;

      id = R.id.random_button;
      AppCompatButton randomButton = ViewBindings.findChildViewById(rootView, id);
      if (randomButton == null) {
        break missingId;
      }

      id = R.id.recycler_dogs;
      RecyclerView recyclerDogs = ViewBindings.findChildViewById(rootView, id);
      if (recyclerDogs == null) {
        break missingId;
      }

      id = R.id.textView;
      ImageView textView = ViewBindings.findChildViewById(rootView, id);
      if (textView == null) {
        break missingId;
      }

      id = R.id.us_button;
      AppCompatButton usButton = ViewBindings.findChildViewById(rootView, id);
      if (usButton == null) {
        break missingId;
      }

      return new ActivityMainBinding((ConstraintLayout) rootView, burgerMenu, dogsButton,
          linearLayout, loadingScreen, main, randomButton, recyclerDogs, textView, usButton);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
