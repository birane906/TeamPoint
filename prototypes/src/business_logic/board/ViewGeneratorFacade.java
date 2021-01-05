package business_logic.board;

import business_logic.BoardFacade;
import business_logic.board.types.Type;
import business_logic.workspace.Workspace;
import dao.MySQLBoardDAO;

import java.util.ArrayList;

public class ViewGeneratorFacade {

    /**
     * The current {@link ViewGeneratorFacade} loaded in the {@link ViewGeneratorFacade}
     */
    //public Board currentBoard = BoardFacade.getBoardFacadeInstance().getCurrentBoard();

    public Board currentBoard;

    public void setCurrentBoard(Board currentBoard) {
        this.currentBoard = currentBoard;
    }

    /**
     * The {@link ViewGeneratorFacade} <code>static</code> nested class
     * guarantees the uniqueness of {@link ViewGeneratorFacade} instance
     */
    private static class ViewGeneratorFacadeHolder {
        /**
         * The unique instance of {@link ViewGeneratorFacade}
         */
        private static final ViewGeneratorFacade VIEW_GENERATOR_FACADE = new ViewGeneratorFacade();
    }

    /**
     * <code>static</code> method. Gives the unique instance of {@link BoardFacade}
     * @return The {@link BoardFacade}
     */
    public static ViewGeneratorFacade getViewGeneratorFacadeInstance() {
        return ViewGeneratorFacade.ViewGeneratorFacadeHolder.VIEW_GENERATOR_FACADE;
    }

    public void generateKanbanView() {
        // Recupère tous les statusType du board
        // Récupère tous les item
        // classe les item dans autant de liste qu'il n'y a de statusLabel différent
        // Renvoi les listes avec les noms des type en premier

        System.out.println(currentBoard.getColumns().size());

        ArrayList<Type> types = new ArrayList<>();
        for(int i = 0; i < currentBoard.getColumns().size(); i++) {
            Type type = currentBoard.getColumns().get(i).getColumnType();

            if(type.getNameType().equals("StatusType")) {
                types.add(type);
                System.out.println(type);
            }
        }
    }

    public void generateGanttView() {
        // recup les date, timeline et person type
        //
    }

    public static void main(String[] args) {
        ViewGeneratorFacade view = ViewGeneratorFacade.getViewGeneratorFacadeInstance();

        MySQLBoardDAO mySQL = new MySQLBoardDAO();

        Workspace parentWorkspace = new Workspace("salut", 0);
        Board board = mySQL.getBoardsOfWorkspace(parentWorkspace).get(0);
        Board currentBoard = mySQL.retrieveBoard(board);

        view.setCurrentBoard(currentBoard);

        System.out.println(view.currentBoard);

        view.generateKanbanView();
    }


}
