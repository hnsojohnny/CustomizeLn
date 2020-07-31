package com.customizeln

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.TypeEvaluator
import android.graphics.PointF
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.customizeln.view.*

class AnimViewDetailActivity : AppCompatActivity() {

    private var index: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        index = intent.action?.toInt()!!
        setView()
    }

    private fun setView(){
        val view = when(index){
            0 -> CirclerView(this)
            1 -> PointView(this)
            2 -> AnimTurnUpImgView(this)
            3 -> StringView(this)
            else -> null
        }
        view?.apply {
            setContentView(this)
        }
        when (index){
            0 -> circle(view as CirclerView)
            1 -> point(view as PointView)
            2 -> turnImg(view as AnimTurnUpImgView)
            3 -> stringTurn(view as StringView)
        }
    }

    private fun circle(circlerView: CirclerView){
        val animator = ObjectAnimator.ofFloat(circlerView, "raduis", 120f.dp2px)
        animator.duration = 1000
        animator.start()
    }

    private fun point(pointView: PointView){
        val evaluator =
            TypeEvaluator<PointF> { fraction, startValue, endValue ->
                var currentX = startValue.x + (endValue.x - startValue.x) * fraction
                var currentY = startValue.y + (endValue.y - startValue.y) * fraction
                PointF(currentX, currentY)
             }
        val animator = ObjectAnimator.ofObject(pointView, "pointF", evaluator, PointF(200f.dp2px, 200f.dp2px))
        animator.duration = 1000
        animator.start()
    }

    private fun turnImg(view: AnimTurnUpImgView){
        val animator1 = ObjectAnimator.ofFloat(view, "bottomFlip", 40f)
        val animator2 = ObjectAnimator.ofFloat(view, "flipRotation", 360f)
        val animator3 = ObjectAnimator.ofFloat(view, "topFlip", -40f)
        AnimatorSet().run {
            playSequentially(animator1, animator2, animator3)
            duration = 2000
            start()
        }
    }

    private fun stringTurn(view: StringView){
        val evaluator = TypeEvaluator<String>{ fraction, startValue, endValue ->
            val startIndex = strs.indexOf(startValue)
            val endIndex = strs.indexOf(endValue)
            val currentIndex = startIndex + (endIndex - startIndex)*fraction
            strs[currentIndex.toInt()]
        }
        val animator = ObjectAnimator.ofObject(view, "m", evaluator, "z")
        animator.interpolator = null
        animator.duration = 3000
        animator.start()
    }
}