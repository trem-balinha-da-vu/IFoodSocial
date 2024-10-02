package classes;

import java.util.List;
import java.util.Locale;
import java.text.NumberFormat;

public class Produto {

    private String codigoProduto;
    private String descricaoProduto;
    private String preco;
    private Categoria categoria;

    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    public Produto(
                   String codigoProduto,
                   String descricaoProduto,
                   Double preco, Categoria categoria) {

        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.preco = currencyFormat.format(preco);
        this.categoria = categoria;
    }

    public Produto() {
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public String getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = currencyFormat.format(preco);
    }

    @Override
    public String toString() {
        return "Produto {\n" +
                "\tcodigo do produto: '" + codigoProduto + '\'' +
                ",\n\tdescricao do produto: '" + descricaoProduto + '\'' +
                ",\n\tpreco: " + preco +
                ",\n " + categoria +
                "\n}";
    }

    public void imprimir() {
        String produtoStr = this.toString();

        System.out.println(" ");
        System.out.println("============================================");
        System.out.println(produtoStr);
        System.out.println("============================================");
        System.out.println(" ");
    }

}
