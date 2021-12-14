package com.example.fragmenttest


import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fragmenthw.R

class Fragment0 : Fragment(R.layout.fragment_0) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_0,null)
        return view
    }

    override fun onResume() {
        super.onResume()
        Log.d("ani","onResume")

        val image = view?.findViewById<ImageView>(R.id.image)

        if (image==null){
            Log.d("ani","isNull!!!!!!!!!!!!!!!!!!!!!!!!!!")
            return
        }

        Log.d("ani","Not Null!!!")

        //image.setBackgroundColor(Color.BLUE)
        image.setImageResource(R.drawable.animation)

        val ani : AnimationDrawable = image.drawable as AnimationDrawable
        ani.start()

        if (!ani.isRunning){
            Log.d("ani","Not running!!!!!!!!!")
        }
        else{
            Log.d("ani","is running!!!!!!!!!")
        }
    }

//    @SuppressLint("ObjectAnimatorBinding")
//    override fun onResume() {
//        super.onResume()
//        val view = layoutInflater.inflate(R.layout.fragment_0,null)
//        val image = view.findViewById<ImageView>(R.id.image)
//        if (image==null) {
//            Log.d("ani", "nnnnnnnnnnnull")
//            return
//        }
//        ObjectAnimator.ofFloat(image, "translationX", 800f).setDuration(10000).start()
//    }
}