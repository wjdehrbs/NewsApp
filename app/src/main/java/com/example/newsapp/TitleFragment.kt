
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.newsapp.databinding.FragmentTitleBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapp.NewsItem


class TitleFragment(private val itemList: List<NewsItem>) :
    RecyclerView.Adapter<TitleFragment.TitleFragmentHolder>() {

    private var itemClickListener: OnItemClickListener? = null


    interface OnItemClickListener {
        fun onItemClick(item: NewsItem)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        itemClickListener = listener
    }
    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleFragmentHolder {
        val binding =
            FragmentTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TitleFragmentHolder(binding)
    }

    override fun onBindViewHolder(holder: TitleFragmentHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)


        holder.itemView.setOnClickListener {
            itemClickListener?.onItemClick(item)
        }
    }

    class TitleFragmentHolder(private val binding: FragmentTitleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: NewsItem) {
            binding.newsHeadLine.text = item.title
            binding.newsImg1.setBackgroundResource(item.imagenews)
        }
    }
}