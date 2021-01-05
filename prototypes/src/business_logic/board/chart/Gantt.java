package business_logic.board.chart;

import business_logic.board.Item;

import java.util.Date;
import java.util.List;

public class Gantt {

    private final List<Item> listItem;
    private final Date startDate, endDate;

    public Gantt(List<Item> listItem, Date startDate, Date endDate) {
        this.listItem = listItem;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<Item> getListItem() {
        return listItem;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
