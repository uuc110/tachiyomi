package eu.kanade.tachiyomi.ui.catalogue.filter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import eu.davidea.flexibleadapter.FlexibleAdapter
import eu.davidea.flexibleadapter.items.AbstractExpandableHeaderItem
import eu.davidea.flexibleadapter.items.ISectionable
import eu.davidea.viewholders.ExpandableViewHolder
import eu.kanade.tachiyomi.R
import eu.kanade.tachiyomi.source.model.Filter
import eu.kanade.tachiyomi.util.setVectorCompat

class GroupItem(val filter: Filter.Group<*>) : AbstractExpandableHeaderItem<GroupItem.Holder, ISectionable<*, *>>() {

    override fun getLayoutRes(): Int {
        return R.layout.navigation_view_group
    }

    override fun createViewHolder(adapter: FlexibleAdapter<*>, inflater: LayoutInflater, parent: ViewGroup): Holder {
        return Holder(inflater.inflate(layoutRes, parent, false), adapter)
    }

    override fun bindViewHolder(adapter: FlexibleAdapter<*>, holder: Holder, position: Int, payloads: List<Any?>?) {
        holder.title.text = filter.name

        holder.icon.setVectorCompat(if (isExpanded)
            R.drawable.ic_expand_more_white_24dp
        else
            R.drawable.ic_chevron_right_white_24dp)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        return filter == (other as GroupItem).filter
    }

    override fun hashCode(): Int {
        return filter.hashCode()
    }

    open class Holder(view: View, adapter: FlexibleAdapter<*>) : ExpandableViewHolder(view, adapter, true) {

        val title: TextView = itemView.findViewById(R.id.title)
        val icon: ImageView = itemView.findViewById(R.id.expand_icon)

        override fun shouldNotifyParentOnClick(): Boolean {
            return true
        }
    }
}