package io.github.kongpf8848.ndk.demo

import android.graphics.Rect
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.github.kongpf8848.animation.views.StickerRecyclerView
import com.kongpf.commonhelper.ScreenHelper
import io.github.kongpf8848.ndk.demo.adapter.StickerAdapter
import io.github.kongpf8848.ndk.demo.bean.StickerItem
import kotlinx.android.synthetic.main.activity_tgs.*

class TgsActivity : AppCompatActivity() {

    private val datas = listOf(
            StickerItem(1, "\u2764\ufe0f", "2_1901206392136531994.tgs"),
            StickerItem(2, "\ud83d\udc4d", "2_1901206392136531995.tgs"),
            StickerItem(3, "\ud83d\ude18", "2_1901206392136531997.tgs"),
            StickerItem(4, "\ud83e\udd2c", "2_1901206392136531999.tgs"),
            StickerItem(5, "\ud83c\udf37", "2_1901206392136532002.tgs"),
            StickerItem(6, "\ud83e\udda0", "2_1901206392136532003.tgs"),
            StickerItem(7, "\ud83d\ude2f", "2_1901206392136532005.tgs"),
            StickerItem(8, "\ud83d\ude02", "2_1901206392136532006.tgs"),
            StickerItem(9, "\ud83e\udd14", "2_1901206392136532007.tgs"),
            StickerItem(10, "\ud83d\ude45", "2_1901206392136532008.tgs"),
            StickerItem(11, "\ud83e\udd73", "2_1901206392136532009.tgs"),
            StickerItem(12, "\ud83d\ude28", "2_1901206392136532010.tgs"),
            StickerItem(13, "\ud83d\ude15", "2_1901206392136532011.tgs"),
            StickerItem(14, "\u23f3", "2_1901206392136532012.tgs"),
            StickerItem(15, "\ud83d\udc4b", "2_1901206392136532014.tgs"),
            StickerItem(16, "\ud83d\udc48", "2_1901206392136532015.tgs"),
            StickerItem(17, "\ud83d\ude34", "2_1901206392136532016.tgs"),
            StickerItem(18, "\ud83d\ude09", "2_1901206392136532017.tgs"),
            StickerItem(19, "\ud83d\ude29", "2_1901206392136532018.tgs"),
            StickerItem(20, "\u2753", "2_1901206392136532019.tgs")
    )

    private val onItemClickListener = object:StickerRecyclerView.OnItemClickListener{
        override fun onItemClick(view: View, position: Int) {
            Toast.makeText(this@TgsActivity, "click:$position", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tgs)
        recyclerview.apply {
            layoutManager = GridLayoutManager(this@TgsActivity, 5)
            addItemDecoration(object : ItemDecoration() {
                override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
                    super.getItemOffsets(outRect, view, parent, state)
                    outRect.top = ScreenHelper.dp2px(applicationContext, 10f)
                    outRect.bottom = ScreenHelper.dp2px(applicationContext, 10f)
                }
            })
            setOnItemClickListener(onItemClickListener)
            adapter = StickerAdapter(this@TgsActivity,datas)
        }

    }



}