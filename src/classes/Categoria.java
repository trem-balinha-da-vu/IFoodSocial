package classes;

import java.util.List;

public class Categoria {

    private String codigoCategoria;
    private String descricaoCategoria;

    public Categoria(String codigoCategoria, String descricaoCategoria) {
        this.codigoCategoria = codigoCategoria;
        this.descricaoCategoria = descricaoCategoria;
    }

    public Categoria() {

    }

    public String getCodigoCategoria() {
        return codigoCategoria;
    }

    public void setCodigoCategoria(String codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }

    @Override
    public String toString() {
        return " Categoria {\n" +
                "\tcodigo da categoria: '" + codigoCategoria + '\'' +
                ",\n\tdescricao da categoria: '" + descricaoCategoria + '\'' +
                "\n\t}";
    }

    public void imprimir() {
        String categoriaStr = this.toString();

        System.out.println(" ");
        System.out.println("============================================");
        System.out.println(categoriaStr);
        System.out.println("============================================");
        System.out.println(" ");
    }

}
