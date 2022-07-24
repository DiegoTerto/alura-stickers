package com.alura;

import java.util.List;

public interface ExtratorDeConteudo {

    default List<Conteudo> extraiConteudos(String json) {
        return null;
    }
}
