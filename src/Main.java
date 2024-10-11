import classes.Categoria;
import classes.Produto;
import classes.Pedido;
import classes.entrega.Entrega;
import classes.entrega.EntregaAPe;
import classes.entrega.EntregaCarro;
import classes.entrega.EntregaDrone;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    // Scanner para leitura de entradas do usuário, configurado para usar o Locale US (para receber o numero quebrado com '.', exemplo: 1.5)
    static Scanner ler = new Scanner(System.in).useLocale(Locale.US);

    // Listas para armazenar categorias e produtos
    private static final List<Categoria> categoriaList = new ArrayList<>();
    private static final List<Produto> produtoList = new ArrayList<>();

    public static void main(String[] args) {
        exibirBanner();// Exibe o banner inicial

        int opcao;
        // Loop principal para exibir o menu e processar opções
        do {
            menuPrincipal();// Exibe o menu principal
            opcao = ler.nextInt();
            ler.nextLine();// Consome a nova linha
            switch (opcao) {
                case 1:
                    // Solicita dados da nova categoria e adiciona à lista
                    Categoria novaCategoria = solicitaDadosCategoria();
                    if (novaCategoria != null) {
                        categoriaList.add(novaCategoria);
                        System.out.println("Categoria adicionada com sucesso!");
                    }
                    break;
                case 2:
                    // Solicita dados do novo produto e adiciona à lista
                    Produto novoProduto = solicitaDadosProduto();
                    if (novoProduto != null) {
                        produtoList.add(novoProduto);
                        System.out.println(" ");
                        System.out.println("Produto adicionado com sucesso!");
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    // Finaliza um pedido, adicionando produtos selecionados
                    finalizarPedido();
                    break;
                case 4:
                    // Exibe todos os produtos cadastrados
                    produtoList.forEach(Produto::imprimir);
                    break;
                case 5:
                    // Inicia o menu de entregas
                    menuEntregas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        ler.close();// Fecha o scanner ao final
    }

    private static void exibirBanner() {
        // Exibe um banner artístico na tela
        System.out.println();
        System.out.println(" ### #######                        #####                                 ");
        System.out.println("  #  #        ####   ####  #####   #     #  ####   ####  #   ##   #      ");
        System.out.println("  #  #       #    # #    #  #   #  #       #    # #    # #  #  #  #      ");
        System.out.println("  #  #####   #    # #    #  #    #  #####  #    # #      # #    # #      ");
        System.out.println("  #  #       #    # #    #  #    #       # #    # #      # ###### #      ");
        System.out.println("  #  #       #    # #    #  #   #  #     # #    # #    # # #    # #      ");
        System.out.println(" ### #        ####   ####  #####    #####   ####   ####  # #    # ######  ");
        System.out.println();
    }

    private static void menuPrincipal() {
        // Exibe o menu principal com opções disponíveis
        System.out.println("\n=== Menu Principal ===");
        System.out.println("1 - 📂 Criar Categoria");
        System.out.println("2 - 🛒 Criar Produto");
        System.out.println("3 - ✅ Finalizar Pedido");
        System.out.println("4 - 📜 Mostrar Cardápio");
        System.out.println("5 - 🚚 IFoodSocial Entregas");
        System.out.println("0 - ❌ Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static Produto solicitaDadosProduto() {
        Categoria c_produto = null;// Variável para armazenar a categoria do produto

        // Lê dados do produto
        System.out.println("Informe o código do produto: ");
        String codigoProduto = ler.nextLine();
        System.out.println("Informe a descrição do produto: ");
        String descricaoProduto = ler.nextLine();
        System.out.println("Informe o preço do produto: ");
        double preco = ler.nextDouble();
        ler.nextLine();// Consome a nova linha

        // Lê o código da categoria para associar ao produto
        System.out.println("Informe o código da categoria: ");
        String codigoCategoria = ler.nextLine();

        // Busca a categoria correspondente
        for (Categoria categoria : categoriaList) {
            if (categoria.getCodigoCategoria().equals(codigoCategoria)) {
                c_produto = categoria;// Associa a categoria encontrada
                break;
            }
        }

        // Verifica se a categoria foi encontrada
        if (c_produto == null) {
            System.out.println("Categoria não encontrada! Produto não adicionado.");
            return null; // Retorna null se a categoria não for encontrada
        }

        return new Produto(codigoProduto, descricaoProduto, preco, c_produto);
    }

    private static Categoria solicitaDadosCategoria() {
        // Lê dados da nova categoria e retorna um objeto Categoria
        System.out.println("Informe o código da categoria: ");
        String codigoCategoria = ler.nextLine();
        System.out.println("Informe a descrição da categoria: ");
        String descricaoCategoria = ler.nextLine();

        return new Categoria(codigoCategoria, descricaoCategoria);
    }

    private static void finalizarPedido() {
        Pedido pedido = new Pedido();// Cria um novo pedido
        int opcaoProduto;

        do {
            System.out.println(" ");
            System.out.println("Escolha um produto para adicionar ao pedido (0 para finalizar):");

            // Exibe a lista de produtos disponíveis
            for (int i = 0; i < produtoList.size(); i++) {
                System.out.println((i + 1) + " - " + produtoList.get(i).getDescricaoProduto());
            }
            System.out.println("0 - Finalizar Pedido");
            System.out.print("Escolha uma opção: ");
            opcaoProduto = ler.nextInt();// Lê a opção do produto
            ler.nextLine();// Consome a nova linha

            // Adiciona o produto ao pedido, se a opção for válida
            if (opcaoProduto > 0 && opcaoProduto <= produtoList.size()) {
                pedido.adicionarProduto(produtoList.get(opcaoProduto - 1));
                System.out.println("Produto adicionado ao pedido.");
            } else if (opcaoProduto != 0) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcaoProduto != 0);// Continua até que o usuário finalize o pedido

        // imprime detalhes do pedido
        pedido.imprimir();
    }

    private static void menuEntregas() {
        Entrega entrega = null;// Variável para armazenar a entrega atual

        while (true) {
            System.out.println(" ");
            System.out.println("\n🌟--- Menu Entregas ---🌟");
            System.out.println("1 - 📦 Cadastrar nova entrega");
            System.out.println("2 - 🛤️ Mover entrega");
            System.out.println("3 - 🗺️ Visualizar mapa");
            System.out.println("4 - 📍 Exibir caminho e distância");
            System.out.println("5 - ✅ Finalizar entrega");
            System.out.println("0 - ❌ Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = ler.nextInt();
            ler.nextLine(); // Consome a nova linha

            switch (opcao) {
                case 1:
                    // Cadastra uma nova entrega
                    entrega = cadastrarEntrega();
                    break;
                case 2:
                    // Move a entrega se uma entrega foi cadastrada
                    if (entrega != null) {
                        moverEntrega(entrega);
                    } else {
                        System.out.println("Nenhuma entrega cadastrada!");
                    }
                    break;
                case 3:
                    // Visualiza o mapa da entrega se uma entrega foi cadastrada
                    if (entrega != null) {
                        entrega.visualizarMapa();
                    } else {
                        System.out.println("Nenhuma entrega cadastrada!");
                    }
                    break;
                case 4:
                    // Imprime o caminho da entrega se uma entrega foi cadastrada
                    if (entrega != null) {
                        entrega.imprimirCaminho();
                    } else {
                        System.out.println("Nenhuma entrega cadastrada!");
                    }
                    break;
                case 5:
                    // Finaliza a entrega se uma entrega foi cadastrada
                    if (entrega != null) {
                        System.out.println("Entrega finalizada.");
                        entrega.imprimirCaminho();
                        return; // Retorna ao menu principal após a entrega
                    } else {
                        System.out.println("Nenhuma entrega cadastrada!");
                    }
                    break;
                case 0:
                    // Sai do menu de entregas
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
    // Metodo para cadastrar uma nova entrega
    private static Entrega cadastrarEntrega() {
        System.out.println("\n--- Cadastrar Entrega ---");
        System.out.print("Informe o nome do entregador: ");
        String nomeEntregador = ler.nextLine();// Lê o nome do entregador

        System.out.println("Escolha o tipo de entrega:");
        System.out.println("1. Entrega por Carro");
        System.out.println("2. Entrega por Drone");
        System.out.println("3. Entrega a Pé");
        System.out.print("Opção: ");
        int tipoEntrega = ler.nextInt();// Lê o tipo de entrega
        ler.nextLine(); // Consome a nova linha

        // Cria a entrega com base no tipo escolhido
        switch (tipoEntrega) {
            case 1:
                System.out.print("Informe o consumo médio do carro (litros por quadra): ");
                double consumoMedio = ler.nextDouble();//Lê dado de consumo de gasolina do carro
                return new EntregaCarro(nomeEntregador, consumoMedio);
            case 2:
                return new EntregaDrone(nomeEntregador);
            case 3:
                return new EntregaAPe(nomeEntregador);
            default:
                System.out.println("Tipo de entrega inválido!");
                return null; // Retorna null se o tipo for inválido
        }
    }

    // Metodo para mover a entrega para uma nova quadra
    private static void moverEntrega(Entrega entrega) {

        // Apresenta as opções de movimento disponíveis para o usuário
        System.out.println("\n--- Movimentar Entrega ---");
        System.out.println("1. Mover ao Norte");
        System.out.println("2. Mover ao Sul");
        System.out.println("3. Mover ao Leste");
        System.out.println("4. Mover ao Oeste");

        // Opção especial para drone
        if (entrega instanceof EntregaDrone) {
            System.out.println("5. Mover diretamente (apenas para drones)");
        }

        // Solicita ao usuário que escolha uma direção para mover a entrega
        System.out.print("Escolha uma direção: ");
        int direcao = ler.nextInt();
        ler.nextLine(); // Consome a nova linha

        // Verifica a direção escolhida e executa a movimentação correspondente
        switch (direcao) {
            case 1: // Movimento para o norte
                System.out.print("Quantas quadras mover ao norte? ");
                int norte = ler.nextInt();
                entrega.moverNorte(norte);
                break;
            case 2: // Movimento para o sul
                System.out.print("Quantas quadras mover ao sul? ");
                int sul = ler.nextInt();
                entrega.moverSul(sul);
                break;
            case 3: // Movimento para o leste
                System.out.print("Quantas quadras mover ao leste? ");
                int leste = ler.nextInt();
                entrega.moverLeste(leste);
                break;
            case 4: // Movimento para o oeste
                System.out.print("Quantas quadras mover ao oeste? ");
                int oeste = ler.nextInt();
                entrega.moverOeste(oeste);
                break;
            case 5: // Movimento direto (opção apenas para drones)
                if (entrega instanceof EntregaDrone) {// verifica se o objeto entrega é realmente uma instância da classe EntregaDrone
                    System.out.print("Informe o destino X: ");
                    int x = ler.nextInt();// Lê a coordenada X do destino
                    System.out.print("Informe o destino Y: ");
                    int y = ler.nextInt();// Lê a coordenada Y do destino

                    // Nesse trecho, o cast é como dizer ao compilador:
                    // “Eu sei que entrega é um EntregaDrone, então me permita chamar o metodo
                    // moverDireto que é específico desta classe”.
                    ((EntregaDrone) entrega).moverDireto(x, y);// Chama o metodo para mover diretamente o drone para as coordenadas fornecidas
                } else {
                    System.out.println("Opção inválida para este tipo de entrega!");
                }
                break;
            default:
                System.out.println("Direção inválida!");
        }
    }

}
