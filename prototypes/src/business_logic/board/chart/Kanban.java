package business_logic.board.chart;

import business_logic.board.Item;
import business_logic.board.types.StatusLabel;

import java.util.List;

public class Kanban {

    private final List<List<Item>> listItem;
    private final List<StatusLabel> statusColumnName;

    public Kanban(List<List<Item>> listItem, List<StatusLabel> statusColumnName) {
        this.listItem = listItem;
        this.statusColumnName = statusColumnName;
    }

    public List<List<Item>> getListItem() {
        return listItem;
    }

    public List<StatusLabel> getStatusColumnName() {
        return statusColumnName;
    }
}
