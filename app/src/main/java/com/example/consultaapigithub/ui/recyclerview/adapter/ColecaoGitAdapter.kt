package com.example.consultaapigithub.ui.recyclerview.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.consultaapigithub.databinding.DadosgitItemBinding
import com.example.consultaapigithub.model.ColecaoGit

class ColecaoGitAdapter(
    private val listColecaoGit: List<ColecaoGit>) :
    RecyclerView.Adapter<ColecaoGitAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        val view = LayoutInflater.from(context).inflate(R.layout.dadosgit_item, parent, false)
//        return ViewHolder(view)
        val binding = DadosgitItemBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            bind(listColecaoGit[position])
        }
    }

    override fun getItemCount(): Int = listColecaoGit.size

    class ViewHolder(val binding: DadosgitItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(colecaoGit: ColecaoGit) {
            binding.apply {
                colecaoGit.apply {
                    nomeRepositorioView.text = nomeRepositorio
                    estrelasView.text = qtdeEstrelas
                    bifurcacoesView.text = qtdeBifurcacoes

                    autorView.text = usuario.login
                    com.squareup.picasso.Picasso.get()
                        .load(usuario.avatar_url)
                        .placeholder(com.example.consultaapigithub.R.drawable.ic_launcher_foreground)
                        .into(fotoAutorView)
                }
//                with(repositorioGit) {
//                    nomeRepositorioView.text = nomeRepositorio
//                    estrelasView.text = qtdeEstrelas
//                    bifurcacoesView.text = qtdeBifurcacoes
//
//                    autorView.text = usuario.login
//                    com.squareup.picasso.Picasso.get()
//                        .load(usuario.avatar_url)
//                        .placeholder(com.example.consultaapigithub.R.drawable.ic_launcher_foreground)
//                        .into(fotoAutorView)
//                }
            }
        }
    }
}
