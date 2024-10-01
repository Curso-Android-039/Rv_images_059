package com.example.rv_images_059

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rv_images_059.databinding.ItemListDataBinding

class ItemAdapter

    ( // paso 3 declarar constructor del item adapter
            // paso 4 heredar Rv implementar inner class

            private val  itemList : List<Item>,
            private val contex : Context,
            private val listener : SendItem ): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>()






{







    //paso crear inner class   referencia al diseño del Rv  1.1

    inner class ItemViewHolder(binding: ItemListDataBinding) :
        RecyclerView.ViewHolder(binding.getRoot()), View.OnClickListener {


        // inicializar elementos de la entrada del Rv
        val imageView: ImageView
        val textView: TextView

        init {
            imageView = binding.ivItem
            textView = binding.textView
            itemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
        listener.sendItem(itemList[layoutPosition])
        }


     }

    // paso 2 crear interfaz que implementaremos en el primer fragmento
    // para escuchar cuando alguien selecciona un elemento del Rv
     interface SendItem{
         fun sendItem(item: Item?)
     }

    // paso 4 inflar la vista del item_list_data  con la clase binding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        //infla vista del item_list

        val binding = ItemListDataBinding.inflate(LayoutInflater.from(parent.context),
            parent, false)
        return ItemViewHolder(binding)
    }


    // paso 5 lleva la cuenta
    override fun getItemCount(): Int {
   return  itemList.size
    }



    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = itemList[position]
        // cargar la descripcion al textview

        holder.textView.text= item.itemDescription

        // carga la imagen.
        Glide.with(contex).load(item.urlImage).centerCrop().override(300,300)
            .into(holder.imageView)

    }


}