package com.ptm.test

import android.content.ClipData
import android.content.ClipDescription
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.DragEvent
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TableLayout
import android.widget.Toast


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dragView1 = findViewById<View>(R.id.dragView1)
        val dragView2 = findViewById<View>(R.id.dragView2)
        val dragView3 = findViewById<View>(R.id.dragView3)


        val container = findViewById<View>(R.id.container)
        val board = findViewById<View>(R.id.board)
        val row1 = findViewById<View>(R.id.one_row)
        val row2 = findViewById<View>(R.id.two_row)
        val row3 = findViewById<View>(R.id.three_row)
        val row4 = findViewById<View>(R.id.four_row)
        val row5 = findViewById<View>(R.id.five_row)
        val row6 = findViewById<View>(R.id.six_row)

        container.setOnDragListener(dragListener)
        board.setOnDragListener(dragListener)
        row1.setOnDragListener(dragListener)
        row2.setOnDragListener(dragListener)
        row3.setOnDragListener(dragListener)
        row4.setOnDragListener(dragListener)
        row5.setOnDragListener(dragListener)
        row6.setOnDragListener(dragListener)



        dragView1.setOnLongClickListener {
            val clipText = "Ustawiono blok 1"
            val item = ClipData.Item(clipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val data = ClipData(clipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }
        dragView2.setOnLongClickListener {
            val ClipText = "Ustawiono blok 2"
            val item = ClipData.Item(ClipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val Data = ClipData(ClipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(Data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }
        dragView3.setOnLongClickListener {
            val ClipText = "Ustawiono blok 3"
            val item = ClipData.Item(ClipText)
            val mimeTypes = arrayOf(ClipDescription.MIMETYPE_TEXT_PLAIN)
            val Data = ClipData(ClipText, mimeTypes, item)

            val dragShadowBuilder = View.DragShadowBuilder(it)
            it.startDragAndDrop(Data, dragShadowBuilder, it, 0)

            it.visibility = View.INVISIBLE
            true
        }
    }

    val dragListener = View.OnDragListener { view, event ->
        when(event.action) {
            DragEvent.ACTION_DRAG_STARTED -> {
                event.clipDescription.hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)
            }
            DragEvent.ACTION_DRAG_ENTERED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DRAG_LOCATION -> true
            DragEvent.ACTION_DRAG_EXITED -> {
                view.invalidate()
                true
            }
            DragEvent.ACTION_DROP -> {
                val item = event.clipData.getItemAt(0)
                val dragData = item.text
                Toast.makeText(this, dragData, Toast.LENGTH_SHORT).show()

                view.invalidate()

                val v = event.localState as View
                val owner = v.parent as ViewGroup
                owner.removeView(v)
                val destination = view as LinearLayout
                destination.addView(v)
                v.visibility = View.VISIBLE
                true
            }
            DragEvent.ACTION_DRAG_ENDED -> {
                view.invalidate()
                true
            }
            else -> false
        }

    }
}