package classes;

public class Categoria {

    private String codigoCategoria;
    private String descricaoCategoria;

    // Construtor que instancia uma nova categoria com atributos a partir dos valores fornecidos.
    public Categoria(String codigoCategoria, String descricaoCategoria) {
        this.codigoCategoria = codigoCategoria;
        this.descricaoCategoria = descricaoCategoria;
    }

    // Metodo getter para obter o código da categoria.
    public String getCodigoCategoria() {
        return codigoCategoria;
    }

    // Metodo setter para atualizar o código da categoria.
    public void setCodigoCategoria(String codigoCategoria) {
        this.codigoCategoria = codigoCategoria;
    }

    // Metodo getter para obter a descrição da categoria.
    public String getDescricaoCategoria() {
        return descricaoCategoria;
    }

    // Metodo setter para atualizar a descrição da categoria.
    public void setDescricaoCategoria(String descricaoCategoria) {
        this.descricaoCategoria = descricaoCategoria;
    }


    // Metodo toString que retorna uma representação em String da categoria.
    @Override // Indica que este metodo sobrescreve um metodo da superclasse (Object).
    public String toString() {
        return " Categoria {\n" +
                "\tcodigo da categoria: '" + codigoCategoria + '\'' +
                ",\n\tdescricao da categoria: '" + descricaoCategoria + '\'' +
                "\n\t}";
    }

    // Metodo que imprime os detalhes da categoria de forma formatada.
    public void imprimir() {
        String categoriaStr = this.toString(); // Chama o metodo toString() para obter a representação da categoria.

        System.out.println(" ");
        System.out.println("============================================");
        System.out.println(categoriaStr);
        System.out.println("============================================");
        System.out.println(" ");
    }

}
