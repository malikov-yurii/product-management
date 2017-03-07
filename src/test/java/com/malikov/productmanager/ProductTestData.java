package com.malikov.productmanager;


import com.malikov.productmanager.matcher.ModelMatcher;
import com.malikov.productmanager.model.Product;

import java.util.Objects;

public class ProductTestData {

    public static final Product SHELLAC_MANETTI = new Product(1, "Shellac", "Manetti", 235, "Varnish for protecting imitation gold leaf gilding");
    public static final Product POTAL_NAZIONALE = new Product(2, "Gold leaf imitation", "Nazionale", 385, "100 leaves of gold leaf imitation");
    public static final Product FERRARIO_ROZOVYJ = new Product(3, "Alcohol gilding glue", "Ferrario", 315, "Glue for gold leaf imitation");
    public static final Product BITUM_DIVOLO = new Product(4, "Bitumen Wax", "Divolo", 570, "Wax which may be used as patina for gilded surfaces");


    public static final ModelMatcher<Product> MATCHER = ModelMatcher.of(Product.class,
            (expected, actual) -> expected == actual ||
                    (Objects.equals(expected.getId(), actual.getId())
                            && Objects.equals(expected.getName(), actual.getName())
                            && Objects.equals(expected.getProducer(), actual.getProducer())
                            && Objects.equals(expected.getPrice(), actual.getPrice())
                            && Objects.equals(expected.getDescription(), actual.getDescription())
                    )
    );
}
