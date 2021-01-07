package business_logic.board.chart;

import java.util.List;

import business_logic.board.Item;
import business_logic.board.types.StatusLabel;

public class KanbanColumn {
    private List<Item> items;
    private StatusLabel statusLabel;

    public KanbanColumn(List<Item> items, StatusLabel statusLabel) {
        this.items = items;
        this.statusLabel = statusLabel;
    }

    public List<Item> getItems() {
        return items;
    }

    public StatusLabel getStatusLabel() {
        return statusLabel;
    }

    public void addItems(Item item) {
        this.items.add(item);
    }
}
