package classes;

import java.text.NumberFormat;

// Classe que representa um produto com codigo, descricao, preco e uma categoria associada.
public class Produto {

    private String codigoProduto;
    private String descricaoProduto;
    private String preco;
    private Categoria categoria;// Cada produto pertence a uma categoria, representando um tipo ou grupo ao qual ele se encaixa (ex: Eletronicos, Vestuario).

    // Objeto para formatar o preco como moeda local.
    NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    // Construtor que instancia um produto com valores fornecidos para codigo, descricao, preco e categoria.
    public Produto(
                   String codigoProduto,
                   String descricaoProduto,
                   Double preco, Categoria categoria) {

        this.codigoProduto = codigoProduto;
        this.descricaoProduto = descricaoProduto;
        this.preco = currencyFormat.format(preco);
        this.categoria = categoria;
    }

    // Metodo setter para atualizar a categoria do produto.
    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }

    // Metodo getter para obter a categoria do produto.
    public Categoria getCategoria(){
        return categoria;
    }

    // Metodo getter para obter o codigo do produto.
    public String getCodigoProduto() {
        return codigoProduto;
    }

    // Metodo setter para atualizar o codigo do produto.
    public void setCodigoProduto(String codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    // Metodo getter para obter a descricao do produto.
    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    // Metodo setter para atualizar a descricao do produto.
    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    // Metodo getter para obter o preco formatado do produto.
    public String getPreco() {
        return preco;
    }

    // Metodo setter para atualizar o preco, formatando-o como moeda local.
    public void setPreco(Double preco) {
        this.preco = currencyFormat.format(preco);
    }

    // Metodo toString que retorna uma representacao em string do produto, incluindo sua categoria.
    @Override // Sobrescreve o metodo toString() da superclasse Object.
    public String toString() {
        return "Produto {\n" +
                "\tcodigo do produto: '" + codigoProduto + '\'' +
                ",\n\tdescricao do produto: '" + descricaoProduto + '\'' +
                ",\n\tpreco: " + preco +
                ",\n " + categoria +
                "\n}";
    }

    // Metodo que imprime os detalhes do produto, chamando o metodo toString() para formatacao.
    public void imprimir() {
        String produtoStr = this.toString();

        System.out.println(" ");
        System.out.println("============================================");
        System.out.println(produtoStr);
        System.out.println("============================================");
        System.out.println(" ");
    }

}
