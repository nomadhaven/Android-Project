package com.example.mydocument
import android.content.Context
import android.graphics.BitmapFactory
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.io.File


class CustomAdapter(private val context:Context, private val dataList: ArrayList<SaveInfoData>)
    :RecyclerView.Adapter<CustomAdapter.ItemViewHolder>()
{
    //RecyclerView에 binding 해줄 Adapter를 연결시킨다.

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.view_item_layout,parent, false)
        return ItemViewHolder(view)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(dataList[position], context)
        //recycleView에 있는 각각의 아이템과 아이템의 위치
    }

    override fun getItemCount(): Int {
        return dataList.size
    }


 inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    private val RcSeq = itemView.findViewById<TextView>(R.id.RcSeq)
    private val RcimageView = itemView.findViewById<ImageView>(R.id.RcimageView)
    private val RcLocation = itemView.findViewById<TextView>(R.id.RcLocation)
    private val RcDate = itemView.findViewById<TextView>(R.id.RcDate)
    private val RcContent = itemView.findViewById<TextView>(R.id.rcContent)


    //data -> resource (binding)
    fun bind(dataVo: SaveInfoData,context: Context){

        //사진 처리
        if (dataVo.imagePath != "") {
            val resourceId =
                context.resources.getIdentifier(dataVo.imagePath, "drawable", context.packageName)

            if (resourceId > 0) {
                RcimageView.setImageResource(resourceId)
            } else {
                // userPhoto.setImageResource(R.mipmap.ic_launcher_round)
                // Glide.with(itemView).load(dataVo.photo).into(userPhoto)
                Log.d("","~~~~~~~~~~~~~~~~~~~~~ 들어옴")

                val file: File = File(dataVo.imagePath)
                val bExist = file.exists()
                if (bExist) {
                    Log.d("","이미지 파일 있음")
                    val myBitmap = BitmapFactory.decodeFile(dataVo.imagePath)
                    RcimageView.setImageBitmap(myBitmap)
                }else{
                    Log.d("","${dataVo.imagePath} 이미지 파일 없음")
                }
            }
        } else {
            RcimageView.setImageResource(R.mipmap.ic_launcher_round)
        }

        //TextView 데이터 세팅 작업
        RcSeq.text = dataVo.seq.toString()
        RcLocation.text =dataVo.location
        RcDate.text = dataVo.date
        RcContent.text =dataVo.content

        // 클릭시에
        itemView.setOnClickListener {
            println(dataVo.content)

            /*Intent(context, ProfileDetailActivity::class.java).apply {
                putExtra("data", dataVo)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) // 새로운 태스크를 생성하여 그 태스크안에 엑티비티를 추가하게 됩니다.
            }.run { context.startActivity(this) }*/
        }
    }


    }

}
