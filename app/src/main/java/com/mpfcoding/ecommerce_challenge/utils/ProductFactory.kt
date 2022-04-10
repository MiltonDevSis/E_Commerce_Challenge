package com.mpfcoding.ecommerce_challenge.utils

import com.mpfcoding.ecommerce_challenge.model.Product

object ProductFactory {
    fun createProductFactory(): List<Product>{
        return listOf(
            Product(
                "Pear",
                "https://www.quitandatomio.com.br/upload/335572588-pera-park-caracteristicas-nome-cientifico-beneficios.jpg",
                5.63,
                true),
            Product(
                "Apple",
                "https://i1.wp.com/files.agro20.com.br/uploads/2020/02/Ma%C3%A7%C3%A3-fuji-2.jpg?resize=600%2C338&ssl=1",
                7.89,
                false),
            Product(
                "Pineapple",
                "https://vejasp.abril.com.br/wp-content/uploads/2016/12/abacaxi-nutricao.jpg?quality=70&strip=info&resize=680,453",
                5.53,
                false),
            Product(
                "Mango",
                "https://s2.glbimg.com/v5GnepzRso4lgGEHucF6rch4pOM=/e.glbimg.com/og/ed/f/original/2014/10/29/cc_manga_05.jpg",
                4.45,
                true),
            Product(
                "Grape",
                "https://www.peterpaiva.com.br/wp-content/uploads/2014/11/uvas-ROJAS-450x299.jpg",
                9.35,
                true),
            Product(
                "Banana",
                "https://www.bernardaoemcasa.com.br/media/catalog/product/cache/1/image/500x500/9df78eab33525d08d6e5fb8d27136e95/c/c/cc143e3f49d34923320905e1a3837768.jpg",
                2.39,
                true),
            Product(
                "Kiwi",
                "https://saude.abril.com.br/wp-content/uploads/2016/10/um-kiwi-por-semana-pelo-seu-coracao.jpg?quality=85&strip=info&resize=680,453",
                4.87,
                false)
        )
    }
}