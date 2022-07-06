package com.example.homework_6.ui

import android.graphics.Canvas
import android.view.View
import androidx.annotation.IdRes
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView

inline fun RecyclerView.addSwipeListener(
    swipeDirs: Int,
    @IdRes frontLayerId: Int,
    crossinline onSwipe: (Int) -> Unit,
) = addSwipeListener<RecyclerView.ViewHolder>(
    swipeDirs,
    onDrag = { itemView.findViewById<View>(frontLayerId).translationX = it },
    onSwipe = onSwipe,
)

@Suppress("UNCHECKED_CAST")
inline fun <T : RecyclerView.ViewHolder> RecyclerView.addSwipeListener(
    swipeDirs: Int,
    crossinline onDrag: T.(Float) -> Unit,
    crossinline onSwipe: (Int) -> Unit,
) = ItemTouchHelper(
    object : ItemTouchHelper.SimpleCallback(0, swipeDirs) {
        override fun onChildDraw(
            c: Canvas,
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            dX: Float,
            dY: Float,
            actionState: Int,
            isCurrentlyActive: Boolean,
        ) {
            (viewHolder as? T)?.onDrag(dX)
        }

        override fun onMove(
            recyclerView: RecyclerView,
            viewHolder: RecyclerView.ViewHolder,
            target: RecyclerView.ViewHolder
        ) = false

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            onSwipe(viewHolder.absoluteAdapterPosition)
        }
    }
).also {
    it.attachToRecyclerView(this)
}
