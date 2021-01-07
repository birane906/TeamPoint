package business_logic.board.chart;

import business_logic.board.Board;
import business_logic.board.Cell;
import business_logic.board.Column;
import business_logic.board.Item;
import business_logic.board.types.StatusLabel;
import business_logic.board.types.StatusType;
import business_logic.board.types.Type;

import java.util.ArrayList;
import java.util.List;

public class Kanban {

    private List<KanbanColumn> tabs;

    public Kanban(Board board, Column<StatusType> column) {
        this.tabs = new ArrayList<>();
        
        //retreive all the status labels existing in the column
        List<Cell<? extends Type>> colCells = column.getCells();
        StatusType statusType = (StatusType) colCells.get(0).getValue();
        List<StatusLabel> statusLabels = statusType.getStatusLabels();

        //for each one of them
        for (StatusLabel statusLbl : statusLabels) {
            //build the list of items
            List<Item> items = new ArrayList<>();

            for (Cell<? extends Type> cell : colCells) {
                StatusType cellstatusType = (StatusType) cell.getValue();
                StatusLabel cellStatusLabel =cellstatusType.getCurrentStatusLabel();
                //if this StatusLabel is the same as the current one
                if (cellStatusLabel.getLabel().equals(statusLbl.getLabel()) &&
                    cellStatusLabel.getColor().equals(statusLbl.getColor())) {
                        items.add(cell.getItem()); // we add the item
                }
            }

            this.tabs.add(new KanbanColumn(items, statusLbl));
        }
    }

    public List<List<Item>> getListItem() {
        return null;
    }

    public List<StatusLabel> getStatusColumnName() {
        return null;
    }
}
