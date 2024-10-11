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

    static Scanner ler = new Scanner(System.in).useLocale(Locale.US);
    private static List<Categoria> categoriaList = new ArrayList<>();
    private static List<Produto> produtoList = new ArrayList<>();
    private static List<Pedido> pedidoList = new ArrayList<>();

    public static void main(String[] args) {
        exibirBanner();

        int opcao;
        do {
            menuPrincipal();
            opcao = ler.nextInt();
            ler.nextLine();
            switch (opcao) {
                case 1:
                    Categoria novaCategoria = solicitaDadosCategoria();
                    if (novaCategoria != null) {
                        categoriaList.add(novaCategoria);
                        System.out.println("Categoria adicionada com sucesso!");
                    }
                    break;
                case 2:
                    Produto novoProduto = solicitaDadosProduto();
                    if (novoProduto != null) {
                        produtoList.add(novoProduto);
                        System.out.println(" ");
                        System.out.println("Produto adicionado com sucesso!");
                        System.out.println(" ");
                    }
                    break;
                case 3:
                    finalizarPedido();
                    break;
                case 4:
                    //categoriaList.forEach(Categoria::imprimir);
                    produtoList.forEach(Produto::imprimir);
                    break;
                case 5:
                    menuEntregas();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 0);

        ler.close();
    }

    private static void exibirBanner() {
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
        Categoria c_produto = null;
        System.out.println("Informe o código do produto: ");
        String codigoProduto = ler.nextLine();
        System.out.println("Informe a descrição do produto: ");
        String descricaoProduto = ler.nextLine();
        System.out.println("Informe o preço do produto: ");
        double preco = ler.nextDouble();
        ler.nextLine();


        System.out.println("Informe o código da categoria: ");
        String codigoCategoria = ler.nextLine();
        for (Categoria categoria : categoriaList) {
            if (categoria.getCodigoCategoria().equals(codigoCategoria)) {
                c_produto = categoria;
                break;
            }
        }

        if (c_produto == null) {
            System.out.println("Categoria não encontrada! Produto não adicionado.");
            return null; // Retorna null se a categoria não for encontrada
        }

        return new Produto(codigoProduto, descricaoProduto, preco, c_produto);
    }

    private static Categoria solicitaDadosCategoria() {
        System.out.println("Informe o código da categoria: ");
        String codigoCategoria = ler.nextLine();
        System.out.println("Informe a descrição da categoria: ");
        String descricaoCategoria = ler.nextLine();
        return new Categoria(codigoCategoria, descricaoCategoria);
    }

    private static void finalizarPedido() {
        Pedido pedido = new Pedido();
        int opcaoProduto;

        do {
            System.out.println(" ");
            System.out.println("Escolha um produto para adicionar ao pedido (0 para finalizar):");
            for (int i = 0; i < produtoList.size(); i++) {
                System.out.println((i + 1) + " - " + produtoList.get(i).getDescricaoProduto());
            }
            System.out.println("0 - Finalizar Pedido");
            System.out.print("Escolha uma opção: ");
            opcaoProduto = ler.nextInt();
            ler.nextLine();

            if (opcaoProduto > 0 && opcaoProduto <= produtoList.size()) {
                pedido.adicionarProduto(produtoList.get(opcaoProduto - 1));
                System.out.println("Produto adicionado ao pedido.");
            } else if (opcaoProduto != 0) {
                System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcaoProduto != 0);

        pedidoList.add(pedido);
        pedido.imprimir();
    }

    private static void menuEntregas() {
        Entrega entrega = null;

        while (true) {
            System.out.printf(" ");
            System.out.println("\n🌟--- Menu Entregas ---🌟");
            System.out.println("1 - 📦 Cadastrar nova entrega");
            System.out.println("2 - 🛤️ Mover entrega");
            System.out.println("3 - 🗺️ Visualizar mapa");
            System.out.println("4 - 📍 Exibir caminho e distância");
            System.out.println("5 - ✅ Finalizar entrega");
            System.out.println("0 - ❌ Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = ler.nextInt();
            ler.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    entrega = cadastrarEntrega(ler);
                    break;
                case 2:
                    if (entrega != null) {
                        moverEntrega(ler, entrega);
                    } else {
                        System.out.println("Nenhuma entrega cadastrada!");
                    }
                    break;
                case 3:
                    if (entrega != null) {
                        entrega.visualizarMapa();
                    } else {
                        System.out.println("Nenhuma entrega cadastrada!");
                    }
                    break;
                case 4:
                    if (entrega != null) {
                        entrega.imprimirCaminho();
                    } else {
                        System.out.println("Nenhuma entrega cadastrada!");
                    }
                    break;
                case 5:
                    if (entrega != null) {
                        System.out.println("Entrega finalizada.");
                        entrega.imprimirCaminho();
                        return; // Finaliza o programa após a entrega
                    } else {
                        System.out.println("Nenhuma entrega cadastrada!");
                    }
                    break;
                case 0:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    private static Entrega cadastrarEntrega(Scanner scanner) {
        System.out.println("\n--- Cadastrar Entrega ---");
        System.out.print("Informe o nome do entregador: ");
        String nomeEntregador = scanner.nextLine();

        System.out.println("Escolha o tipo de entrega:");
        System.out.println("1. Entrega por Carro");
        System.out.println("2. Entrega por Drone");
        System.out.println("3. Entrega a Pé");
        System.out.print("Opção: ");
        int tipoEntrega = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (tipoEntrega) {
            case 1:
                System.out.print("Informe o consumo médio do carro (litros por quadra): ");
                double consumoMedio = scanner.nextDouble();
                return new EntregaCarro(nomeEntregador, consumoMedio);
            case 2:
                return new EntregaDrone(nomeEntregador);
            case 3:
                return new EntregaAPe(nomeEntregador);
            default:
                System.out.println("Tipo de entrega inválido!");
                return null;
        }
    }

    private static void moverEntrega(Scanner scanner, Entrega entrega) {
        System.out.println("\n--- Movimentar Entrega ---");
        System.out.println("1. Mover ao Norte");
        System.out.println("2. Mover ao Sul");
        System.out.println("3. Mover ao Leste");
        System.out.println("4. Mover ao Oeste");

        // Opção especial para drone
        if (entrega instanceof EntregaDrone) {
            System.out.println("5. Mover diretamente (apenas para drones)");
        }

        System.out.print("Escolha uma direção: ");
        int direcao = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        switch (direcao) {
            case 1:
                System.out.print("Quantas quadras mover ao norte? ");
                int norte = scanner.nextInt();
                entrega.moverNorte(norte);
                break;
            case 2:
                System.out.print("Quantas quadras mover ao sul? ");
                int sul = scanner.nextInt();
                entrega.moverSul(sul);
                break;
            case 3:
                System.out.print("Quantas quadras mover ao leste? ");
                int leste = scanner.nextInt();
                entrega.moverLeste(leste);
                break;
            case 4:
                System.out.print("Quantas quadras mover ao oeste? ");
                int oeste = scanner.nextInt();
                entrega.moverOeste(oeste);
                break;
            case 5:
                if (entrega instanceof EntregaDrone) {
                    System.out.print("Informe o destino X: ");
                    int x = scanner.nextInt();
                    System.out.print("Informe o destino Y: ");
                    int y = scanner.nextInt();
                    ((EntregaDrone) entrega).moverDireto(x, y);
                } else {
                    System.out.println("Opção inválida para este tipo de entrega!");
                }
                break;
            default:
                System.out.println("Direção inválida!");
        }
    }

}
