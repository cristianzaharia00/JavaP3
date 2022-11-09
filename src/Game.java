import java.util.Arrays;
import java.util.Scanner;

public class Game {
    Board board = new Board();
    int nop; // Number Of Players ..
    int nor; // Number of Rounds ..
    Players[] players;

    String[] pawn_shapes = {"battleship", "top hat", "penguin", "cat", "sack of money", "iron", "train", "cannon"}; // 8
    Integer[] taken_shapes = {0, 0, 0, 0, 0, 0, 0, 0};
    int hm_pawns = 8;

    String[] colours = {"blue", "red", "green", "yellow", "purple", "black", "white", "pink"}; // 8
    Integer[] taken_colours = {0, 0, 0, 0, 0, 0, 0, 0};
    int hm_colours = 8;

    public Game(String[] args) {
        nop = Integer.parseInt(args[0]);
        nor = Integer.parseInt(args[1]);
        players = new Players[nop];

        System.out.println("Player' Selection! \n");
        for (int i=0; i<nop; i++) {

            System.out.print("Player " + i + " name: ");
            Scanner in = new Scanner(System.in);

            //Choosing player's name
            String name = in.nextLine();

            //Choosing player's colour
            int choice = 0;
            String colour = null;

            while (choice == 0) {
                System.out.print("Choose your colour from the list (");
                for (int j=0; j<hm_colours; j++)
                    if (taken_colours[j] == 0)
                        System.out.print(colours[j] + ", ");
                System.out.print("): ");
                colour = in.nextLine().toLowerCase();

                if (Arrays.asList(colours).contains(colour) && taken_colours[Arrays.asList(colours).indexOf(colour)]==0) {
                    choice = 1;
                    taken_colours[Arrays.asList(colours).indexOf(colour)] = 1;
                }
                else {
                    System.out.println("This colour is not available or non-existent");
                }
            }



            //Choosing player's pawn
            String pawn_shape = null;
            choice = 0;

            while (choice == 0) {
                System.out.print("Choose your shape from the list (");
                for (int j=0; j<hm_pawns; j++)
                    if (taken_shapes[j] == 0)
                        System.out.print(pawn_shapes[j] + ", ");

                System.out.print("): ");
                pawn_shape = in.nextLine().toLowerCase();

                if (Arrays.asList(pawn_shapes).contains(pawn_shape) && taken_shapes[Arrays.asList(pawn_shapes).indexOf(pawn_shape)]==0) {
                    choice = 1;
                    taken_shapes[Arrays.asList(pawn_shapes).indexOf(pawn_shape)] = 1;
                }
                else {
                    System.out.println("This shape is not available or non-existent");
                }
            }
            players[i] = new Players(name, colour, pawn_shape, i);
        }

        // TESTING THAT PLAYERS ARE ADDED CORRECTLY
        // for (int i=0; i<nop; i++)
        //     System.out.println(players[i].name + ", " + players[i].colour + ", " + players[i].pawn_shape + ", $" + players[i].cash);
    }

    public void play() {
        System.out.println();
        for (int round = 0; round < nor; round++) {
            for (int player = 0; player < nop; player++) {

                //Position the player went on
                int dice = board.throwDice();
                players[player].board_position+=dice;
                if (players[player].board_position>40) {
                    players[player].cash+=200;
                    players[player].board_position-=40;
                    System.out.println(players[player].name + " moved to position " + players[player].board_position + " after rolling a " + dice + " and won 200$ for passing through the Start");
                } else {
                    System.out.println(players[player].name + " moved to position " + players[player].board_position + " after rolling a " + dice);
                }

                //Squares Management
                Square square = board.squares.get(players[player].board_position-1);
                if (square.buyable) {
                    if (square.bought) {
                        if (players[player].cash >= square.price) {
                            players[player].cash -= square.price;
                            players[square.owner].cash += square.price;
                            System.out.println(players[player].name + " is on " + players[square.owner].name + "'s property and has paid $" + square.price + " rent");
                        } else {
                            System.out.println(players[player].name + " is too poor to pay " + players[square.owner].name + "'s rent");
                        }
                    } else {
                        if (players[player].cash >= square.price) {
                            players[player].cash -= square.price;
                            square.owner = player;
                            System.out.println(players[player].name + " paid " + square.price + " and got the Property " + square.name);
                            players[player].property_value += square.price;
                        } else {
                            System.out.println(players[player].name + " is too poor to buy the Property " + square.name);
                        }
                    }
                }


                System.out.println("\n");
            }
        }

        int winner = 0;
        for (int i=1; i<nop; i++) {
            int winnervalue = players[winner].cash+players[winner].property_value;
            int checkvalue = players[i].cash+players[i].property_value;
            if (winnervalue < checkvalue) {
                winner = i;
            } else if (winnervalue == checkvalue) {
                if (players[winner].board_position < players[i].board_position) {
                    winner = i;
                }
            }
        }

        System.out.println("\n"+ players[winner].name + " has won the game with $" + players[winner].cash + " cash and $" + players[winner].property_value + " as Property Value. Total value: $" + (players[winner].cash+players[winner].property_value));
        System.out.println("Other players results: ");
        for (int i=0; i<nop; i++) {
            if (i!=winner) {
                System.out.println(players[i].name + " has $" + players[i].cash + " cash and $" + players[winner].property_value + " as Property Value. Total: $" + (players[i].cash+players[i].property_value));
            }
        }
    }
}