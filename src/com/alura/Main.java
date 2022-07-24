package com.alura;

import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {
//        String url = "https://alura-imdb-api.herokuapp.com/movies";
//        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoIMDB();

        String url = "https://api.nasa.gov/planetary/apod?api_key=LaOLE20MhhnUZ24c0jS9x4hAug7ZckEr6kRDqLeM&start_date=2022-06-12&end_date=2022-06-14";
        ExtratorDeConteudoDaNasa extrator = new ExtratorDeConteudoDaNasa();

        var http = new ClientHttp();
        String json = http.buscaDados(url);

        // exibir e manipular os dados
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        var geradora = new GeradoraDeFigurinhas();
        for (int i = 0; i < 3; i++) {

            Conteudo conteudo = conteudos.get(i);

            InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();
            String nomeDoArquivo = "saida/" + conteudo.getTitulo() + ".png";
            geradora.cria(inputStream, nomeDoArquivo);

            System.out.println(conteudo.getTitulo());
            System.out.println();
        }
    }
}
